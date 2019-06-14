package linda.atlcompiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import javagen.visitor.AbstractJavaGenVisitor;
import lintra.atlcompiler.javagen.IteratorLoop;
import lintra.atlcompiler.javagen.JArrayTypeRef;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JClosure;
import lintra.atlcompiler.javagen.JComment;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JExprStatement;
import lintra.atlcompiler.javagen.JForeach;
import lintra.atlcompiler.javagen.JGenericTypeRef;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JInvokeStatic;
import lintra.atlcompiler.javagen.JLibType;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JNewObject;
import lintra.atlcompiler.javagen.JParamNTypeRef;
import lintra.atlcompiler.javagen.JParamTypeRef;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JReturn;
import lintra.atlcompiler.javagen.JText;
import lintra.atlcompiler.javagen.JTextExp;
import lintra.atlcompiler.javagen.JThis;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVarExp;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.LMatchCase;
import lintra.atlcompiler.javagen.LMatchObject;

public class JavaGenerator extends AbstractJavaGenVisitor {

	public GenData generate(JavaGenModel model) {
		startVisiting(model);
		
		GenData data = new GenData();
		model.getClasses().forEach(c -> data.classesToString.put(c, g(c)));
		
		return data;
	}

	@Override
	public void beforeJavaGenModel(JavaGenModel self) {
		self.getLibTypes().forEach(jlibType -> {
			str.put(jlibType, jlibType.getName());
		});

		self.getMetaTypes().forEach(jm -> {
			str.put(jm, jm.getName());
		});
		
	}
	
	public static String textOf(EObject obj) {
		EObject container = obj;
		for(;;) {
			if ( container == null ) 
				throw new IllegalArgumentException("Not contained in a JavaGenModel");
			if ( container instanceof JavaGenModel )
				break;			
			container = container.eContainer();
		}
		
		JavaGenerator gen = new JavaGenerator();
		gen.beforeJavaGenModel((JavaGenModel) container);
		gen.startVisiting(obj);
		return gen.g(obj);
	}
	
	@Override
	public void inJavaGenModel(JavaGenModel self) {
		// self.getMetaTypes().forEach(action);
		
	}
	
	@Override
	public void inJClass(JClass self) {
		String s = "package " + self.getPkg() + ";" + cr() + cr();

		// This should be improved, with class-specific imports 
		JavaGenModel model = (JavaGenModel) self.eContainer();
		for (JType t : self.getImports()) {
			if ( t instanceof JLibType ) {
				JLibType type = (JLibType) t;
				s += "import " + type.getPkg() + "." + type.getName() + ";" + cr();
			}
		}
		for (JMetaType type : model.getMetaTypes()) {
			if ( ! hasDuplicateImports(model.getMetaTypes(), type) )
				s += "import " + type.getQualifiedJavaName() + ";" + cr();
		}

		s += cr();
		
		String exts  = self.getExtends_() == null ? "" : " extends " + g(self.getExtends_());
		String impls = self.getImplements().isEmpty() ? " " : " implements " + join(self.getImplements(), ", "); 
		s += "public class " + self.getName() + exts + impls + "{" + cr();
		inctab();
		{
			s += join(self.getAttributes(), genTabCr());
			s += self.getExtra() != null ? self.getExtra() : "" + cr();
			s += join(self.getMethods(), genTabCr());			
		}
		dectab();
		s += "}";
		
		s(s);
	}
	
	@Override
	public void inJAttribute(JAttribute self) {
		s("private " + g(self.getType()) + " " + self.getName() + ";");
	}
	
	@Override
	public void inJMethod(JMethod self) {
		String returnType = self.getReturnType() == null ? "void" : g(self.getReturnType());

		String throws_ = self.getThrows_().isEmpty() ? "" : " throws " + join(self.getThrows_(), ", ");
		String s = "public " + returnType + " " + self.getName() + 
				"(" + join(self.getParameters(), ", ") + ")" + throws_ + "{" + cr();
		inctab();
		{
			s += genBlock(self);			
		}
		dectab();
		s += "}";
		
		s(s);
	}

	private String genBlock(JBlock self) {		
		String s = self.getLocalVars().stream().map(vd -> g(vd.getType()) + " " + vd.getName() + ";").collect(Collectors.joining(cr()));
		s += join(self.getStatements(), genTabCr());
		return s;
	}
	
	@Override
	public void inJTypeRef(JTypeRef self) {
		JClass c = getClassOf(self);		
		s(getTypeName(self.getType(), c));		
	}
	
	public JClass getClassOf(EObject o) {
		if ( o == null ) return null;
		if ( o instanceof JClass ) return (JClass) o;
		return getClassOf(o.eContainer());
	}
	
	public String getTypeName(JType type, JClass containingClass) {
		JavaGenModel model = (JavaGenModel) containingClass.eContainer();
		
		String pkgPrefix = "";
		if ( type instanceof JLibType && ! isPrimitive((JLibType) type) && ! containingClass.getImports().contains(type)) {
			pkgPrefix = ((JLibType) type).getPkg() + ".";
		} else if ( type instanceof JMetaType && hasDuplicateImports(model.getMetaTypes(), type) ) {
			return pkgPrefix = ((JMetaType) type).getQualifiedJavaName();
		} else if ( type instanceof JClass ) {
			JClass jc = (JClass) type;
			return jc.getPkg() + "." + jc.getName();
		}
		return pkgPrefix + g(type);
		
	}

	private boolean hasDuplicateImports(List<? extends JType> types, JType type) {
		return types.stream().filter(i -> i.getName().equals(type.getName() )).count() > 1;
	}
	
	private boolean isPrimitive(JLibType type) {
		return type.getPkg().equals("default_");
	}

	@Override
	public void inJParamTypeRef(JParamTypeRef self) {
		JClass c = getClassOf(self);
		s(getTypeName(self.getType(), c) + "<" + g(self.getContainedType())+ ">");
	}
	
	@Override
	public void inJParamNTypeRef(JParamNTypeRef self) {
		JClass c = getClassOf(self);
		String types = self.getParams().stream().map(this::g).collect(Collectors.joining(", "));
		s(getTypeName(self.getType(), c) + "<" + types + ">");
	}
	
	@Override
	public void inJGenericTypeRef(JGenericTypeRef self) {
		JClass c = getClassOf(self);
		s(getTypeName(self.getType(), c) + "<" + self.getTypeParams().stream().map(p -> g(p)).collect(Collectors.joining(","))+ ">");
	}
	
	@Override
	public void inJArrayTypeRef(JArrayTypeRef self) {
		s(g(self.getContainedType()) + "[]");
	}
	
	@Override
	public void inJParameter(JParameter self) {
		s(g(self.getType()) + " " + self.getName());
	}
	
	@Override
	public void inJThis(JThis self) {
		s("this");
	}
	
	
	// Statements
	
	@Override
	public void inJText(JText self) {
		s(self.getBody() + ";" + cr());
	}
	
	@Override
	public void inJAssignment(JAssignment self) {
		if ( self.getRightPart() == null ) {
			String s = self.getDeclaration().getName() + " = " + self.getBody() + ";" + cr();
			s(s);
		} else {
			String s = self.getDeclaration().getName() + " = " + g(self.getRightPart()) + ";" + cr();
			s(s);			
		}
	}
	
	@Override
	public void inJReturn(JReturn self) {
		s("return " + g(self.getResult()) + ";" + cr());
	}
	
	@Override
	public void inJForeach(JForeach self) {
		String s = "for ( " + g(self.getLoopVar().getType()) + " " + self.getLoopVar().getName() + ": " + g(self.getCollection()) + ") {";
		s += cr();
		inctab();
		{
			s += join(self.getLocalVars(), genTabCr());
			s += join(self.getStatements(), genTabCr());
		}
		dectab();
		s += "}";
		
		s(s);
	}
	
	@Override
	public void inIteratorLoop(IteratorLoop self) {
		String s = g(self.getIteratorVar().getType()) + " " + self.getIteratorVar().getName() + " = " + g(self.getIteratorInit()) + ";" + cr();
		s += "while ( " + self.getIteratorVar().getName() + ".hasNext() ) {" + cr();
		inctab();
		{
			s += g(self.getLoopVar().getType()) + " " + self.getLoopVar().getName() + " = " + self.getIteratorVar().getName() + ".next();";
			s += join(self.getLocalVars(), genTabCr());
			s += join(self.getStatements(), genTabCr());
		}
		dectab();
		s += "}";
		
		s(s);
	}	

	private int matchVar = 0;
	
	@Override
	public void inLMatchObject(LMatchObject self) {
		String tmpVar = "matched" + matchVar++;
		String s = "boolean " + tmpVar + " = false;";
		String elsePrefix = "";
		for (LMatchCase mcase : self.getCases()) {
			String ifcase = elsePrefix + "if ( " + mcase.getPredicate().getName() + "( " + g(mcase.getObj()) + ") )  {" + cr();
			inctab();
			{
				ifcase += join(mcase.getStatements(), genTabCr());
			}
			dectab();			
			ifcase += "}" + cr();
			s += ifcase;
			
			elsePrefix = "else ";
		}
		
		s(s);
	}
	
	@Override
	public void inJConditional(JConditional self) {
		String s = "";
		
		for (int i = 0; i < self.getConditions().size(); i++) {
			JConditionalBlock block = self.getConditions().get(i);
			String keyword = i == 0 ? "if" : "else if";
			s += keyword + " ( " + g(block.getExpr()) + ") {" + cr();
			inctab();
			s += genBlock(block); // join(block.getStatements(), genTabCr());
			dectab();
			s += "}";
		}
		
		if ( self.getElse() != null ) {
			s += " else { ";
			s += genBlock(self.getElse()); //join(self.getElse().getStatements(), genTabCr());
			s += "}";
		}
		
		s(s);		
	}
	
	@Override
	public void inJExprStatement(JExprStatement self) {
		s(g(self.getExpr()) + ";");
	}
	
	@Override
	public void inJInvoke(JInvoke self) {
		String s = g(self.getObj()) + "." + self.getName();
		s += "(" + self.getArguments().stream().map(a -> g(a)).collect(Collectors.joining(", ")) + ")";
		s(s);
	}
	
	@Override
	public void inJInvokeStatic(JInvokeStatic self) {
		String s = self.getName();
		s += "(" + self.getArguments().stream().map(a -> g(a)).collect(Collectors.joining(", ")) + ")";
		s(s);
	}
	
	@Override
	public void inJNewObject(JNewObject self) {
		String s = "new " + g(self.getTypeRef());
		s += "(" + self.getArguments().stream().map(a -> g(a)).collect(Collectors.joining(", ")) + ")";
		s(s);
	}
	
	@Override
	public void inJClosure(JClosure self) {
		String params = "(" + self.getParameters().stream().map(p -> p.getName()).collect(Collectors.joining(", ")) + ")";
		String s = params + " -> { " + cr();
		s += genBlock(self);
		s += "}";
		s(s);
	}
	
	@Override
	public void inJComment(JComment self) {
		s("/* " + self.getValue() + "*/");
	}
	
	// Expressions
	
	@Override
	public void inJTextExp(JTextExp self) {
		s(self.getBody());
	}
	
	@Override
	public void inJVarExp(JVarExp self) {
		s(self.getReference().getName());
	}
	
	// Facilities

	private String join(EList<? extends EObject> objs, String separator) {
		return objs.stream().map(o -> g(o)).collect(Collectors.joining(separator));
	}

	private HashMap<Object, String> str = new HashMap<Object, String>();

	protected String cr() {
		return cr(1);
	}
	
	private String cr(int n) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += "\n";
		}
		return s;
	}
	
	protected String g(EObject obj) {
		if ( ! str.containsKey(obj) ) throw new IllegalArgumentException("Not found " + obj);
		return str.get(obj);
	}
	
	protected void s(String s) {
		str.put(this.getCurrent(), s);
	}
	protected String inctab() {
		indentationStack.add("\t");
		return cr() + genTabCr();
	}
	
	protected String dectab() {
		if ( indentationStack.size() == 0 )
			return cr(); // this is a fallback... Try to remove and test 
		
		indentationStack.remove(indentationStack.size() - 1);
		return cr() + genTabCr();
	}
	
	protected String tab(int n) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += "   ";
		}
		return s;		
	}
	
	protected String genTabCr() {
		return "\n" + genTab();
	}
	
	protected String genTab() {
		String s = "";
		for (String string : indentationStack) {
			s += string;
		}
		return s;
	}

	protected ArrayList<String> indentationStack = new ArrayList<String>();
	
	public class GenData {
		private HashMap<JClass, String> classesToString = new HashMap<JClass, String>();

		public void forEachClass(BiConsumer<JClass, String> consumer) {
			classesToString.forEach(consumer);
		}
		
		
	}
	
}
