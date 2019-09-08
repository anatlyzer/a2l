package linda.atlcompiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.UnionType;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.VariableDeclaration;
import linda.atlcompiler.BaseTyping.TupleTypeInformation;
import linda.atlcompiler.ITyping.MutabilityAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public class CompilationEnv {

	protected HashMap<EObject, JVariableDeclaration> map = new HashMap<>();
	protected HashMap<EObject, List<JStatement>> mapStatements = new HashMap<>();
	protected HashMap<EObject, List<Object>> mapAttributes = new HashMap<>();
	protected ArrayList<JBlock> blocks = new ArrayList<>();
		
	protected List<CompilationEnv> stack = new ArrayList<CompilationEnv>();
	private IAnalyserResult result;
	private DriverConfiguration drivers;
	private Set<TupleTypeInformation> usedTupleTypes;
	
	public CompilationEnv(IAnalyserResult result, DriverConfiguration drivers) {
		this.result = result;
		this.drivers = drivers;
	}

	public void setUsedTupleTypes(Set<? extends TupleTypeInformation> usedTupleTypes) {
		this.usedTupleTypes = new HashSet<TupleTypeInformation>(usedTupleTypes);
	}
	
	public Set<? extends TupleTypeInformation> getUsedTupleTypes() {
		return usedTupleTypes;
	}

	public IAnalyserResult getAnalysis() {
		return result;
	}
	
	public void copyScope() {
		CompilationEnv env = new CompilationEnv(result, drivers);
		env.map = new HashMap<EObject, JVariableDeclaration>(map);
		env.mapStatements = new HashMap<EObject, List<JStatement>>(mapStatements);
		env.blocks = new ArrayList<JBlock>(blocks);
		env.drivers = drivers;
		
		stack.add(0, env);
	}
	
	public void closeScope() {
		CompilationEnv env = stack.remove(0);
		map = env.map;
		mapStatements = env.mapStatements;
		blocks = env.blocks;
	}
	
	public void pushBlock(JBlock block) {
		if ( block == null ) throw new IllegalStateException();
		blocks.add(block);
	}

	public JBlock currentBlock() {
		return blocks.get(blocks.size() - 1);
	}

	public void popBlock() {
		blocks.remove(blocks.get(blocks.size() - 1));
	}
	
	
	public JVariableDeclaration getVar(EObject e) {
		if ( ! map.containsKey(e)) {
			throw new IllegalStateException("No key for: " + e);
		}
		return map.get(e);
	}
	
	public <T> T getAttribute(EObject e, Class<T> klass, T defaultValue) {
		List<Object> attributes = mapAttributes.get(e);
		if ( attributes == null ) {
			return defaultValue;
		}
		
		for (Object obj : attributes) {
			if ( klass.isInstance(obj) ) {
				return klass.cast(obj);
			}
		}
		
		return defaultValue;
	}

	
	public List<JStatement> getStatements(EObject e) {
		if ( ! mapStatements.containsKey(e)) {
			throw new IllegalStateException("No key for: " + e);
		}
		return mapStatements.get(e);
	}

	public void bind(EObject self, JVariableDeclaration var) {		
		map.put(self, var);
	}
	
	public void bind(EObject self, JVariableDeclaration var, List<JStatement> list, Object... attributes) {		
		map.put(self, var);
		mapStatements.put(self, list);		
		if ( attributes.length > 0 ) {
			mapAttributes.put(self, Arrays.asList(attributes));
		}
	}

	public void bind(EObject self, List<JStatement> list) {		
		mapStatements.put(self, list);		
	}
	
	public void rebind(EObject self, JVariableDeclaration newVar) {
		if ( map.get(self) == null ) 
			throw new IllegalStateException(self + " is not bound");
		
		map.put(self, newVar);
	}

	
	public IMetaDriver getDriver(VariableDeclaration var) {
		return drivers.get(((OclModelElement) var.getType()).getModel().getName());
	}

	public IMetaDriver getDriver(OclExpression source) {
		if ( source.getInferredType() instanceof UnionType || source.getInferredType() instanceof CollectionType ) {
			List<Metaclass> metaclasses = TypingModel.getInvolvedMetaclassesOfType(source.getInferredType());
			if ( metaclasses.stream().map(m -> m.getModel().getName()).distinct().count() == 1  ) {
				return getDriver(metaclasses.get(0));
			} else {
				throw new UnsupportedTranslation("Cannot get the driver for union type of different meta-models: " + source);
			}
		} else {
			return getDriver((Metaclass) source.getInferredType());
		}
	}
	
	public IMetaDriver getDriver(Metaclass m) {
		return getDriver(m.getModel().getName());
	}
	
	public IMetaDriver getDriver(String mmName) {
		return drivers.get(mmName);
	}

}
