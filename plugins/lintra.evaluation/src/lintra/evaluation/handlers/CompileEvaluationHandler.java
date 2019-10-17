package lintra.evaluation.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import a2l.compiler.A2LOptimiser.Optimisation;
import lintra.evaluation.handlers.CompileTestCasesHandler.TransformationToCompile;

public class CompileEvaluationHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Map<String, String> projects = new HashMap<>();
		projects.put("/a2l.tests.dblp/transformations/DBLP_v1.atl", "a2l.tests.dblp_v1");
		projects.put("/a2l.tests.dblp/transformations/DBLP_v2.atl", "a2l.tests.dblp_v2");
		projects.put("/a2l.tests.imdb/transformations/IdentityIMDb.atl", "a2l.tests.imdb.identity");
		projects.put("/a2l.tests.imdb/transformations/FindCouples.atl", "a2l.tests.findcouples");		
		projects.put("/a2l.tests.java2uml/transformations/java2uml_deps.atl", "a2l.tests.java2uml.umldeps");
		projects.put("/a2l.tests.java2graph/transformations/Java2Graph.atl", "a2l.tests.java2graph");
		projects.put("/a2l.tests.airquality/transformations/AirQualityReport.atl", "a2l.tests.airquality");
		
		List<TransformationToCompile> trafos = new ArrayList<CompileTestCasesHandler.TransformationToCompile>();
		List<TransformationToCompile> trafosNoOps = new ArrayList<CompileTestCasesHandler.TransformationToCompile>();

		for (Entry<String, String> path : projects.entrySet()) {
			TransformationToCompile t = new TransformationToCompile(path.getKey());
			HashSet<Optimisation> optimisations = new HashSet<Optimisation>();
			Collections.addAll(optimisations, Optimisation.values());
			
			if ( ! (path.getValue().equals("a2l.tests.findcouples") && path.getValue().equals("a2l.tests.dblp_v2") )) {
				optimisations.remove(Optimisation.PATH_BASED_CACHING);
			}
			
			t.setPackageName(path.getValue() + ".optimised");			
			t.setOptimisations(optimisations);
			
			TransformationToCompile noOp = new TransformationToCompile(path.getKey());			
			noOp.setPackageName(path.getValue() + ".normal");
			noOp.setOptimisations(Collections.emptySet());
			
			trafos.add(t);
			trafosNoOps.add(noOp);
		}
		
		CompileTestCasesHandler.compileAll(trafos);
		CompileTestCasesHandler.compileAll(trafosNoOps);
		
		return null;
	}

}
