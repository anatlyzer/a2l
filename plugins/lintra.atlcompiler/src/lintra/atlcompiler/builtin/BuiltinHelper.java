package lintra.atlcompiler.builtin;

import static linda.atlcompiler.CreationHelpers.addStm;
import static linda.atlcompiler.CreationHelpers.createAssignment;
import static linda.atlcompiler.CreationHelpers.createForeach;
import static linda.atlcompiler.CreationHelpers.createLoopVar;
import static linda.atlcompiler.CreationHelpers.createSimpleIf;
import static linda.atlcompiler.CreationHelpers.createText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import a2l.compiler.VarStatementPair;
import a2l.driver.ICollectionsDriver;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.FloatType;
import anatlyzer.atl.types.IntegerType;
import anatlyzer.atl.types.OrderedSetType;
import anatlyzer.atl.types.SetType;
import anatlyzer.atl.types.StringType;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.ITyping;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.ITyping.MutabilityAttribute;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JExprStatement;
import lintra.atlcompiler.javagen.JForeach;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JText;
import lintra.atlcompiler.javagen.JVarExp;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public class BuiltinHelper {

	public static BuiltinOperationRegistry create() {
		BuiltinOperationRegistry r = new BuiltinOperationRegistry();
		
		initOclAnyOperations(r);
		initStringOperations(r);		
		initCollectionOperations(r);
		initIteratorChainOperations(r);
		return r;
	}

	private static void initOclAnyOperations(BuiltinOperationRegistry r) {
		// oclType
		r.register(new AbstractOperationHandler("oclType") {

			@Override
			public boolean supportType(Class<? extends Type> t) { return true; }
			
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();

				stms.add( createAssignment(resultVar, "new lintra.utils.ReflectiveObject(" + source.getName() + ")" ));

				return stms;
			}

		});		
	}
	
	private static void initStringOperations(BuiltinOperationRegistry r) {
		// concat
		r.register(new AbstractOperationHandler("concat") {
			@Override
			public boolean supportType(Class<? extends Type> t) { return StringType.class.isAssignableFrom(t); }
			
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();

				stms.add( createAssignment(resultVar, source.getName() + " + " + args[0].getName()  ));

				return stms;
			}
		});

		// trim
		r.register(new AbstractOperationHandler("trim") {
			@Override
			public boolean supportType(Class<? extends Type> t) { return StringType.class.isAssignableFrom(t); }
			
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();

				stms.add( createAssignment(resultVar, source.getName() + ".trim()" ));

				return stms;
			}
		});


		// toInteger
		r.register(new AbstractOperationHandler("toInteger") {
			@Override
			public boolean supportType(Class<? extends Type> t) { return StringType.class.isAssignableFrom(t); }
			
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();
				stms.add( createAssignment(resultVar, "Integer.parseInt(" + source.getName() + ")" ));
				return stms;
			}
		});
		
		// toReal
		r.register(new AbstractOperationHandler("toReal") {
			@Override
			public boolean supportType(Class<? extends Type> t) { return StringType.class.isAssignableFrom(t); }
			
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();
				stms.add( createAssignment(resultVar, "Double.parseDouble(" + source.getName() + ")" ));
				return stms;
			}
		});

		// compareTo
		r.register(new AbstractOperationHandler("compareTo") {
			@Override
			public boolean supportType(Class<? extends Type> t) { return StringType.class.isAssignableFrom(t); }
		
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();
				stms.add( createAssignment(resultVar, source.getName() + ".compareTo(" + args[0].getName() + ")" ));
				return stms;
			}
		});

	}


	private static void initCollectionOperations(BuiltinOperationRegistry r) {

		// sum
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "sum") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {
				List<JStatement> stms = newStatements();
				
				Type containedType = ((CollectionType) op.getSource().getInferredType()).getContainedType();				
				JVariableDeclaration loopVar = createLoopVar("si", ctx.getTyping().createTypeRef(containedType));

				String init;
				if ( containedType instanceof IntegerType ) {
					init = "0";
				} else if ( containedType instanceof FloatType ) {
					init = "0.0";
				} else {
					throw new UnsupportedTranslation("Cannot translated for " + containedType, op);
				}
				
				stms.add( createAssignment(resultVar, init));

				JForeach foreach = createForeach(source, loopVar);
				stms.add(foreach);

				addStm(foreach, createAssignment(resultVar, resultVar.getName() + " + " + loopVar.getName()));
				
				// Do the sum and assign the sum to resultVar

				return stms;
			}
		});
		// debug
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "debug") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {				
				List<JStatement> stms = newStatements();
				stms.add( CreationHelpers.createText("System.out.println(" + args[0].getName() + "+\":\"+" + source.getName() + ")"));
				stms.add( createAssignment(resultVar, source.getName()));
				return stms;
			}
		});
		// toString
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "toString") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {				
				List<JStatement> stms = newStatements();
				stms.add( createAssignment(resultVar, source.getName() + ".toString()"));
				return stms;
			}
		});
		// asOrderedSet
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "asOrderedSet") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {				
				List<JStatement> stms = newStatements();
				// stms.add( createAssignment(resultVar, "javaslang.collection.TreeSet.ofAll(" + source.getName() +")" ));
				stms.add( createAssignment(resultVar, "javaslang.collection.LinkedHashSet.ofAll(" + source.getName() +")" ));
				return stms;
			}
		});
		// asSequence
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "asSequence") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {				
				List<JStatement> stms = newStatements();
				// stms.add( createAssignment(resultVar, "javaslang.collection.TreeSet.ofAll(" + source.getName() +")" ));
				stms.add( createAssignment(resultVar, "javaslang.collection.List.ofAll(" + source.getName() +")" ));
				return stms;
			}
		});
		// includes
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "includes") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {				
				List<JStatement> stms = newStatements();
				stms.add( createAssignment(resultVar, source.getName() + ".contains("+ args[0].getName() + ")" ));
				return stms;
			}
		});
		// flatten
		r.register(new AbstractCollectionOperationHandler(CollectionType.class, "flatten") {
			@Override
			public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar) {							
				String flattenMethod = "flatten";
				if ( op.getInferredType() instanceof SetType || op.getInferredType() instanceof OrderedSetType ) {
					flattenMethod = "flattenSet";
				}
				List<JStatement> stms = newStatements();
				Type containedType = ((CollectionType) op.getInferredType()).getContainedType();
				String cast = "(" + ctx.getTyping().getType(containedType) + ")";
				stms.add( createAssignment(resultVar, flattenMethod + "(" + source.getName() + ").map(x_ -> " + cast + "x_)" ));
				return stms;
			}
		});
		
	}


	private static void initIteratorChainOperations(BuiltinOperationRegistry r) {
		r.register(new IIteratorChainHandler.Abstract("select-exists") {
			
			// TODO: Assume one select only for the moment
			@Override
			public VarStatementPair compile(Context ctx, IteratorChainExp self, JVariableDeclaration source, ICollectionsDriver mutableDriver) {
				List<JStatement> stms = newStatements();
				
				CompilationEnv env = ctx.getEnv();
				JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
				stms.addAll(env.getStatements(self.getSource()));

				// Result var for exists, create and initializer to false
				JVariableDeclaration resultVar = ctx.getGenerator().addLocalVar(env.currentBlock(), "r", ctx.getTyping().createTypeRef("boolean"));
				stms.add(createAssignment(resultVar, CreationHelpers.createTextExp("false")) );

				
				IteratorChainElement select = self.getChain().get(0);
				Iterator it = self.getIterator();
				
				
				JForeach foreach = createForeach(colVar, env.getVar(it));
				stms.add(foreach);

				addStm(foreach, env.getStatements(select.getBody()));
				

				// exists
				IteratorChainElement exists = self.getChain().get(1);
				
				
				List<JStatement> existStms = newStatements();
				existStms.addAll( env.getStatements(exists.getBody()) );

				// Same as the original implementation
				JAssignment assignment = createAssignment(resultVar, "true");
				JText aBreak = createText("break");
				List<JStatement> stmts = new ArrayList<JStatement>();
				stmts.add(assignment);
				stmts.add(aBreak);
				
				JConditional existsIf = createSimpleIf(env.getVar(exists.getBody()).getName(), stmts);

				existStms.add(existsIf);
				JConditional selectIfStm = createSimpleIf(env.getVar(select.getBody()).getName() + " == true", existStms);

				addStm(foreach, selectIfStm);
				
				return new VarStatementPair(resultVar, stms);
			}
		});

		r.register(new IIteratorChainHandler.Abstract("select-count") {
			
			@Override
			public VarStatementPair compile(Context ctx, IteratorChainExp self, JVariableDeclaration source, ICollectionsDriver mutableDriver) {
				List<JStatement> stms = newStatements();
				
				CompilationEnv env = ctx.getEnv();
				JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
				stms.addAll(env.getStatements(self.getSource()));

				
				// Result is an int
				JVariableDeclaration resultVar = ctx.getGenerator().addLocalVar(env.currentBlock(), "r", ctx.getTyping().createTypeRef("int"));
				stms.add(createAssignment(resultVar, CreationHelpers.createTextExp("0")) );

				Iterator it = self.getIterator();
				JForeach foreach = createForeach(colVar, env.getVar(it));
				stms.add(foreach);

				// Get the first select to start the iteration
				//IteratorChainElement select = self.getChain().get(0);

				//addStm(foreach, env.getStatements(select.getBody()));

				JBlock currentBlock = foreach;
				
				currentBlock = compileFoldedSelects(self.getChain(), env, currentBlock);
				
				currentBlock.getStatements().add(CreationHelpers.createText(resultVar.getName() + "++"));
			
				return new VarStatementPair(resultVar, stms);
			}

		});
		
		r.register(new IIteratorChainHandler.Abstract("collect-flatten") {
			
			@Override
			public VarStatementPair compile(Context ctx, IteratorChainExp self, JVariableDeclaration source, ICollectionsDriver mutableDriver) {
				List<JStatement> stms = newStatements();
				
				CompilationEnv env = ctx.getEnv();
				JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
				stms.addAll(env.getStatements(self.getSource()));

				// Result is a flattened list
				JVariableDeclaration resultVar = ctx.getGenerator().addLocalVar(env.currentBlock(), "r", ctx.getTyping().createTypeRef(self.getInferredType(), true));
				stms.add(createAssignment(resultVar, ctx.getInitializer().createEmptyValue(self.getInferredType(), true)) );
				
				// Generate a for each to maintain the iteration
				Iterator it = self.getIterator();
				JForeach foreach = createForeach(colVar, env.getVar(it));
				stms.add(foreach);

				JBlock currentBlock = foreach;
				
				// Compile selects if any
				currentBlock = compileFoldedSelects(self.getPreChain(), env, currentBlock);
				
				// Compile collects
				EList<IteratorChainElement> chain = self.getChain();
				
				IteratorChainElement initialCollect = chain.get(chain.size() - 1);
				List<JStatement> nextStms = env.getStatements(initialCollect.getBody());
				currentBlock.getStatements().addAll(nextStms);
				
				JVariableDeclaration bodyResult = env.getVar(initialCollect.getBody());				
				ITyping.MutabilityAttribute mutable = env.getAttribute(initialCollect.getBody(), ITyping.MutabilityAttribute.class, MutabilityAttribute.NON_MUTABLE);
				
				JVarExp refToResult = CreationHelpers.refVar(bodyResult);
				
				JStatement addStatement;
				if ( mutable == MutabilityAttribute.NON_MUTABLE ) {
					// Convert the body to a mutable collection
					addStatement = CreationHelpers.createText("com.google.common.collect.Iterables.addAll(" + resultVar.getName() + "," + bodyResult.getName() + ")");
				} else {
					JInvoke addAll = CreationHelpers.createInvoke("addAll", CreationHelpers.refVar(resultVar), refToResult);
					addStatement = CreationHelpers.createExpresionStatement(addAll);
				}
				
				currentBlock.getStatements().add(addStatement);
				
				if ( chain.size() > 1 )
					throw new UnsupportedOperationException();
				
				/*
				for(int i = chain.size() - 1; i >= 0; i--) {
					IteratorChainElement next = chain.get(i);
					List<JStatement> nextStms = env.getStatements(next.getBody());
					
					currentBlock.getStatements().addAll(nextStms);

					Iterator innerIt = self.getIterator();
					JForeach innerForeach = createForeach(colVar, env.getVar(innerIt));

					currentBlock.getStatements().add(innerForeach);
					
					currentBlock = innerForeach;
				}
				*/
				
				return new VarStatementPair(resultVar, stms);
			}
		});
		
		// Very similar to collect->flatten
		r.register(new IIteratorChainHandler.Abstract("select-collect") {

			@Override
			public VarStatementPair compile(Context ctx, IteratorChainExp self, JVariableDeclaration source, ICollectionsDriver mutableDriver) {

				List<JStatement> stms = newStatements();
				
				CompilationEnv env = ctx.getEnv();
				JVariableDeclaration colVar = env.getVar(self.getSource()); // This returns a collection
				stms.addAll(env.getStatements(self.getSource()));

				// Result is a flattened list
				JVariableDeclaration resultVar = ctx.getGenerator().addLocalVar(env.currentBlock(), "r", ctx.getTyping().createTypeRef(self.getInferredType(), true));
				stms.add(createAssignment(resultVar, ctx.getInitializer().createEmptyValue(self.getInferredType(), true)) );
				
				// Generate a for each to maintain the iteration
				Iterator it = self.getIterator();
				JForeach foreach = createForeach(colVar, env.getVar(it));
				stms.add(foreach);

				JBlock currentBlock = foreach;
				
				// Compile selects if any
				currentBlock = compileFoldedSelects(self.getPreChain(), env, currentBlock);
				
				// Compile collects
				List<IteratorChainElement> chain = self.getChain();
				currentBlock = compileFoldedCollects(chain, env, currentBlock);
				
				
				//IteratorChainElement initialCollect = chain.get(chain.size() - 1);
				//List<JStatement> nextStms = env.getStatements(initialCollect.getBody());
				//currentBlock.getStatements().addAll(nextStms);
				
				OclExpression resultCollect = chain.get(0).getBody();
				JVariableDeclaration bodyResult = env.getVar(resultCollect);
				ITyping.MutabilityAttribute mutable = env.getAttribute(resultCollect, ITyping.MutabilityAttribute.class, MutabilityAttribute.NON_MUTABLE);
				
				JVarExp refToResult = CreationHelpers.refVar(bodyResult);
				
				JStatement addStatement;
				if ( mutable == MutabilityAttribute.NON_MUTABLE ) {
					// Convert the body to a mutable collection
					// addStatement = CreationHelpers.createText("com.google.common.collect.Iterables.add(" + resultVar.getName() + "," + bodyResult.getName() + ")");
					// throw new UnsupportedOperationException("Not implemented yet");
					JInvoke addAll = CreationHelpers.createInvoke("add", CreationHelpers.refVar(resultVar), refToResult);
					addStatement = CreationHelpers.createExpresionStatement(addAll);
					
				} else {
					JInvoke addAll = CreationHelpers.createInvoke("add", CreationHelpers.refVar(resultVar), refToResult);
					addStatement = CreationHelpers.createExpresionStatement(addAll);
				}
				
				currentBlock.getStatements().add(addStatement);
				
				return new VarStatementPair(resultVar, stms);
			}
		});
	}

	
}
