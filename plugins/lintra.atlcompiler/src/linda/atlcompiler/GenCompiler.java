package linda.atlcompiler;

import java.util.HashMap;

import anatlyzer.atlext.ATL.CalledRule;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.VariableDeclaration;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;

public class GenCompiler {

	protected HashMap<Helper, JMethod>   helperToMethod   = new HashMap<>();
	protected HashMap<LazyRule, JMethod> lazyRuleToMethod = new HashMap<>();
	protected HashMap<CalledRule, JMethod> calledRuleToMethod = new HashMap<>();
	
	private int varCounter = 0;
	public JVariableDeclaration addLocalVar(JBlock method, String varName, JTypeRef type) {
		JVariableDeclaration var = JavagenFactory.eINSTANCE.createJVariableDeclaration();
		var.setName(varName + varCounter++);
		var.setType(type);		
		method.getLocalVars().add(var);
		return var;
	}
	
	public String uniqueVarName(VariableDeclaration vd) {
		return vd.getVarName() + varCounter++;
	}
}
