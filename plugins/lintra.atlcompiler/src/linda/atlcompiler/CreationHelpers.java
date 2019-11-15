package linda.atlcompiler;

import static linda.atlcompiler.CreationHelpers.createTextExp;
import static linda.atlcompiler.CreationHelpers.refVar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import a2l.compiler.ATLExtSerializer;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.LocatedElement;
import anatlyzer.atlext.OCL.VariableDeclaration;
import lintra.atlcompiler.javagen.IteratorLoop;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JComment;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JExprStatement;
import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JForeach;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JInvokeStatic;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JReturn;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JText;
import lintra.atlcompiler.javagen.JTextExp;
import lintra.atlcompiler.javagen.JThis;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVarExp;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;

public class CreationHelpers {

	public static JAssignment createAssignment(JVariableDeclaration var, String text) {
		JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
		assignment.setDeclaration(var);
		assignment.setBody(text);
		return assignment;
	}

	public static JAssignment createAssignment(JVariableDeclaration var, JExpression expr) {
		JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
		assignment.setDeclaration(var);
		assignment.setRightPart(expr);
		return assignment;
	}
	
	public static JExprStatement createExpresionStatement(JExpression exp) {
		JExprStatement es = JavagenFactory.eINSTANCE.createJExprStatement();
		es.setExpr(exp);
		return es;
	}
		
	public static JComment createComment(String comment) {
		JComment comm = JavagenFactory.eINSTANCE.createJComment();
		comm.setValue(comment);
		return comm;
	}
	
	public static List<JStatement> createCommentedList(LocatedElement elem) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		stms.add(createComment(elem.getLocation() + ": " + ATLExtSerializer.serialize(elem)));
		return stms;
	}
	
	public static JExpression createTextExp(String body) {
		JTextExp exp = JavagenFactory.eINSTANCE.createJTextExp();
		exp.setBody(body);
		return exp;
	}
	
	public static JConditional createSimpleIf(String conditional, List<JStatement> stmts) {
		return createSimpleIf(createTextExp(conditional), stmts);
	}
	
	public static JConditional createSimpleIf(JExpression conditional, List<JStatement> stmts) {
		JConditional cond = JavagenFactory.eINSTANCE.createJConditional();
		JConditionalBlock ifBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
		ifBlock.setExpr(conditional);
		ifBlock.getStatements().addAll(stmts);
		cond.getConditions().add(ifBlock);
		return cond;
	}

	public static IteratorLoop createIterator(String newVarName, String getIteratorExpression, JTypeRef iteratorType, JTypeRef loopVarType) {
		IteratorLoop loop = JavagenFactory.eINSTANCE.createIteratorLoop();
		
		JVariableDeclaration var = JavagenFactory.eINSTANCE.createJVariableDeclaration();
		var.setName(newVarName + "_it");
		var.setType(iteratorType);
		
		loop.setIteratorVar(var);
		loop.setIteratorInit(createTextExp(getIteratorExpression));
		
		JVariableDeclaration vd = createLoopVar(newVarName, loopVarType);
		
		loop.setLoopVar(vd);
		
		return loop;
	}
	
	
	public static JText createText(String text) {
		JText txt = JavagenFactory.eINSTANCE.createJText();
		txt.setBody(text);
		return txt;
	}

	public static JVarExp refVar(JVariableDeclaration dcl) {
		JVarExp var = JavagenFactory.eINSTANCE.createJVarExp();
		var.setReference(dcl);
		return var;
	}

	public static JParameter createParameter(String varName, JTypeRef typeref) {
		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		param1.setName(varName);
		param1.setType(typeref);
		return param1;
	}

	public static JForeach createForeach(String newVarName, JVariableDeclaration collection, JTypeRef iteratorType) {
		JForeach foreach = JavagenFactory.eINSTANCE.createJForeach();
		foreach.setCollection( refVar(collection) );
		
		JVariableDeclaration vd = createLoopVar(newVarName, iteratorType);
		
		foreach.setLoopVar(vd);
		
		return foreach;
	}
	
	public static JForeach createForeach(JVariableDeclaration collection, JVariableDeclaration loopVar) {
		JForeach foreach = JavagenFactory.eINSTANCE.createJForeach();
		foreach.setCollection( refVar(collection) );
		
		foreach.setLoopVar(loopVar);
		
		return foreach;
	}

	public static JVariableDeclaration createLoopVar(String newVarName, JTypeRef iteratorType) {
		JVariableDeclaration vd = JavagenFactory.eINSTANCE.createJVariableDeclaration();
		vd.setName(newVarName);
		// Must be a collection
		vd.setType( iteratorType );
		return vd;
	}

	public static JParameter createClosureParam(String newVarName, JTypeRef type) {
		JParameter vd = JavagenFactory.eINSTANCE.createJParameter();
		vd.setName(newVarName);
		vd.setType(type);
		return vd;
	}
	
	public static JInvoke createInvoke(String methodName, JVariableDeclaration receptor, JVariableDeclaration... args) {
		JInvoke invoke = JavagenFactory.eINSTANCE.createJInvoke();
		invoke.setName(methodName);
		invoke.setObj(refVar(receptor));
		for (JVariableDeclaration v : args) {
			invoke.getArguments().add(refVar(v));
		}
		return invoke;
	}

	public static JInvoke createInvoke(String methodName, JExpression receptor, JExpression... args) {
		JInvoke invoke = JavagenFactory.eINSTANCE.createJInvoke();
		invoke.setName(methodName);
		invoke.setObj(receptor);
		for (JExpression v : args) {
			invoke.getArguments().add(v);
		}
		return invoke;
	}


	public static JInvokeStatic createInvokeStatic(String name, JExpression... args) {
		JInvokeStatic invoke = JavagenFactory.eINSTANCE.createJInvokeStatic();
		invoke.setName(name);
		for (JExpression v : args) {
			invoke.getArguments().add(v);
		}
		return invoke;		
	}

	
	// Text facilities
	

	public static String quote(String string) {
		return "\"" + string + "\"";
	}
	
	public static void addStm(JBlock m, List<JStatement> stm) {
		stm.forEach(s -> addStm(m, s));
	}
	
	public static void addStm(JBlock m, JStatement stm) {
		m.getStatements().add(stm);
	}
	
	public static void addStm(JBlock m, String string) {
		m.getStatements().add(createText(string));
	}

	public static String toStr(JTypeRef type) {
		return toStr(type.getType());
	}

	/**
	 * Returns the Java name of the type.
	 * For classes (JClass) the name is qualified to avoid problems when
	 * different meta-models have the same meta-class name.
	 * @param type
	 * @return
	 */
	public static String toStr(JType type) {
		if ( type instanceof JMetaType ) {
			return ((JMetaType) type).getQualifiedJavaName();
		}
		return type.getName();
	}

	public static JVarExp refToThis(JClass jc) {
		if( jc.getThis_() == null ) {
			jc.setThis_(JavagenFactory.eINSTANCE.createJThis());
			jc.getThis_().setName("this");
		}
		return refVar(jc.getThis_());
	}

	public static JReturn createReturn(JExpression expr) {
		JReturn ret = JavagenFactory.eINSTANCE.createJReturn();
		ret.setResult(expr);
		return ret;
	}

	public static JMethod createSetter(ITyping typ, JClass gclass, JAttribute attribute, String methodName) {
		return createSetter(typ, gclass, attribute, methodName, (method) -> { });
	}
	
	public static JMethod createSetter(ITyping typ, JClass gclass, JAttribute attribute, String methodName, Consumer<JMethod> extender) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName(methodName);
		gclass.getMethods().add(method);
		
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);


		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("n");
		param1.setType(typ.createTypeRef(attribute.getType().getType().getName()));

		method.getParameters().add(param1);
	
		method.getStatements().add( CreationHelpers.createAssignment(attribute, CreationHelpers.refVar(param1)) );

		extender.accept(method);

		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refToThis(gclass)));		
		
	
		return method;
	}
	
}
