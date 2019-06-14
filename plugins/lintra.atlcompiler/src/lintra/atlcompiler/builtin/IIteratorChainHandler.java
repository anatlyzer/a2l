package lintra.atlcompiler.builtin;

import static linda.atlcompiler.CreationHelpers.createSimpleIf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import a2l.compiler.VarStatementPair;
import a2l.driver.ICollectionsDriver;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.ICompilationContext.Context;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public interface IIteratorChainHandler {
	
	public String getIteratorName();
	
	public VarStatementPair compile(Context ctx, IteratorChainExp self, JVariableDeclaration source, ICollectionsDriver mutableDriver);
	
	
	public abstract class Abstract implements IIteratorChainHandler {

		private String name;

		public Abstract(String name) {
			this.name = name;
		}
		
		@Override
		public String getIteratorName() {
			return name;
		}		
		
		protected List<JStatement> newStatements() {
			ArrayList<JStatement> stms = new ArrayList<JStatement>();
			return stms;
		}
		
		protected JBlock compileFoldedSelects(List<IteratorChainElement> chain, CompilationEnv env, JBlock currentBlock) {
			JConditional selectIfStm = null;
			for(int i = chain.size() - 1; i >= 0; i--) {
				IteratorChainElement nextSelect = chain.get(i);
				List<JStatement> nextStms = env.getStatements(nextSelect.getBody());
				
				currentBlock.getStatements().addAll(nextStms);
				
				selectIfStm = createSimpleIf(env.getVar(nextSelect.getBody()).getName() + " == true", Collections.emptyList());
				
				currentBlock.getStatements().add(selectIfStm);
				
				currentBlock = selectIfStm.getConditions().get(0);
			}
			return currentBlock;
		}

		
	}
	
}
