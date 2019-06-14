package javagen.visitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("unchecked")
public class AbstractJavaGenVisitor  {
	protected boolean _debug = false;
	protected EObject current;
	
	public VisitingActions preJBlock(lintra.atlcompiler.javagen.JBlock self) { return new VisitingActions("localVars" , "statements"); } 
	public void inJBlock(lintra.atlcompiler.javagen.JBlock self) { if ( _debug ) System.out.println("Visiting JBlock"); }
	public void beforeJBlock(lintra.atlcompiler.javagen.JBlock self) { }
	public void afterJBlock(lintra.atlcompiler.javagen.JBlock self) { }
	public VisitingActions preJNewObject(lintra.atlcompiler.javagen.JNewObject self) { return new VisitingActions("typeRef" , "arguments"); } 
	public void inJNewObject(lintra.atlcompiler.javagen.JNewObject self) { if ( _debug ) System.out.println("Visiting JNewObject"); }
	public void beforeJNewObject(lintra.atlcompiler.javagen.JNewObject self) { }
	public void afterJNewObject(lintra.atlcompiler.javagen.JNewObject self) { }
	public VisitingActions preJTextExp(lintra.atlcompiler.javagen.JTextExp self) { return new VisitingActions(); } 
	public void inJTextExp(lintra.atlcompiler.javagen.JTextExp self) { if ( _debug ) System.out.println("Visiting JTextExp"); }
	public void beforeJTextExp(lintra.atlcompiler.javagen.JTextExp self) { }
	public void afterJTextExp(lintra.atlcompiler.javagen.JTextExp self) { }
	public VisitingActions preJAttribute(lintra.atlcompiler.javagen.JAttribute self) { return new VisitingActions("type"); } 
	public void inJAttribute(lintra.atlcompiler.javagen.JAttribute self) { if ( _debug ) System.out.println("Visiting JAttribute"); }
	public void beforeJAttribute(lintra.atlcompiler.javagen.JAttribute self) { }
	public void afterJAttribute(lintra.atlcompiler.javagen.JAttribute self) { }
	public VisitingActions preJReturn(lintra.atlcompiler.javagen.JReturn self) { return new VisitingActions("result"); } 
	public void inJReturn(lintra.atlcompiler.javagen.JReturn self) { if ( _debug ) System.out.println("Visiting JReturn"); }
	public void beforeJReturn(lintra.atlcompiler.javagen.JReturn self) { }
	public void afterJReturn(lintra.atlcompiler.javagen.JReturn self) { }
	public VisitingActions preJClass(lintra.atlcompiler.javagen.JClass self) { return new VisitingActions("methods" , "attributes" , "implements" , "extends_" , "this_"); } 
	public void inJClass(lintra.atlcompiler.javagen.JClass self) { if ( _debug ) System.out.println("Visiting JClass"); }
	public void beforeJClass(lintra.atlcompiler.javagen.JClass self) { }
	public void afterJClass(lintra.atlcompiler.javagen.JClass self) { }
	public VisitingActions preJInvoke(lintra.atlcompiler.javagen.JInvoke self) { return new VisitingActions("obj" , "arguments"); } 
	public void inJInvoke(lintra.atlcompiler.javagen.JInvoke self) { if ( _debug ) System.out.println("Visiting JInvoke"); }
	public void beforeJInvoke(lintra.atlcompiler.javagen.JInvoke self) { }
	public void afterJInvoke(lintra.atlcompiler.javagen.JInvoke self) { }
	public VisitingActions preJAssignment(lintra.atlcompiler.javagen.JAssignment self) { return new VisitingActions("rightPart"); } 
	public void inJAssignment(lintra.atlcompiler.javagen.JAssignment self) { if ( _debug ) System.out.println("Visiting JAssignment"); }
	public void beforeJAssignment(lintra.atlcompiler.javagen.JAssignment self) { }
	public void afterJAssignment(lintra.atlcompiler.javagen.JAssignment self) { }
	public VisitingActions preJLibType(lintra.atlcompiler.javagen.JLibType self) { return new VisitingActions(); } 
	public void inJLibType(lintra.atlcompiler.javagen.JLibType self) { if ( _debug ) System.out.println("Visiting JLibType"); }
	public void beforeJLibType(lintra.atlcompiler.javagen.JLibType self) { }
	public void afterJLibType(lintra.atlcompiler.javagen.JLibType self) { }
	public VisitingActions preJParameter(lintra.atlcompiler.javagen.JParameter self) { return new VisitingActions("type"); } 
	public void inJParameter(lintra.atlcompiler.javagen.JParameter self) { if ( _debug ) System.out.println("Visiting JParameter"); }
	public void beforeJParameter(lintra.atlcompiler.javagen.JParameter self) { }
	public void afterJParameter(lintra.atlcompiler.javagen.JParameter self) { }
	public VisitingActions preJClosure(lintra.atlcompiler.javagen.JClosure self) { return new VisitingActions("localVars" , "statements" , "parameters"); } 
	public void inJClosure(lintra.atlcompiler.javagen.JClosure self) { if ( _debug ) System.out.println("Visiting JClosure"); }
	public void beforeJClosure(lintra.atlcompiler.javagen.JClosure self) { }
	public void afterJClosure(lintra.atlcompiler.javagen.JClosure self) { }
	public VisitingActions preJExprStatement(lintra.atlcompiler.javagen.JExprStatement self) { return new VisitingActions("expr"); } 
	public void inJExprStatement(lintra.atlcompiler.javagen.JExprStatement self) { if ( _debug ) System.out.println("Visiting JExprStatement"); }
	public void beforeJExprStatement(lintra.atlcompiler.javagen.JExprStatement self) { }
	public void afterJExprStatement(lintra.atlcompiler.javagen.JExprStatement self) { }
	public VisitingActions preJStatement(lintra.atlcompiler.javagen.JStatement self) { return new VisitingActions(); } 
	public void inJStatement(lintra.atlcompiler.javagen.JStatement self) { if ( _debug ) System.out.println("Visiting JStatement"); }
	public void beforeJStatement(lintra.atlcompiler.javagen.JStatement self) { }
	public void afterJStatement(lintra.atlcompiler.javagen.JStatement self) { }
	public VisitingActions preIteratorLoop(lintra.atlcompiler.javagen.IteratorLoop self) { return new VisitingActions("localVars" , "statements" , "loopVar" , "iteratorVar" , "iteratorInit"); } 
	public void inIteratorLoop(lintra.atlcompiler.javagen.IteratorLoop self) { if ( _debug ) System.out.println("Visiting IteratorLoop"); }
	public void beforeIteratorLoop(lintra.atlcompiler.javagen.IteratorLoop self) { }
	public void afterIteratorLoop(lintra.atlcompiler.javagen.IteratorLoop self) { }
	public VisitingActions preJThis(lintra.atlcompiler.javagen.JThis self) { return new VisitingActions("type"); } 
	public void inJThis(lintra.atlcompiler.javagen.JThis self) { if ( _debug ) System.out.println("Visiting JThis"); }
	public void beforeJThis(lintra.atlcompiler.javagen.JThis self) { }
	public void afterJThis(lintra.atlcompiler.javagen.JThis self) { }
	public VisitingActions preJText(lintra.atlcompiler.javagen.JText self) { return new VisitingActions(); } 
	public void inJText(lintra.atlcompiler.javagen.JText self) { if ( _debug ) System.out.println("Visiting JText"); }
	public void beforeJText(lintra.atlcompiler.javagen.JText self) { }
	public void afterJText(lintra.atlcompiler.javagen.JText self) { }
	public VisitingActions preJConditionalBlock(lintra.atlcompiler.javagen.JConditionalBlock self) { return new VisitingActions("localVars" , "statements" , "expr"); } 
	public void inJConditionalBlock(lintra.atlcompiler.javagen.JConditionalBlock self) { if ( _debug ) System.out.println("Visiting JConditionalBlock"); }
	public void beforeJConditionalBlock(lintra.atlcompiler.javagen.JConditionalBlock self) { }
	public void afterJConditionalBlock(lintra.atlcompiler.javagen.JConditionalBlock self) { }
	public VisitingActions preJParamTypeRef(lintra.atlcompiler.javagen.JParamTypeRef self) { return new VisitingActions("containedType"); } 
	public void inJParamTypeRef(lintra.atlcompiler.javagen.JParamTypeRef self) { if ( _debug ) System.out.println("Visiting JParamTypeRef"); }
	public void beforeJParamTypeRef(lintra.atlcompiler.javagen.JParamTypeRef self) { }
	public void afterJParamTypeRef(lintra.atlcompiler.javagen.JParamTypeRef self) { }
	public VisitingActions preJMetaType(lintra.atlcompiler.javagen.JMetaType self) { return new VisitingActions(); } 
	public void inJMetaType(lintra.atlcompiler.javagen.JMetaType self) { if ( _debug ) System.out.println("Visiting JMetaType"); }
	public void beforeJMetaType(lintra.atlcompiler.javagen.JMetaType self) { }
	public void afterJMetaType(lintra.atlcompiler.javagen.JMetaType self) { }
	public VisitingActions preJTypeRef(lintra.atlcompiler.javagen.JTypeRef self) { return new VisitingActions(); } 
	public void inJTypeRef(lintra.atlcompiler.javagen.JTypeRef self) { if ( _debug ) System.out.println("Visiting JTypeRef"); }
	public void beforeJTypeRef(lintra.atlcompiler.javagen.JTypeRef self) { }
	public void afterJTypeRef(lintra.atlcompiler.javagen.JTypeRef self) { }
	public VisitingActions preJExpression(lintra.atlcompiler.javagen.JExpression self) { return new VisitingActions(); } 
	public void inJExpression(lintra.atlcompiler.javagen.JExpression self) { if ( _debug ) System.out.println("Visiting JExpression"); }
	public void beforeJExpression(lintra.atlcompiler.javagen.JExpression self) { }
	public void afterJExpression(lintra.atlcompiler.javagen.JExpression self) { }
	public VisitingActions preJavaGenModel(lintra.atlcompiler.javagen.JavaGenModel self) { return new VisitingActions("libTypes" , "metaTypes" , "classes"); } 
	public void inJavaGenModel(lintra.atlcompiler.javagen.JavaGenModel self) { if ( _debug ) System.out.println("Visiting JavaGenModel"); }
	public void beforeJavaGenModel(lintra.atlcompiler.javagen.JavaGenModel self) { }
	public void afterJavaGenModel(lintra.atlcompiler.javagen.JavaGenModel self) { }
	public VisitingActions preJConditional(lintra.atlcompiler.javagen.JConditional self) { return new VisitingActions("conditions" , "else"); } 
	public void inJConditional(lintra.atlcompiler.javagen.JConditional self) { if ( _debug ) System.out.println("Visiting JConditional"); }
	public void beforeJConditional(lintra.atlcompiler.javagen.JConditional self) { }
	public void afterJConditional(lintra.atlcompiler.javagen.JConditional self) { }
	public VisitingActions preJLoop(lintra.atlcompiler.javagen.JLoop self) { return new VisitingActions("localVars" , "statements" , "loopVar"); } 
	public void inJLoop(lintra.atlcompiler.javagen.JLoop self) { if ( _debug ) System.out.println("Visiting JLoop"); }
	public void beforeJLoop(lintra.atlcompiler.javagen.JLoop self) { }
	public void afterJLoop(lintra.atlcompiler.javagen.JLoop self) { }
	public VisitingActions preJArrayTypeRef(lintra.atlcompiler.javagen.JArrayTypeRef self) { return new VisitingActions("containedType"); } 
	public void inJArrayTypeRef(lintra.atlcompiler.javagen.JArrayTypeRef self) { if ( _debug ) System.out.println("Visiting JArrayTypeRef"); }
	public void beforeJArrayTypeRef(lintra.atlcompiler.javagen.JArrayTypeRef self) { }
	public void afterJArrayTypeRef(lintra.atlcompiler.javagen.JArrayTypeRef self) { }
	public VisitingActions preLMatchCase(lintra.atlcompiler.javagen.LMatchCase self) { return new VisitingActions("localVars" , "statements" , "obj"); } 
	public void inLMatchCase(lintra.atlcompiler.javagen.LMatchCase self) { if ( _debug ) System.out.println("Visiting LMatchCase"); }
	public void beforeLMatchCase(lintra.atlcompiler.javagen.LMatchCase self) { }
	public void afterLMatchCase(lintra.atlcompiler.javagen.LMatchCase self) { }
	public VisitingActions preJComment(lintra.atlcompiler.javagen.JComment self) { return new VisitingActions(); } 
	public void inJComment(lintra.atlcompiler.javagen.JComment self) { if ( _debug ) System.out.println("Visiting JComment"); }
	public void beforeJComment(lintra.atlcompiler.javagen.JComment self) { }
	public void afterJComment(lintra.atlcompiler.javagen.JComment self) { }
	public VisitingActions preLMatchObject(lintra.atlcompiler.javagen.LMatchObject self) { return new VisitingActions("cases"); } 
	public void inLMatchObject(lintra.atlcompiler.javagen.LMatchObject self) { if ( _debug ) System.out.println("Visiting LMatchObject"); }
	public void beforeLMatchObject(lintra.atlcompiler.javagen.LMatchObject self) { }
	public void afterLMatchObject(lintra.atlcompiler.javagen.LMatchObject self) { }
	public VisitingActions preJMethod(lintra.atlcompiler.javagen.JMethod self) { return new VisitingActions("localVars" , "statements" , "parameters" , "returnType" , "throws_"); } 
	public void inJMethod(lintra.atlcompiler.javagen.JMethod self) { if ( _debug ) System.out.println("Visiting JMethod"); }
	public void beforeJMethod(lintra.atlcompiler.javagen.JMethod self) { }
	public void afterJMethod(lintra.atlcompiler.javagen.JMethod self) { }
	public VisitingActions preJVariableDeclaration(lintra.atlcompiler.javagen.JVariableDeclaration self) { return new VisitingActions("type"); } 
	public void inJVariableDeclaration(lintra.atlcompiler.javagen.JVariableDeclaration self) { if ( _debug ) System.out.println("Visiting JVariableDeclaration"); }
	public void beforeJVariableDeclaration(lintra.atlcompiler.javagen.JVariableDeclaration self) { }
	public void afterJVariableDeclaration(lintra.atlcompiler.javagen.JVariableDeclaration self) { }
	public VisitingActions preJVarExp(lintra.atlcompiler.javagen.JVarExp self) { return new VisitingActions(); } 
	public void inJVarExp(lintra.atlcompiler.javagen.JVarExp self) { if ( _debug ) System.out.println("Visiting JVarExp"); }
	public void beforeJVarExp(lintra.atlcompiler.javagen.JVarExp self) { }
	public void afterJVarExp(lintra.atlcompiler.javagen.JVarExp self) { }
	public VisitingActions preJInvokeStatic(lintra.atlcompiler.javagen.JInvokeStatic self) { return new VisitingActions("arguments"); } 
	public void inJInvokeStatic(lintra.atlcompiler.javagen.JInvokeStatic self) { if ( _debug ) System.out.println("Visiting JInvokeStatic"); }
	public void beforeJInvokeStatic(lintra.atlcompiler.javagen.JInvokeStatic self) { }
	public void afterJInvokeStatic(lintra.atlcompiler.javagen.JInvokeStatic self) { }
	public VisitingActions preJGenericTypeRef(lintra.atlcompiler.javagen.JGenericTypeRef self) { return new VisitingActions("typeParams"); } 
	public void inJGenericTypeRef(lintra.atlcompiler.javagen.JGenericTypeRef self) { if ( _debug ) System.out.println("Visiting JGenericTypeRef"); }
	public void beforeJGenericTypeRef(lintra.atlcompiler.javagen.JGenericTypeRef self) { }
	public void afterJGenericTypeRef(lintra.atlcompiler.javagen.JGenericTypeRef self) { }
	public VisitingActions preJForeach(lintra.atlcompiler.javagen.JForeach self) { return new VisitingActions("localVars" , "statements" , "loopVar" , "collection"); } 
	public void inJForeach(lintra.atlcompiler.javagen.JForeach self) { if ( _debug ) System.out.println("Visiting JForeach"); }
	public void beforeJForeach(lintra.atlcompiler.javagen.JForeach self) { }
	public void afterJForeach(lintra.atlcompiler.javagen.JForeach self) { }
	public VisitingActions preJParamNTypeRef(lintra.atlcompiler.javagen.JParamNTypeRef self) { return new VisitingActions("params"); } 
	public void inJParamNTypeRef(lintra.atlcompiler.javagen.JParamNTypeRef self) { if ( _debug ) System.out.println("Visiting JParamNTypeRef"); }
	public void beforeJParamNTypeRef(lintra.atlcompiler.javagen.JParamNTypeRef self) { }
	public void afterJParamNTypeRef(lintra.atlcompiler.javagen.JParamNTypeRef self) { }
	public VisitingActions preJType(lintra.atlcompiler.javagen.JType self) { return new VisitingActions(); } 
	public void inJType(lintra.atlcompiler.javagen.JType self) { if ( _debug ) System.out.println("Visiting JType"); }
	public void beforeJType(lintra.atlcompiler.javagen.JType self) { }
	public void afterJType(lintra.atlcompiler.javagen.JType self) { }
		
	protected VisitingActions actions(Object... things) {
		return new VisitingActions(things);
	}

	public void startVisiting(EObject init) {
		visit(init);
	}	
	
	public EObject getCurrent() { return current; }
	public void setCurrent(EObject o) { current = o; }
	
	protected void visitJNewObject(lintra.atlcompiler.javagen.JNewObject this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJNewObject(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJNewObject(this_);
		
		visitActions(v, this_);		
					
		visitor.inJNewObject(this_);
		visitor.afterJNewObject(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJTextExp(lintra.atlcompiler.javagen.JTextExp this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJTextExp(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJTextExp(this_);
		
		visitActions(v, this_);		
					
		visitor.inJTextExp(this_);
		visitor.afterJTextExp(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJAttribute(lintra.atlcompiler.javagen.JAttribute this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJAttribute(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJAttribute(this_);
		
		visitActions(v, this_);		
					
		visitor.inJAttribute(this_);
		visitor.afterJAttribute(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJReturn(lintra.atlcompiler.javagen.JReturn this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJReturn(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJReturn(this_);
		
		visitActions(v, this_);		
					
		visitor.inJReturn(this_);
		visitor.afterJReturn(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJClass(lintra.atlcompiler.javagen.JClass this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJClass(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJClass(this_);
		
		visitActions(v, this_);		
					
		visitor.inJClass(this_);
		visitor.afterJClass(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJInvoke(lintra.atlcompiler.javagen.JInvoke this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJInvoke(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJInvoke(this_);
		
		visitActions(v, this_);		
					
		visitor.inJInvoke(this_);
		visitor.afterJInvoke(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJAssignment(lintra.atlcompiler.javagen.JAssignment this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJAssignment(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJAssignment(this_);
		
		visitActions(v, this_);		
					
		visitor.inJAssignment(this_);
		visitor.afterJAssignment(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJLibType(lintra.atlcompiler.javagen.JLibType this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJLibType(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJLibType(this_);
		
		visitActions(v, this_);		
					
		visitor.inJLibType(this_);
		visitor.afterJLibType(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJParameter(lintra.atlcompiler.javagen.JParameter this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJParameter(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJParameter(this_);
		
		visitActions(v, this_);		
					
		visitor.inJParameter(this_);
		visitor.afterJParameter(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJClosure(lintra.atlcompiler.javagen.JClosure this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJClosure(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJClosure(this_);
		
		visitActions(v, this_);		
					
		visitor.inJClosure(this_);
		visitor.afterJClosure(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJExprStatement(lintra.atlcompiler.javagen.JExprStatement this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJExprStatement(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJExprStatement(this_);
		
		visitActions(v, this_);		
					
		visitor.inJExprStatement(this_);
		visitor.afterJExprStatement(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitIteratorLoop(lintra.atlcompiler.javagen.IteratorLoop this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preIteratorLoop(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeIteratorLoop(this_);
		
		visitActions(v, this_);		
					
		visitor.inIteratorLoop(this_);
		visitor.afterIteratorLoop(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJThis(lintra.atlcompiler.javagen.JThis this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJThis(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJThis(this_);
		
		visitActions(v, this_);		
					
		visitor.inJThis(this_);
		visitor.afterJThis(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJText(lintra.atlcompiler.javagen.JText this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJText(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJText(this_);
		
		visitActions(v, this_);		
					
		visitor.inJText(this_);
		visitor.afterJText(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJConditionalBlock(lintra.atlcompiler.javagen.JConditionalBlock this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJConditionalBlock(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJConditionalBlock(this_);
		
		visitActions(v, this_);		
					
		visitor.inJConditionalBlock(this_);
		visitor.afterJConditionalBlock(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJParamTypeRef(lintra.atlcompiler.javagen.JParamTypeRef this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJParamTypeRef(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJParamTypeRef(this_);
		
		visitActions(v, this_);		
					
		visitor.inJParamTypeRef(this_);
		visitor.afterJParamTypeRef(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJMetaType(lintra.atlcompiler.javagen.JMetaType this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJMetaType(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJMetaType(this_);
		
		visitActions(v, this_);		
					
		visitor.inJMetaType(this_);
		visitor.afterJMetaType(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJTypeRef(lintra.atlcompiler.javagen.JTypeRef this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJTypeRef(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJTypeRef(this_);
		
		visitActions(v, this_);		
					
		visitor.inJTypeRef(this_);
		visitor.afterJTypeRef(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJavaGenModel(lintra.atlcompiler.javagen.JavaGenModel this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJavaGenModel(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJavaGenModel(this_);
		
		visitActions(v, this_);		
					
		visitor.inJavaGenModel(this_);
		visitor.afterJavaGenModel(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJConditional(lintra.atlcompiler.javagen.JConditional this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJConditional(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJConditional(this_);
		
		visitActions(v, this_);		
					
		visitor.inJConditional(this_);
		visitor.afterJConditional(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJLoop(lintra.atlcompiler.javagen.JLoop this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJLoop(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJLoop(this_);
		
		visitActions(v, this_);		
					
		visitor.inJLoop(this_);
		visitor.afterJLoop(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJArrayTypeRef(lintra.atlcompiler.javagen.JArrayTypeRef this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJArrayTypeRef(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJArrayTypeRef(this_);
		
		visitActions(v, this_);		
					
		visitor.inJArrayTypeRef(this_);
		visitor.afterJArrayTypeRef(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitLMatchCase(lintra.atlcompiler.javagen.LMatchCase this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preLMatchCase(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeLMatchCase(this_);
		
		visitActions(v, this_);		
					
		visitor.inLMatchCase(this_);
		visitor.afterLMatchCase(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJComment(lintra.atlcompiler.javagen.JComment this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJComment(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJComment(this_);
		
		visitActions(v, this_);		
					
		visitor.inJComment(this_);
		visitor.afterJComment(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitLMatchObject(lintra.atlcompiler.javagen.LMatchObject this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preLMatchObject(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeLMatchObject(this_);
		
		visitActions(v, this_);		
					
		visitor.inLMatchObject(this_);
		visitor.afterLMatchObject(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJMethod(lintra.atlcompiler.javagen.JMethod this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJMethod(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJMethod(this_);
		
		visitActions(v, this_);		
					
		visitor.inJMethod(this_);
		visitor.afterJMethod(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJVariableDeclaration(lintra.atlcompiler.javagen.JVariableDeclaration this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJVariableDeclaration(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJVariableDeclaration(this_);
		
		visitActions(v, this_);		
					
		visitor.inJVariableDeclaration(this_);
		visitor.afterJVariableDeclaration(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJVarExp(lintra.atlcompiler.javagen.JVarExp this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJVarExp(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJVarExp(this_);
		
		visitActions(v, this_);		
					
		visitor.inJVarExp(this_);
		visitor.afterJVarExp(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJInvokeStatic(lintra.atlcompiler.javagen.JInvokeStatic this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJInvokeStatic(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJInvokeStatic(this_);
		
		visitActions(v, this_);		
					
		visitor.inJInvokeStatic(this_);
		visitor.afterJInvokeStatic(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJGenericTypeRef(lintra.atlcompiler.javagen.JGenericTypeRef this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJGenericTypeRef(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJGenericTypeRef(this_);
		
		visitActions(v, this_);		
					
		visitor.inJGenericTypeRef(this_);
		visitor.afterJGenericTypeRef(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJForeach(lintra.atlcompiler.javagen.JForeach this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJForeach(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJForeach(this_);
		
		visitActions(v, this_);		
					
		visitor.inJForeach(this_);
		visitor.afterJForeach(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitJParamNTypeRef(lintra.atlcompiler.javagen.JParamNTypeRef this_) {
		AbstractJavaGenVisitor visitor = this;
		VisitingActions v = visitor.preJParamNTypeRef(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeJParamNTypeRef(this_);
		
		visitActions(v, this_);		
					
		visitor.inJParamNTypeRef(this_);
		visitor.afterJParamNTypeRef(this_);
		visitor.setCurrent(pop);	
	} 
		
	private void visitActions(VisitingActions v, EObject this_) {
		AbstractJavaGenVisitor visitor = this;
		
		for(VisitingAction va : v.getActions(this_)) {
			if ( va.isMethodCall() ) {
				va.performMethodCall();		
			} else if ( va.isFilter() ) {
				Object res = va.performMethodCall();
				if ( res instanceof java.util.Collection ) {
					for(Object o : (java.util.Collection<?>) res) {
						visit((EObject) o);
					}
				} else {
					visit((EObject) res);
				}
			} else if ( va.isReference() ) {
				EReference r = va.getEReference();
				
				Object refObj   = this_.eGet(r);
				if ( refObj == null ) continue;
				if ( refObj instanceof java.util.Collection ) {
					for(Object o : (java.util.Collection<?>) refObj) {
						visit((EObject) o);
					}
				} else {
					visit((EObject) refObj);
				}
			}
		}
	
	}
	
	protected void visit(EObject obj) {	
	if ( obj.eClass().getName().equals("JNewObject") ) { visitJNewObject((lintra.atlcompiler.javagen.JNewObject) obj); return; }
	if ( obj.eClass().getName().equals("JTextExp") ) { visitJTextExp((lintra.atlcompiler.javagen.JTextExp) obj); return; }
	if ( obj.eClass().getName().equals("JAttribute") ) { visitJAttribute((lintra.atlcompiler.javagen.JAttribute) obj); return; }
	if ( obj.eClass().getName().equals("JReturn") ) { visitJReturn((lintra.atlcompiler.javagen.JReturn) obj); return; }
	if ( obj.eClass().getName().equals("JClass") ) { visitJClass((lintra.atlcompiler.javagen.JClass) obj); return; }
	if ( obj.eClass().getName().equals("JInvoke") ) { visitJInvoke((lintra.atlcompiler.javagen.JInvoke) obj); return; }
	if ( obj.eClass().getName().equals("JAssignment") ) { visitJAssignment((lintra.atlcompiler.javagen.JAssignment) obj); return; }
	if ( obj.eClass().getName().equals("JLibType") ) { visitJLibType((lintra.atlcompiler.javagen.JLibType) obj); return; }
	if ( obj.eClass().getName().equals("JParameter") ) { visitJParameter((lintra.atlcompiler.javagen.JParameter) obj); return; }
	if ( obj.eClass().getName().equals("JClosure") ) { visitJClosure((lintra.atlcompiler.javagen.JClosure) obj); return; }
	if ( obj.eClass().getName().equals("JExprStatement") ) { visitJExprStatement((lintra.atlcompiler.javagen.JExprStatement) obj); return; }
	if ( obj.eClass().getName().equals("IteratorLoop") ) { visitIteratorLoop((lintra.atlcompiler.javagen.IteratorLoop) obj); return; }
	if ( obj.eClass().getName().equals("JThis") ) { visitJThis((lintra.atlcompiler.javagen.JThis) obj); return; }
	if ( obj.eClass().getName().equals("JText") ) { visitJText((lintra.atlcompiler.javagen.JText) obj); return; }
	if ( obj.eClass().getName().equals("JConditionalBlock") ) { visitJConditionalBlock((lintra.atlcompiler.javagen.JConditionalBlock) obj); return; }
	if ( obj.eClass().getName().equals("JParamTypeRef") ) { visitJParamTypeRef((lintra.atlcompiler.javagen.JParamTypeRef) obj); return; }
	if ( obj.eClass().getName().equals("JMetaType") ) { visitJMetaType((lintra.atlcompiler.javagen.JMetaType) obj); return; }
	if ( obj.eClass().getName().equals("JTypeRef") ) { visitJTypeRef((lintra.atlcompiler.javagen.JTypeRef) obj); return; }
	if ( obj.eClass().getName().equals("JavaGenModel") ) { visitJavaGenModel((lintra.atlcompiler.javagen.JavaGenModel) obj); return; }
	if ( obj.eClass().getName().equals("JConditional") ) { visitJConditional((lintra.atlcompiler.javagen.JConditional) obj); return; }
	if ( obj.eClass().getName().equals("JLoop") ) { visitJLoop((lintra.atlcompiler.javagen.JLoop) obj); return; }
	if ( obj.eClass().getName().equals("JArrayTypeRef") ) { visitJArrayTypeRef((lintra.atlcompiler.javagen.JArrayTypeRef) obj); return; }
	if ( obj.eClass().getName().equals("LMatchCase") ) { visitLMatchCase((lintra.atlcompiler.javagen.LMatchCase) obj); return; }
	if ( obj.eClass().getName().equals("JComment") ) { visitJComment((lintra.atlcompiler.javagen.JComment) obj); return; }
	if ( obj.eClass().getName().equals("LMatchObject") ) { visitLMatchObject((lintra.atlcompiler.javagen.LMatchObject) obj); return; }
	if ( obj.eClass().getName().equals("JMethod") ) { visitJMethod((lintra.atlcompiler.javagen.JMethod) obj); return; }
	if ( obj.eClass().getName().equals("JVariableDeclaration") ) { visitJVariableDeclaration((lintra.atlcompiler.javagen.JVariableDeclaration) obj); return; }
	if ( obj.eClass().getName().equals("JVarExp") ) { visitJVarExp((lintra.atlcompiler.javagen.JVarExp) obj); return; }
	if ( obj.eClass().getName().equals("JInvokeStatic") ) { visitJInvokeStatic((lintra.atlcompiler.javagen.JInvokeStatic) obj); return; }
	if ( obj.eClass().getName().equals("JGenericTypeRef") ) { visitJGenericTypeRef((lintra.atlcompiler.javagen.JGenericTypeRef) obj); return; }
	if ( obj.eClass().getName().equals("JForeach") ) { visitJForeach((lintra.atlcompiler.javagen.JForeach) obj); return; }
	if ( obj.eClass().getName().equals("JParamNTypeRef") ) { visitJParamNTypeRef((lintra.atlcompiler.javagen.JParamNTypeRef) obj); return; }
		
		unknownClassOf(obj);

	}
	
	protected void unknownClassOf(EObject obj) {
		throw new IllegalStateException("Cannot handle class: " + obj.eClass().getName());	
	}
	
	//
	// Framework code inlined as a template
	//


	public static class VisitingActions {
		private Object[] actions;
		public VisitingActions(Object... actions) {
			this.actions = actions;
		}
		
		public VisitingAction[] getActions(EObject obj) {
			VisitingAction[] result = new VisitingAction[actions.length];
			EClass  eclass      = obj.eClass();
			
			for(int i = 0; i < actions.length; i++) {
				if ( actions[i] instanceof String ) {
					String refName = (String) actions[i];
					result[i] = new VisitingAction((EReference) eclass.getEStructuralFeature(refName));
				} else if ( actions[i] instanceof VisitingAction ) {
					result[i] = (VisitingAction) actions[i];
				}
			}
			return result;
		}
	}

	public static class VisitingAction {
		public static final int REFERENCE = 0;
		public static final int METHOD_CALL = 1;
		public static final int FILTER_CALL = 2;
		
		private int actionType = -1;

		// For references
		private EReference	reference;
		
		// For method calls
		private Object[]	arguments;
		private java.lang.reflect.Method	method;
		private AbstractJavaGenVisitor receptor;
		
		public VisitingAction(AbstractJavaGenVisitor receptor, java.lang.reflect.Method method, Object[] arguments) {
			actionType = METHOD_CALL;
			this.receptor = receptor;
			this.method = method;
			this.arguments = arguments;
		}

		public static VisitingAction createFilter(AbstractJavaGenVisitor  receptor, java.lang.reflect.Method method, Object[] arguments) {
			VisitingAction va = new VisitingAction(receptor, method, arguments);
			va.actionType = FILTER_CALL;
			return va;
		}
		
		public VisitingAction(EReference r) {
			actionType = REFERENCE;
			this.reference = r;
		}

		public int getActionType() {
			return actionType;
		}
		
		public boolean isReference() {
			return getActionType() == REFERENCE;
		}
		
		public EReference getEReference() {
			return this.reference;
		}
		
		public boolean isMethodCall() {
			return getActionType() == METHOD_CALL;
		}
		
		public boolean isFilter() {
			return getActionType() == FILTER_CALL;
		}
		
		public Object performMethodCall() {
			try {
				return method.invoke(receptor, arguments);
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}	
		}
	}
	

	private java.util.HashMap<String, java.lang.reflect.Method> allMethods = null;
	public java.util.HashMap<String, java.lang.reflect.Method> getAllMethods() {
		if ( allMethods == null ) {
			allMethods = new java.util.HashMap<String, java.lang.reflect.Method>();
			for(java.lang.reflect.Method m : this.getClass().getMethods()) {
				allMethods.put(getMethodKey(m.getName(), m.getParameterCount()), m);
			}
		}
		return allMethods;
	}
	
	private final String getMethodKey(String name, int paramCount) {
		return name + "/" + paramCount;
	}
	
	public VisitingAction method(String methodName, Object... arguments) {
		String key = getMethodKey(methodName, arguments.length);
		if ( getAllMethods().containsKey(key) ) {
			return new VisitingAction(this, getAllMethods().get(key), arguments);			
		}
		
		throw new RuntimeException("No method " + methodName + " found in " + this.getClass().getName());
	}

	public VisitingAction filter(String methodName, Object... arguments) {
		String key = getMethodKey(methodName, arguments.length);
		if ( getAllMethods().containsKey(key) ) {
			return VisitingAction.createFilter(this, getAllMethods().get(key), arguments);
		}
		
		throw new RuntimeException("No method " + methodName + " found in " + this.getClass().getName());
	}

		
}
