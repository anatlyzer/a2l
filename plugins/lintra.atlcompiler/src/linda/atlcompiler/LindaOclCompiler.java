package linda.atlcompiler;

import static linda.atlcompiler.CreationHelpers.createAssignment;
import static linda.atlcompiler.CreationHelpers.addStm;
import static linda.atlcompiler.CreationHelpers.createSimpleIf;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.createLoopVar;
import static linda.atlcompiler.CreationHelpers.createTextExp;
import static linda.atlcompiler.CreationHelpers.createCommentedList;
import static linda.atlcompiler.CreationHelpers.createInvoke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.compiler.AstAnnotations;
import a2l.compiler.OptimisationHints;
import a2l.compiler.OptimisationHints.CachedValue;
import a2l.compiler.OptimisationHints.Hotspot;
import a2l.compiler.VarStatementPair;
import a2l.driver.MutableListDriver;
import a2l.driver.ICollectionsDriver;
import a2l.driver.IMetaDriver;
import a2l.driver.JavaslangDriver;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import a2l.utils.TypeError;
import anatlyzer.atl.analyser.namespaces.MetamodelNamespace;
import anatlyzer.atl.model.TypeUtils;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.BooleanType;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.EnumType;
import anatlyzer.atl.types.FloatType;
import anatlyzer.atl.types.IntegerType;
import anatlyzer.atl.types.MapType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.OclUndefinedType;
import anatlyzer.atl.types.OrderedSetType;
import anatlyzer.atl.types.PrimitiveType;
import anatlyzer.atl.types.ReflectiveClass;
import anatlyzer.atl.types.SetType;
import anatlyzer.atl.types.StringType;
import anatlyzer.atl.types.TupleType;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.types.UnionType;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.ATL.BindingStat;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.ForStat;
import anatlyzer.atlext.ATL.IfStat;
import anatlyzer.atlext.ATL.Statement;
import anatlyzer.atlext.OCL.BooleanExp;
import anatlyzer.atlext.OCL.CollectionExp;
import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.EnumLiteralExp;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.IntegerExp;
import anatlyzer.atlext.OCL.IterateExp;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LetExp;
import anatlyzer.atlext.OCL.MapExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclUndefinedExp;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.OrderedSetExp;
import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.RealExp;
import anatlyzer.atlext.OCL.SequenceExp;
import anatlyzer.atlext.OCL.SetExp;
import anatlyzer.atlext.OCL.StringExp;
import anatlyzer.atlext.OCL.TupleExp;
import anatlyzer.atlext.OCL.TuplePart;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import linda.atlcompiler.BaseTyping.TupleTypeInformation;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.ICompilationContext.IInitializer;
import linda.atlcompiler.ITyping.MutabilityAttribute;
import lintra.atlcompiler.builtin.BuiltinHelper;
import lintra.atlcompiler.builtin.BuiltinOperationRegistry;
import lintra.atlcompiler.builtin.ICollectionOperationHandler;
import lintra.atlcompiler.builtin.IIteratorChainHandler;
import lintra.atlcompiler.builtin.IOperationHandler;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JClosure;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
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
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.lingen.LinGen;
import lintra.lingen.LinGen2;

import static linda.atlcompiler.CreationHelpers.createForeach;
import static linda.atlcompiler.CreationHelpers.toStr;
import static linda.atlcompiler.CreationHelpers.createText;

/**
 * There are several options to implement helpers:
 * 
 * 1. Generate all helpers in the main transformation class and use
 *    an xtend-like style to dispatch to the correct method
 * 2. Generate the helpers in the "data classes". This couples the
 *    data classes to the transformation
 * 
 * @author jesus
 *
 */
public class LindaOclCompiler implements IOclCompiler, IInitializer {
	
	private CompilationEnv env;
	private ITyping typ;
	private GenCompiler gen;
	private BuiltinOperationRegistry registry;
	private OptimisationHints hints;

	public LindaOclCompiler(CompilationEnv env, ITyping typ, GenCompiler gen, OptimisationHints hints) {
		this.env = env;
		this.typ = typ;
		this.gen = gen;
		this.hints = hints;
		
		this.registry = BuiltinHelper.create();
	}
	
	@Override
	public void inAttributeCall(NavigationOrAttributeCallExp self) {
		// TODO: Attributes are cached		
		
		generateCall(self);
	}

	// The call strategy must be in accordance to the generation of the methods,
	// this can be placed in a strategy
	// The current strategy is to simulate polymorphism with "ifs"
	private void generateCall(PropertyCallExp self) {
		// This could be factorized to calling method, instead of generating
		// one per call 
		
		JVariableDeclaration sourceVar = env.getVar(self.getSource());
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));		
		
		if ( self.getDynamicResolvers().isEmpty() ) {
			throw new UnsupportedTranslation("Call without resolvers is not supported. There are probably typing errors: " + self.getLocation() + " - " + self);
		}
		
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "call", typ.createTypeRef(self.getInferredType()));
		
		List<OclExpression> args;
		if ( self instanceof OperationCallExp ) {
			args = ((OperationCallExp) self).getArguments();
		} else {
			args = Collections.emptyList();
		}
		args.stream().flatMap(a -> env.getStatements(a).stream()).forEach(s -> stms.add(s));
		
		
		JConditional conditional = JavagenFactory.eINSTANCE.createJConditional();
		stms.add(conditional);
		
		List<ContextHelper> sortedHelpers = self.getDynamicResolvers().stream().
			sorted((h1, h2) -> {
				Type t1 = h1.getInferredReturnType();
				Type t2 = h2.getInferredReturnType();
				// Sort so that more concrete types go first
				if ( ! (t1 instanceof Metaclass )) {
					return -1;
				} else if ( ! (t2 instanceof Metaclass ) ) {
					return 1;
				}
				
				Metaclass m1 = (Metaclass) t1;
				Metaclass m2 = (Metaclass) t2;
				
				// 
				if ( m1.getKlass().isSuperTypeOf(m2.getKlass()) ) {
					return 1;
				} else if ( m2.getKlass().isSuperTypeOf(m1.getKlass()) ) {
					return -1;
				}
				
				return 0;
			}).collect(Collectors.toList());
		
		sortedHelpers.stream().map(h -> {
			Type t = h.getContextType();
			JTypeRef typeRef = typ.createTypeRef(t);
			JConditionalBlock block = JavagenFactory.eINSTANCE.createJConditionalBlock();
			// TODO: toStr will return primitive types like "boolean", and this is not valid for InstanceOf
			block.setExpr( createTextExp( sourceVar.getName() + " instanceof " + toStr(typeRef)  ));
			
			// call the method
			JMethod method = gen.helperToMethod.get(h);
			
			String strArgs = Stream.concat(
					Stream.of(cast(t) + sourceVar.getName()),  // add a first argument
					args.stream().map(p -> env.getVar(p).getName()) ).
					collect(Collectors.joining(","));
			
			// Assign the call result to the expression result var
			addStm(block, createAssignment(newVar, method.getName() + "(" + strArgs + ")" ));
			
			// block.getStatements()
			return block;
		}).forEach(b -> conditional.getConditions().add(b));
		
		// Else branch throws an exception
		JConditionalBlock elseBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
		conditional.setElse(elseBlock);
		addStm(elseBlock, createText("throw new IllegalStateException()"));
		
		env.bind(self, newVar, stms);
	}

	@Override
	public void inOperationCallExp(OperationCallExp self) {
		generateCall(self);
		// TODO: What about parameter passing??
	}
	
	@Override
	public void inTupleAccess(NavigationOrAttributeCallExp self) {
		// List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "nav", typ.createTypeRef(self.getInferredType()));
		JVariableDeclaration receptor = env.getVar(self.getSource());
		JStatement nav = createAssignment(newVar, receptor.getName() + "." + self.getName());
		
		env.bind(self, newVar, Collections.singletonList(nav));
	}
	
	
	@Override
	public void inBuiltInAttributeCallExp(NavigationOrAttributeCallExp self) {
		if ( self.getSource().getInferredType() instanceof ReflectiveClass ) {
			JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "att", typ.createTypeRef(self.getInferredType()));
			List<JStatement> stms = createCommentedList(self);
			stms.addAll(env.getStatements(self.getSource()));

			String op = self.getName();
			switch (op) {
			case "name":  
				stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".getName()") );
				break;
			default:
				throw new UnsupportedTranslation("Built-in attribute not supported", self);
			}		
			
			env.bind(self, newVar, stms);		
		} else {
			throw new UnsupportedTranslation("Built-in attribute not supported", self);
		}
		 
	}
	
	@Override
	public void inBuiltInOperationCallExp(OperationCallExp self) {		
		if ( self.getSource().getInferredType() instanceof CollectionType ) {
			// This handles the case that the source is a collection and the developer uses . instead of ->
			// Example: collection.size()
			translateCollectionOperation(self);
			return;
		} else if ( self.getOperationName().equals("allInstances") ) {
			translateAllInstances(self, null);
			return;
		} else if ( self.getOperationName().equals("allInstancesFrom") ) {
			StringExp arg = (StringExp) self.getArguments().get(0);
			translateAllInstances(self, arg.getStringSymbol());
			return;
		}
		
		
		
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "op", typ.createTypeRef(self.getInferredType()));
		List<JStatement> stms = createCommentedList(self);

		stms.addAll(env.getStatements(self.getSource()));
		
		String op = self.getOperationName();
		
		if ( op.equals("oclIsTypeOf") ) {
			OclExpression arg = self.getArguments().get(0);
			JTypeRef type = typ.createTypeRef(arg.getInferredType());
			String varName = env.getVar(self.getSource()).getName();
			
			String typeOfCheck = env.getDriver(self.getSource()).compileTypeOfExpression(self.getSource(), arg, ctx());
			
			stms.add( createAssignment(newVar, varName + "!= null && " + typeOfCheck ));
			
			env.bind(self, newVar, stms);
			return;
		} else if ( op.equals("oclIsKindOf") ) {
			OclExpression arg = self.getArguments().get(0);
			// This is needed to force the import of the type if it is not mentioned in another places
			JTypeRef type = typ.createTypeRef(arg.getInferredType()); 
			
			String kindOfCheck = env.getDriver(self.getSource()).compileKindOfExpression(self.getSource(), arg, ctx());
			
			//stms.add( createAssignment(newVar, 
			//		"(" + env.getVar(self.getSource()).getName() + " instanceof " + 
			//				LinGen2.getInterfaceName(((Metaclass) arg.getInferredType()).getKlass()) + ")" ));
			
			stms.add( createAssignment(newVar, kindOfCheck));
			
			env.bind(self, newVar, stms);
			return;			
		} else if (op.equals("oclAsType")) {
			OclExpression argType = self.getArguments().get(0);
			
			String cast = env.getDriver(self.getSource()).castTo(self.getSource(), argType, ctx());
			
			stms.add( createAssignment(newVar, cast ));
			
			env.bind(self, newVar, stms);
			return;
		}
		
		
		JVariableDeclaration[] args = new JVariableDeclaration[self.getArguments().size()];
		for (int i = 0; i < self.getArguments().size(); i++) {
			OclExpression expr = self.getArguments().get(i);
			args[i] = env.getVar(expr);
			stms.addAll(env.getStatements(expr));			
		}
		
		IOperationHandler handler = registry.findOperation(op, self.getSource().getInferredType().getClass());
		if ( handler != null ) {
			Context ctx = new ICompilationContext.Context(env, typ, gen, javaslangDriver, this);
			
			List<JStatement> res = handler.compile(ctx, self, env.getVar(self.getSource()), args, newVar);
			stms.addAll(res);
			env.bind(self, newVar, stms);
			return;
		}
		
		switch (op) {
		case "oclIsUndefined":  
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + "== null") );
			break;
		case "toString":  
			// stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".toString()") );
			// To make it work for primitive types
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + " + \"\"") );			
			break;			
		// String
		case "indexOf":  
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".indexOf(" + args[0].getName() + ")") );
			break;
		case "substring":	
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".substring(" + args[0].getName() + "- 1" + "," + args[1].getName() + ")") );
			break;			
		case "size":
			String methodName = (self.getSource().getInferredType() instanceof StringType) ? "length" : "size";			
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + "." + methodName + "()") );
			break;

		case "round":
			stms.add( createAssignment(newVar, "Math.round(" + env.getVar(self.getSource()).getName() + ")") );
			break;

		case "get":
			// This is for maps
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".getOrElse(" + args[0].getName() + ", " + createEmptyValue(self.getInferredType(), false) + ")") );
			break;
		
		case "toInteger": // String
			stms.add( createAssignment(newVar, "Integer.parseInt(" + env.getVar(self.getSource()).getName() +  ")") );
			break;
		default:
			throw new UnsupportedOperationException("Built-in " + self.getOperationName() + " not supported:" + self.getLocation());
		}

		env.bind(self, newVar, stms);
	}
	
	private void translateAllInstances(OperationCallExp self, String modelName) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "op", typ.createTypeRef(self.getInferredType()));
		List<JStatement> stms = createCommentedList(self);
		OclModelElement me = (OclModelElement) self.getSource();
		JTypeRef ref = typ.createTypeRef(me.getInferredType());

		// Not optimised version
		if ( modelName != null ) {

			String modelNamePostfix = "From" + modelName;			
			stms.add( createAssignment(newVar, "getAllInstances" + modelNamePostfix + "(" + toStr(ref) + ".class" + ")") );
		} else {
			// Use the global cache configured in LindaCompiler#createGlobalContext
			stms.add( createAssignment(newVar, "this.globalContext." + LindaCompiler.getAllInstancesMethodAccess(ref.getType()) + "()"));
		}
		
		env.bind(self, newVar, stms);		
	}

	@Override
	public void inLazyRuleCall(OperationCallExp self) {
		List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "call", typ.createTypeRef(self.getInferredType()));
		for (int i = 0; i < self.getArguments().size(); i++) {
			OclExpression expr = self.getArguments().get(i);
			stms.addAll(env.getStatements(expr));			
		}

		JMethod method = gen.lazyRuleToMethod.get(self.getStaticResolver());
		
		String args = self.getArguments().stream().
				map(p -> env.getVar(p).getName()).
				collect(Collectors.joining(","));
		
		// Assign the call result to the expression result var
		stms.add( createAssignment(newVar, method.getName() + "(" + args + ")" ));
		
		env.bind(self, newVar, stms);
	}
	
	@Override
	public void inCalledRuleCall(OperationCallExp self) {
		List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "call", typ.createTypeRef(self.getInferredType()));
		for (int i = 0; i < self.getArguments().size(); i++) {
			OclExpression expr = self.getArguments().get(i);
			stms.addAll(env.getStatements(expr));			
		}

		JMethod method = gen.calledRuleToMethod.get(self.getStaticResolver());
		
		String args = self.getArguments().stream().
				map(p -> env.getVar(p).getName()).
				collect(Collectors.joining(","));
		
		// Assign the call result to the expression result var
		stms.add( createAssignment(newVar, method.getName() + "(" + args + ")" ));
		
		env.bind(self, newVar, stms);
	}
	
	@Override
	public void inThisModuleCall(OperationCallExp self) {
		List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "call", typ.createTypeRef(self.getInferredType()));

		JMethod method = gen.helperToMethod.get(self.getStaticResolver());
		
		String args = self.getArguments().stream().
				map(p -> env.getVar(p).getName()).
				collect(Collectors.joining(","));

		self.getArguments().stream().flatMap(a -> env.getStatements(a).stream()).forEach(s -> stms.add(s));
		
		// Assign the call result to the expression result var
		stms.add( createAssignment(newVar, method.getName() + "(" + args + ")" ));
		
		env.bind(self, newVar, stms);		
	}
	
	@Override
	public void inThisModuleCall(NavigationOrAttributeCallExp self) {
		List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "call", typ.createTypeRef(self.getInferredType()));

		JMethod method = gen.helperToMethod.get(self.getStaticResolver());
		
		// Assign the call result to the expression result var
		stms.add( createAssignment(newVar, method.getName() + "()" ));
		
		env.bind(self, newVar, stms);		
	}
	
	@Override
	public void inOclModelElement(OclModelElement self) {
		// Do nothing. OclModelElements are handled specifically by each
		// operation that may use it
	}
	
	@Override
	public void inLetExpVarDcl(VariableDeclaration self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), self.getVarName(), typ.createTypeRef(self.getInferredType()));
		List<JStatement> stms = new ArrayList<JStatement>(); // The serializer does not work for single variables // createCommentedList(self);
		stms.addAll(env.getStatements(self.getInitExpression()));
		
		stms.add( createAssignment(newVar, env.getVar(self.getInitExpression()).getName() ));

		env.bind(self, newVar, stms);		
	}
	
	@Override
	public void inLetExp(LetExp self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), self.getVariable().getVarName() + "_in", typ.createTypeRef(self.getInferredType()));
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getVariable()));
		stms.addAll(env.getStatements(self.getIn_()));
		
		stms.add( createAssignment(newVar, env.getVar(self.getIn_()).getName() ));

		env.bind(self, newVar, stms);	
	}
	
	@Override
	public void inCollectionOperationCallExp(CollectionOperationCallExp self) {
		translateCollectionOperation(self);
	}
	
	protected void translateCollectionOperation(OperationCallExp self) {
		Supplier<JTypeRef> createBaseType = () -> {
			try {
				IMetaDriver driver = env.getDriver(self);
				String baseType = driver.getBaseType();
				return typ.createTypeRef(baseType);
			} catch (UnsupportedTranslation e) {
				// This is going to happen when there are two different meta-models in a union type
				// e.g., col <- Sequence {key}->union(c.attr->select(e | not e.multiValued)),
				return typ.createTypeRef("java.lang.Object");
			}
		};
		
		System.out.println(self.getLocation() + " - " + self.getOperationName());
		boolean isMutable = AstAnnotations.isMutable(self);
		
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "op", typ.createTypeRef(self.getInferredType(), createBaseType, isMutable));
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));
		
		JVariableDeclaration[] args = new JVariableDeclaration[self.getArguments().size()];
		for (int i = 0; i < self.getArguments().size(); i++) {
			OclExpression expr = self.getArguments().get(i);
			args[i] = env.getVar(expr);
			stms.addAll(env.getStatements(expr));			
		}
		
		String op = self.getOperationName();
		
		ICollectionOperationHandler handler = registry.findCollectionOperation(op, self.getSource().getInferredType().getClass());
		if ( handler != null ) {
			Context ctx = new ICompilationContext.Context(env, typ, gen, javaslangDriver, this);
			
			List<JStatement> res = handler.compile(ctx, self, env.getVar(self.getSource()), args, newVar);
			stms.addAll(res);
			env.bind(self, newVar, stms);
			return;
		}
		
		
		String srcVarName = env.getVar(self.getSource()).getName();
		switch (op) {
		case "size":  
			stms.add( createAssignment(newVar, srcVarName + ".size()") );
			break;
		case "isEmpty":  
			stms.add( createAssignment(newVar, srcVarName + ".isEmpty()") );
			break;			
		case "notEmpty":  
			stms.add( createAssignment(newVar, "!" + srcVarName + ".isEmpty()") );
			break;						
		case "subSequence":
			JVariableDeclaration var1 = env.getVar(self.getArguments().get(1));							
			// RECEPTOR.subList(start - 1, end)			
			stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".subList(" + args[0].getName() + " - 1," + var1.getName() + ")") );
			break;					
		case "at":
            stms.add( createAssignment(newVar, env.getVar(self.getSource()).getName() + ".get(" + args[0].getName() + ")") );
            break;     
		case "indexOf":  
			stms.add( createAssignment(newVar, srcVarName + ".indexOf(" + args[0].getName() + ")") );
			break;			
		case "excludes":  
			stms.add( createAssignment(newVar, "!" + srcVarName + ".contains(" + args[0].getName() + ")") );
			break;						
		case "append":  
			stms.add( createAssignment(newVar, srcVarName + ".append(" + args[0].getName() + ")") );
			break;						
		case "including":
			if ( self.getSource().getInferredType() instanceof MapType ) {
				stms.add( createAssignment(newVar, srcVarName + ".put(" + args[0].getName() + "," + args[1].getName() + ")") );				
			} else {
				// Check if the type is compatible, that is, if the including is changing the type
				if ( ! TypingModel.equalTypes(self.getSource().getInferredType(), self.getInferredType()) ) {
					// If the type is changing, append cannot be used
					stms.add( createAssignment(newVar, "javaslang.collection.List.of(" + srcVarName + ", " + args[0].getName() + ")") );
				} else {
					// TODO: Check order semantics, which depends on the kind of collection
					stms.add( createAssignment(newVar, srcVarName + ".append(" + args[0].getName() + ")") );
				}
			}
			break;						
		case "union":
			CollectionType t = (CollectionType) self.getInferredType();
			String castByMap = ""; 
			if ( t.getContainedType() instanceof UnionType ) {
				String baseType = createBaseType.get().getType().getName();
				// Cast to be on the safe side
				// castByMap = ".map(e_ -> (IdentifiableElement) e_)";
				castByMap = ".map(e_ -> (" + baseType + ") e_)";
			}			
			
			stms.add( createAssignment(newVar, srcVarName + castByMap + ".appendAll(" + args[0].getName() + ")") );
			break;
		case "intersection":  
			stms.add( createAssignment(newVar, srcVarName + ".intersect(" + args[0].getName() +")" ));
			break;						
			
//		case "flatten":  
//			stms.add( createAssignment(newVar, srcVarName + ".flatMap(x_ -> x_)") );
//			break;									
		case "first":
			// We check the type, and it it is a primitive type we do a hacky conversion...
			if (self.getInferredType() instanceof IntegerType) {
				// Use MAX_INTEGER as the representation of OclUndefined... Not perfect but should do
				stms.add( createAssignment(newVar, srcVarName + ".isEmpty() ? Integer.MAX_VALUE : " + srcVarName + ".get(0)") );				
			} else {
				stms.add( createAssignment(newVar, srcVarName + ".isEmpty() ? null : " + srcVarName + ".get(0)") );
			}
			break;						
		case "last":
			if (self.getInferredType() instanceof IntegerType) {
				stms.add( createAssignment(newVar, srcVarName + ".isEmpty() ? Integer.MAX_VALUE : " + srcVarName + ".get(0)") );				
			} else {
				stms.add( createAssignment(newVar, srcVarName + ".isEmpty() ? null : " + srcVarName + ".last()") );
			}
			break;						
		case "asSet":  
			stms.add( createAssignment(newVar, "javaslang.collection.HashSet.ofAll(" + srcVarName +")" ));
			break;						
		default:
			throw new UnsupportedOperationException("Collection operation " + self.getOperationName() + " not supported");
		}

		env.bind(self, newVar, stms);		
		createCachedAssignment(self, newVar, stms);
	}

	public void createCachedAssignment(OclExpression expression, JVariableDeclaration var, List<JStatement> list) {
		System.out.println(hints);
		Hotspot hotspot = hints.getHotspot(expression);
		if ( hotspot instanceof CachedValue ) {
			CachedValue v = (CachedValue) hotspot;
			
			/*
				try {
					get6 = personMovies.get(p1, () -> {
						return javaslang.collection.HashSet.ofAll(p1.getMovies());
					});
				} catch (java.util.concurrent.ExecutionException e) {
					throw new RuntimeException(e);
				}
			 */
			
			// The pre-condition is that the statements corresponding to the cached value are already in the statement list
			// What this does is to split the statements into those needed to compute the key, and those needed to compute the value
			OclExpression cachingKey = v.getCachingKey();
			JVariableDeclaration cachedKey = env.getVar(cachingKey);

			List<JStatement> cachedValueStatements = new ArrayList<JStatement>();
			if ( cachingKey instanceof VariableExp ) {
				// VariableExp doesn't generate statements, so we take its container
				OclExpression expr = (OclExpression) cachingKey.eContainer();
				List<JStatement> statements    = env.getStatements(expr);
				int firstGen = list.indexOf(statements.get(0));
				cachedValueStatements.addAll( list.subList(firstGen, list.size() - 1) ); // skip the last one
			} else {			
				List<JStatement> statements    = env.getStatements(cachingKey);
				int lastGenByCachingKey = list.indexOf(statements.get(statements.size() - 1));
				cachedValueStatements.addAll( list.subList(lastGenByCachingKey + 1, list.size() - 1)); // skip the last one
			} 
			list.removeAll(cachedValueStatements);
			
			JStatement last = list.get(list.size() - 1);
			if ( ! (last instanceof JAssignment) ) {
				throw new IllegalStateException();
			}
			
			// The last one must be an assignment to the result variable, and it is going to be replaced by a return in the closure
			JAssignment assignment = (JAssignment) last;

			// Return value for the closure
			JReturn cachedValueReturn = CreationHelpers.createReturn(assignment.getRightPart());
			cachedValueStatements.add(cachedValueReturn);
			
			JClosure closure = JavagenFactory.eINSTANCE.createJClosure();
			closure.getStatements().addAll(cachedValueStatements);
			
			String methodName = "get" + v.getCacheSiteName();
			//JInvoke getCache = CreationHelpers.createInvoke(methodName, CreationHelpers.createTextExp("this.globalContext"));			
			JExpression cacheAccess = CreationHelpers.createTextExp("this.globalContext");
			
			JInvoke cacheInvocation = CreationHelpers.createInvoke(methodName, cacheAccess, CreationHelpers.refVar(cachedKey), closure);
			assignment.setRightPart(cacheInvocation);			
		}
	}
	
	@Override
	public void inNavigationExp(NavigationOrAttributeCallExp self, boolean onSubtypes) {
		// JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "get", typ.createTypeRef(self.getInferredType()));
		
		// Variables are declared as no-casted, and the casting is done on demand by the generation of each expression
		boolean isMutable = AstAnnotations.isMutable(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "get", 
				typ.createTypeRef(self.isImplicitlyCasted() ? self.getNoCastedType() : self.getInferredType(), isMutable));
		
		JVariableDeclaration srcVar = env.getVar(self.getSource());
		
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));
				

		if ( onSubtypes ) {
			JConditional cond = JavagenFactory.eINSTANCE.createJConditional();

			List<JConditionalBlock> conditionalBlocks = new ArrayList<JConditionalBlock>();
			
			// This is for cases like: element.featureDefinedInSubtype
			for (EObject of : self.getSubtypeFeatures()) {
				EStructuralFeature f = (EStructuralFeature) of;

				Metaclass m = TypeUtils.findMetaclass(env.getAnalysis().getNamespaces(), f.getEContainingClass());
				IMetaDriver driver = env.getDriver(m);
				
				JConditionalBlock ifBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
				ifBlock.setExpr(createTextExp(srcVar.getName() + " instanceof " + typ.getType(m) + ""));
				cond.getConditions().add(ifBlock);
				conditionalBlocks.add(ifBlock);
				generateGetterCode(self, f, driver, m, newVar, ifBlock.getStatements());

			}
			
			// This is for cases like: { elemOfType1, elemOfType2 }.feature
			for (Metaclass m : TypingModel.getInvolvedMetaclassesOfType(self.getSource().getInferredType())) {
				IMetaDriver driver = env.getDriver(m);
				EStructuralFeature f = m.getKlass().getEStructuralFeature(self.getName());			
				if ( f == null )
					continue;
				
				JConditionalBlock ifBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
				ifBlock.setExpr(createTextExp(srcVar.getName() + " instanceof " + typ.getType(m) + ""));
				cond.getConditions().add(ifBlock);
				conditionalBlocks.add(ifBlock);
				generateGetterCode(self, f, driver, m, newVar, ifBlock.getStatements());
			}
			
			JConditionalBlock elseBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
			elseBlock.getStatements().add(createText("throw new IllegalStateException()"));
			cond.setElse(elseBlock);
			
			stms.add(cond);
		} else {
			IMetaDriver driver = env.getDriver(self.getSource());
			EStructuralFeature f = (EStructuralFeature) self.getUsedFeature();			
			Metaclass castedType = null;
				
			if ( self.getSource().isImplicitlyCasted() ) {
				Type t = self.getSource().getInferredType();
//			if ( self.isImplicitlyCasted() ) {
//				Type t = self.getInferredType();

				if ( !(t instanceof Metaclass)) {
					throw new UnsupportedTranslation("Could not translate implicit casting for source type: " + TypeUtils.typeToString(t) + "at " +self.getLocation(), self);
				}
				castedType = (Metaclass) t;
			}

			generateGetterCode(self, f, driver, castedType, newVar, stms);
		}
		
		env.bind(self, newVar, stms, isMutable ? MutabilityAttribute.MUTABLE : null); 

		createCachedAssignment(self, newVar, stms);
	}

	@Override
	public void inNavRefAsSet(NavRefAsSet self) {
		// TODO: The optimiser has to be sure that this is false!
		inNavigationExp(self, false);
	}
	
	@Override
	public void inMutableIteratorExp(MutableIteratorExp self) {
		toIteratorExp(self, true);
	}
	
	@Override
	public void inMutableCollectionOperationCallExp(MutableCollectionOperationCallExp self) {
		// TODO: Apply the optimisation
		inCollectionOperationCallExp(self);
	}

	
	public void generateGetterCode(NavigationOrAttributeCallExp self, EStructuralFeature f, IMetaDriver driver, Metaclass castedType, JVariableDeclaration newVar, List<JStatement> stms) {
		JVariableDeclaration srcVar = env.getVar(self.getSource());

		// String getter = srcVar.getName() + "." + getGetter(f) + "()";


		if ( castedType != null ) {	
			JVariableDeclaration castedSrc = gen.addLocalVar(env.currentBlock(), "cast", typ.createMetaTypeRef(castedType));
			
			stms.add(createAssignment(castedSrc, cast(castedType) + srcVar.getName() ));
			
			srcVar = castedSrc;
			
			// getter = "(" + cast(castedType) + srcVar.getName() + ")." + getter + "()";
			// getter = "(" + cast(castedType) + srcVar.getName() + ")." + getGetter(f) + "()";
		}
		
		String getter = driver.compileGetterExpression(srcVar, f);
		if ( f instanceof EAttribute ) {
			stms.add( createAssignment(newVar, getter) );
		} else {
			if ( f.isMany() ) {
				// String[] idVar = source.getFeature() 
				// List<Type> newVar = srcArea.readAll(idVar)
				// TODO: How to do this without conversions
				ICollectionsDriver collections = javaslangDriver;
				if ( AstAnnotations.isMutable(self) ) {
					collections = mutableDriver;
				}
				stms.addAll( driver.compileMultivaluedGetter(self, f, newVar, getter, ctx(collections)) ); 					
			} else {
				// String idVar = source.getFeature();
				// Type newVar = srcArea.read(idVar)
				stms.addAll( driver.compileMonovaluedGetter(self, f, newVar, getter, ctx()) ); 	
			}
		}
		
	}
	

	// HashMap<Iterator, JVariableDeclaration> iteratorToItVar = new HashMap<>();
	
	@Override
	public void beforeIteratorExp(IteratorExp self) {
		if ( self.getName().equals("sortedBy") ) {
			Type containedType = ((CollectionType) self.getInferredType()).getContainedType();

			JParameter param = JavagenFactory.eINSTANCE.createJParameter();
			param.setName("p_");
			param.setType(typ.createTypeRef(containedType));

			env.bind(self.getIterators().get(0), param);
			// Try to merge with prepareLoopVar if there are more cases
			return;
		}

		prepareLoopVar(self.getSource(), self.getIterators().get(0));
	}
	
	@Override
	public void beforeIteratorChainExp(IteratorChainExp self) {
		prepareLoopVar(self.getSource(), self.getIterator());
	}
	
	public void inIteratorExp(IteratorExp self) {
		toIteratorExp(self, false);
	}
	
	@Override
	public void inIteratorChainExp(IteratorChainExp self) {
		IIteratorChainHandler handler = registry.findIteratorChain(self.getName());	
		if ( handler == null ) {
			throw new IllegalStateException("No implementation for " + self.getName());
		}

		Context ctx = new ICompilationContext.Context(env, typ, gen, javaslangDriver, this);
				
		VarStatementPair res = handler.compile(ctx, self, env.getVar(self.getSource()), this.mutableDriver);

		env.bind(self, res.getVariable(), res.getStatements());
	}	
	
	public void toIteratorExp(IteratorExp self, boolean isMutable) {
		
		Iterator it = self.getIterators().get(0);

		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));

		JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
			

		String name = self.getName();
		if ( name.equals("sortedBy") ) {
			JClosure closure = JavagenFactory.eINSTANCE.createJClosure();
			JParameter param = (JParameter) env.getVar(it);
			closure.getParameters().add(param);
			List<JStatement> closureStatements = env.getStatements(self.getBody());			
			addStm(closure, closureStatements);
			addStm(closure, createText("return " + env.getVar(self.getBody()).getName()));
			
			// I need to put the local variables written in the body as local variables within the closure
			// This could be done more elegantly if we use closures more often
			Set<JVariableDeclaration> varSet = closureStatements.stream().filter(s -> s instanceof JAssignment).map(s -> ((JAssignment) s).getDeclaration()).collect(Collectors.toSet());
			closure.getLocalVars().addAll(varSet);			
			
			JVariableDeclaration resultVar;
			if (isMutable) {
				// TODO: CHECK THAT IF THIS IS MUTABLE THEN WE JUST SORT THE COLLECTION DIRECTLY, BUT NOT SURE HOW...
				JInvokeStatic invoke = CreationHelpers.createInvokeStatic("a2l.runtime.stdlib.Collections.sort", CreationHelpers.refVar(colVar), closure);
				
				stms.add(CreationHelpers.createExpresionStatement(invoke));
				// Use the collection variable as result because we are modifying the collection in place
				resultVar = colVar;
			} else {
				resultVar = createResultVar(self, stms, isMutable);

				JInvoke invoke = createInvoke("sortBy", CreationHelpers.refVar(colVar), closure);
				
				JAssignment sort = createAssignment(resultVar, invoke);
				stms.add(sort);
			}
//			// Add the body to the foreach
//			addStm(foreach, env.getStatements(self.getBody()));
//			JAssignment append = createAssignment(resultVar, resultVar.getName() + ".prepend(" + env.getVar(self.getBody()).getName() + ")");
//			addStm(foreach, append);

			env.bind(self, resultVar, stms);
			return;
		}

		// create a new var for the result and initialize
		JVariableDeclaration resultVar = createResultVar(self, stms, isMutable);

		// - put the statements within the body
		JForeach foreach = createForeach(colVar, env.getVar(it));
		stms.add(foreach);

		// analyse the kind of operation
		if ( name.equals("select") ) {
			// Add the body to the foreach
			addStm(foreach, env.getStatements(self.getBody()));
			
			String cast = self.isImplicitlyCasted() ? cast(((CollectionType) self.getInferredType()).getContainedType()) : "";
			
			JStatement append;
			if ( isMutable ) {
				append = createText(resultVar.getName() + ".add(" + cast + foreach.getLoopVar().getName() + ")");
			} else {
				append = createAssignment(resultVar, resultVar.getName() + ".append(" + cast + foreach.getLoopVar().getName() + ")");
			}
			
			JConditional ifStm = createSimpleIf(env.getVar(self.getBody()).getName() + " == true", Collections.singletonList(append));
			addStm(foreach, ifStm);
		} else if ( name.equals("collect") ) {
			// Add the body to the foreach
			addStm(foreach, env.getStatements(self.getBody()));
			JStatement append;
			if ( isMutable ) {
				append = createText(resultVar.getName() + ".add(" + env.getVar(self.getBody()).getName() + ")");
			} else {
				append = createAssignment(resultVar, resultVar.getName() + ".append(" + env.getVar(self.getBody()).getName() + ")");
			}

			addStm(foreach, append);

		} else if ( name.equals("exists") ) {
			addStm(foreach, env.getStatements(self.getBody()));
			
			JAssignment assignment = createAssignment(resultVar, "true");
			JText aBreak = createText("break");
			List<JStatement> stmts = new ArrayList<JStatement>();
			stmts.add(assignment);
			stmts.add(aBreak);
			
			JConditional anIf = createSimpleIf(env.getVar(self.getBody()).getName(), stmts);
			
			addStm(foreach, anIf);
		} else if ( name.equals("any") ) {
			addStm(foreach, env.getStatements(self.getBody()));
			
			JAssignment assignment = createAssignment(resultVar, foreach.getLoopVar().getName());
			JText aBreak = createText("break");
			List<JStatement> stmts = new ArrayList<JStatement>();
			stmts.add(assignment);
			stmts.add(aBreak);
			
			JConditional anIf = createSimpleIf(env.getVar(self.getBody()).getName(), stmts);
			
			addStm(foreach, anIf);
		} else {
			throw new UnsupportedOperationException("Iterator " + name + " is not supported");
		}
	
		
		env.bind(self, resultVar, stms);
	}

	
	protected void prepareLoopVar(OclExpression collection, Iterator it) {
		Type containedType = ((CollectionType) collection.getInferredType()).getContainedType();

		JVariableDeclaration loopVar = createLoopVar(gen.uniqueVarName(it), typ.createTypeRef(containedType));
		env.bind(it, loopVar);				
	}
	
	@Override
	public void prepareIterateVariable(IterateExp self) {
		prepareLoopVar(self.getSource(), self.getIterators().get(0));
		
		Type resultType = self.getInferredType();
		// The alternative would be self.getResult().getInferredType()
		// but this has problems with initializations like res = Map {}
		// because the type would be Map<Object, Object> which may not be compatible with
		// the actual result in which types have been inferred e.g., Map<Integer, String>
		
		// This is added for iterateExp
		JVariableDeclaration resultVar = gen.addLocalVar(env.currentBlock(), gen.uniqueVarName(self.getResult()), typ.createTypeRef(resultType));		
		env.bind(self.getResult(), resultVar);
	}
	
	@Override
	public void prepareForStatVariable(ForStat self) {
		prepareLoopVar(self.getCollection(), self.getIterator());		
	}

	@Override
	public void inForStat(ForStat self) {
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getCollection()));

		JVariableDeclaration colVar = env.getVar(self.getCollection()); 

		JForeach foreach = createForeach(colVar, env.getVar(self.getIterator()));
		stms.add(foreach);
		
		for (Statement statement : self.getStatements()) {
			addStm(foreach, env.getStatements(statement));
		}
		
		env.bind(self, stms);
	}
	
	@Override
	public void inIfStat(IfStat self) {
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getCondition()));
		
		JConditional cond = JavagenFactory.eINSTANCE.createJConditional();
		JConditionalBlock ifBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
		ifBlock.setExpr(createTextExp(env.getVar(self.getCondition()).getName()));		
		ifBlock.getStatements().addAll( self.getThenStatements().stream().flatMap(s -> env.getStatements(s).stream() ).collect(Collectors.toList()));
		cond.getConditions().add(ifBlock);
		
		if ( self.getElseStatements().size() > 0 ) {
			JConditionalBlock elseBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
			elseBlock.getStatements().addAll(self.getElseStatements().stream().flatMap(s -> env.getStatements(s).stream() ).collect(Collectors.toList()));
			cond.setElse(elseBlock);
		}
		
		stms.add(cond);
		
		env.bind(self, stms);
	}
	
	@Override
	public void inIterateExp(IterateExp self) {
		Iterator it = self.getIterators().get(0);

		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));
		stms.addAll(env.getStatements(self.getResult().getInitExpression()));
		
		JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
		
		// Init the result variable
		JVariableDeclaration resultVar = env.getVar(self.getResult());
		JAssignment init = createAssignment(resultVar, env.getVar(self.getResult().getInitExpression()).getName());
		stms.add(init);
				
		JForeach foreach = createForeach(colVar, env.getVar(it));
		stms.add(foreach);
		
		addStm(foreach, env.getStatements(self.getBody()));
		JAssignment append = createAssignment(resultVar, env.getVar(self.getBody()).getName());
		addStm(foreach, append);
		
		env.bind(self, resultVar, stms);
	}
	
	private JVariableDeclaration createResultVar(OclExpression self, List<JStatement> stms, boolean isMutable) {
		JTypeRef resultType = typ.createTypeRef(self.getInferredType(), isMutable);
		
		JVariableDeclaration resultVar = gen.addLocalVar(env.currentBlock(), "r", resultType);
		stms.add(createAssignment(resultVar, createEmptyValue(self.getInferredType(), isMutable)) );
		return resultVar;
	}

	@Override
	public void inBooleanExp(BooleanExp self) {
		// TODO: Consider an SSA representation
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("boolean"));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, self.isBooleanSymbol()+"")));		
	}
	
	@Override
	public void inStringExp(StringExp self) {
		String str = self.getStringSymbol();
		str = str.replaceAll("\\n", "\\\\n"); // sanitize '\n'
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("String"));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, CreationHelpers.quote(str))));		
	}
	
	@Override
	public void inOclUndefined(OclUndefinedExp self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("Object"));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, "null")));				
	}

	@Override
	public void inSequenceExp(SequenceExp self) {
		treatCollectionExp(self, "javaslang.collection.List", "javaslang.collection.List");
	}
	
	@Override
	public void inSetExp(SetExp self) {
		treatCollectionExp(self, LindaTyping.SET_BASE, LindaTyping.SET_CONCRETE);		
	}
	
	@Override
	public void inOrderedSetExp(OrderedSetExp self) {
		treatCollectionExp(self, LindaTyping.ORDERED_SET_BASE, LindaTyping.ORDERED_SET_CONCRETE);		
	}	
	
	public void treatCollectionExp(CollectionExp self, String baseClass, String concreteClass) {
		if ( self.getElements().size() == 0 ) {
			// When the list is initially empty we generate a raw type, to get warnings in assignments
			// instead of type errors. The alternative is to analyse the "future usages" of the empty
			// sequence in order to infer the proper generic type
			JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef(baseClass) );
			env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, concreteClass + ".empty()")));		
		} else {
			JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef(self.getInferredType()) );
			List<JStatement> stms = createCommentedList(self);
			
			for (OclExpression exp : self.getElements()) {
				stms.addAll(env.getStatements(exp));
			}
			
			String params = self.getElements().stream().map(e -> env.getVar(e).getName()).collect(Collectors.joining(","));
			
			stms.add(createAssignment(newVar, concreteClass + ".of(" + params + ")"));
			
			env.bind(self, newVar, stms);				
		}
	}
	
	@Override
	public void inMapExp(MapExp self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("javaslang.collection.Map"));
		if ( self.getElements().size() == 0 ) {
			// env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, "javaslang.collection.HashMap.empty()")));		
			env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, createEmptyValue(self.getInferredType(), false)) ));					
		} else {
			throw new UnsupportedTranslation("Maps with literals not supported yet");
		}		
	}
	
	@Override
	public void inIntegerExp(IntegerExp self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("int"));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, self.getIntegerSymbol() + "")));		
	}
	
	@Override
	public void inRealExp(RealExp self) {
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef("double"));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, self.getRealSymbol() + "")));		
	}

	
	@Override
	public void inTupleExp(TupleExp self) {
		TupleTypeInformation type = getType(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef(self.getInferredType()));
		
		List<JStatement> statements = new ArrayList<JStatement>(1 + self.getTuplePart().size() * 2);		
		
		JAssignment assignment = createAssignment(newVar, "new " + type.getGeneratedClassName() + "()");
		statements.add(assignment);
		for (TuplePart part : self.getTuplePart()) {
			JVariableDeclaration decl = assignment.getDeclaration();
			JVariableDeclaration value = env.getVar(part.getInitExpression());
			JText init = createText(decl.getName() + "." + part.getVarName() + " = " + value.getName());
		
			statements.addAll(env.getStatements(part.getInitExpression()));
			statements.add(init);
		}
		env.bind(self, newVar, statements);
	}
	
	public TupleTypeInformation getType(TupleExp self) {
		Set<? extends TupleTypeInformation> tupleTypes = env.getUsedTupleTypes();
		for (TupleTypeInformation tupleTypeInformation : tupleTypes) {
			if (tupleTypeInformation.isTypeOf(self)) {
				return tupleTypeInformation;
			}
		}		
		throw new TypeError("No type for " + self);
	}
	
	@Override
	public void inEnumLiteralExp(EnumLiteralExp self) {
		MetamodelNamespace mm = null;
		EEnum found = null;
		for (MetamodelNamespace ns : env.getAnalysis().getNamespaces().getMetamodels()) {
			for (EEnum e : ns.getAllEnums()) {
				if ( e.getELiterals().stream().anyMatch(l -> l.getName().equals(self.getName()) ) ) {
					// We have it
					mm = ns;
					found = e;
				}
			}
		}
		
		if ( found == null ) {
			throw new IllegalStateException("Enum not found: " + self.getName());
		}
		
		EEnumLiteral lit = found.getEEnumLiteral(self.getName());
		
		IMetaDriver driver = env.getDriver(mm.getName());
		String enumType = driver.getEnumQName(found);
		String literalAccess = driver.getLiteralAccess(found, lit);
		
		String access = enumType + "." + literalAccess; //LinGen.getEnumQName(lit.getEEnum()) + "." + LinGen.getLiteralName(lit);
		
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef(self.getInferredType()));
		env.bind(self, newVar, Collections.singletonList( createAssignment(newVar, access)));		
	}
	
	@Override
	public void inOperatorCallExp(OperatorCallExp self) {
		// Translate operators to Java
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "tmp", typ.createTypeRef(self.getInferredType()));

		stms.addAll(env.getStatements(self.getSource()));
		JVariableDeclaration var0 = env.getVar( self.getSource() );
		
		String op = self.getOperationName();
		if ( self.getArguments().size() == 0 ) {
			if ( "not".equals(op) ) op = "!";
			stms.add(createAssignment(newVar, op + " " + var0.getName() ));	
		} else if ( self.getSource().getInferredType() instanceof StringType &&
				    (! "+".equals(op)) ) {
			stms.addAll(env.getStatements(self.getArguments().get(0)));
			JVariableDeclaration var1 = env.getVar( self.getArguments().get(0));

			if ( "=".equals(op) )        {
				stms.add(createAssignment(newVar, var0.getName() + ". " + "equals" + "(" + var1.getName() + ")"));
			}
			else if ( "<>".equals(op) ) {
				stms.add(createAssignment(newVar, "!" + var0.getName() + ". " + "equals" + "(" + var1.getName() + ")"));					
			} else {
				throw new UnsupportedOperationException("Not supported " + op);
			}
		} else if ( op.equals("/") ) {
			stms.addAll(env.getStatements(self.getArguments().get(0)));
			JVariableDeclaration var1 = env.getVar( self.getArguments().get(0));

			// ATL converts both arguments to float
			stms.add(createAssignment(newVar, 
					"((Number)" + var0.getName() + ").floatValue()" + 
					" " + op + " " + 
					"((Number)" + var1.getName() + ").floatValue()"));
			
		} else if ( self.getSource().getInferredType() instanceof EnumType && op.equals("=") ){
			stms.addAll(env.getStatements(self.getArguments().get(0)));
			JVariableDeclaration var1 = env.getVar( self.getArguments().get(0));

			stms.add(createAssignment(newVar, var0.getName() + ". " + "equals" + "(" + var1.getName() + ")"));			
		} else {		
			stms.addAll(env.getStatements(self.getArguments().get(0)));
			JVariableDeclaration var1 = env.getVar( self.getArguments().get(0));
			
			if ( "=".equals(op) )        op = "==";
			else if ( "<>".equals(op) )  op = "!=";
			else if ( "and".equals(op) ) op = "&&";
			else if ( "or".equals(op) )  op = "||";
			
			// Naive attempt. TODO: Identify corner cases: e.g., not, implies
			stms.add(createAssignment(newVar, var0.getName() + " " + op + " " + var1.getName()));
		}
		
		env.bind(self, newVar, stms);				
	}
	
	@Override
	public void inIfExp(IfExp self) {
		Type trueType  = self.getThenExpression().getInferredType();
		Type falseType = self.getElseExpression().getInferredType();
		String castingTrue = "";
		String castingFalse = "";
		if ( ! TypingModel.equalTypes(trueType, falseType) ) {
			if ( trueType instanceof OclUndefinedType ) {
				castingTrue = cast(self.getInferredType());
			} else if ( falseType instanceof OclUndefinedType ) {
				castingFalse = cast(self.getInferredType());
			}
		}
		
		List<JStatement> stms = createCommentedList(self);
		
		stms.addAll(env.getStatements(self.getCondition()));
		
		// Create a new var for the result and initialize
		JVariableDeclaration resultVar = createResultVar(self, stms, false);
		
		JConditional cond = JavagenFactory.eINSTANCE.createJConditional();

		JConditionalBlock ifBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
		ifBlock.setExpr(createTextExp(env.getVar(self.getCondition()).getName()));
		ifBlock.getStatements().addAll(env.getStatements(self.getThenExpression()));
		ifBlock.getStatements().add( createAssignment(resultVar, castingTrue + env.getVar(self.getThenExpression()).getName() ));
		
		JConditionalBlock elseBlock = JavagenFactory.eINSTANCE.createJConditionalBlock();
		elseBlock.getStatements().addAll(env.getStatements(self.getElseExpression()));
		elseBlock.getStatements().add( createAssignment(resultVar, castingFalse + env.getVar(self.getElseExpression()).getName() ));

		
		cond.getConditions().add(ifBlock);
		cond.setElse(elseBlock);
		
		stms.add(cond);
		
		env.bind(self, resultVar, stms);
	}
	
	@Override
	public String createEmptyValue(Type type, boolean isMutable) {
		if ( type instanceof Metaclass ) {
			return "null";
		} else if ( type instanceof PrimitiveType ){
			if ( type instanceof BooleanType ) {
				return "false";
			} else if ( type instanceof StringType ) {
				return "\"\"";
			} else if ( type instanceof IntegerType ) {
				return "0";
			} else if ( type instanceof FloatType ) {
				return "0.0";
			} 
			throw new UnsupportedOperationException();
		// This should go in LintraTyping
		} else if ( type instanceof CollectionType ) {
			if ( isMutable ) {
				if ( type instanceof SetType || typ instanceof OrderedSetType ) {
					return "new " + LindaTyping.MUTABLE_SET_CONCRETE + "()";
				}
				
				return "new " + "java.util.ArrayList" + "()";
			} else {
				if ( type instanceof SetType || typ instanceof OrderedSetType ) {
					return LindaTyping.SET_CONCRETE + ".empty()";
				}
				
				return "javaslang.collection.List.empty()";
			}
			// return createCollectionTypeRef((CollectionType) type);
		} else if ( type instanceof MapType ) {
			return "javaslang.collection.HashMap.empty()";		
		} else if ( type instanceof UnionType ) {
			return "null";
		} else if ( type instanceof EnumType ) {
			EEnumLiteral lit = ((EEnum) ((EnumType) type).getEenum()).getELiterals().get(0);
			
			String access = LinGen.getEnumQName(lit.getEEnum()) + "." + LinGen.getLiteralName(lit);
			return access;			
		} else {
			throw new UnsupportedOperationException(type.toString());
		}
	}

//	@Override
//	public String getGetter(EStructuralFeature f) {
//		return LinGen.getter(f);
//	}
//
//	@Override
//	public String getSetter(EStructuralFeature f) {
//		return LinGen.setter(f);
//	}

	
	private String cast(Type t) {
		return "(" + typ.getType(t) + ")";
	}

	private String castList(Type t, String colExp) {
	//	return "lintra.utils.TypeCastList<" + getType(((CollectionType) t).getContainedType())+ ">(" + colExp + ")";
	//	return "new uk.ac.ebi.utils.collections.TypeCastCollection<" + typ.getType(((CollectionType) t).getContainedType())+ ">(" + colExp + ")";
	//	return "javaslang.collection.List.ofAll(" + colExp + ")";
		
		String s = "new uk.ac.ebi.utils.collections.TypeCastCollection<" + typ.getType(((CollectionType) t).getContainedType())+ ">(" + colExp + ")";;
		
		return "javaslang.collection.List.ofAll(" + s+ ")";	
	}

	private ICollectionsDriver javaslangDriver = new JavaslangDriver();
	private ICollectionsDriver mutableDriver = new MutableListDriver();
	
	private ICompilationContext ctx() {
		return ctx(javaslangDriver);
	}
	
	private ICompilationContext ctx(ICollectionsDriver driver) {
		Context ctx = new ICompilationContext.Context(env, typ, gen, driver, this);
		return ctx;
	}

}
