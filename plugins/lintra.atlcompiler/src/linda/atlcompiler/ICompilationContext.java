package linda.atlcompiler;

import a2l.driver.ICollectionsDriver;
import anatlyzer.atl.types.Type;

public interface ICompilationContext {
	CompilationEnv getEnv();
	ITyping getTyping();
	GenCompiler getGenerator();
	ICollectionsDriver getCollectionsDriver();
	
	public static class Context implements ICompilationContext {
		private CompilationEnv env;
		private ITyping typ;
		private GenCompiler gen;
		private ICollectionsDriver collections;
		private IInitializer initializer;

		public Context(CompilationEnv env, ITyping typ, GenCompiler gen, ICollectionsDriver driver, IInitializer initializer) {
			this.env = env;
			this.typ = typ;
			this.gen = gen;
			this.collections = driver;
			this.initializer = initializer;
		}

		@Override
		public CompilationEnv getEnv() {
			return env;
		}

		@Override
		public ITyping getTyping() {
			return typ;
		}

		@Override
		public GenCompiler getGenerator() {
			return gen;
		}

		@Override
		public ICollectionsDriver getCollectionsDriver() {
			return collections;
		}

		public IInitializer getInitializer() {
			return initializer;
		}
	}

	public static interface IInitializer {

		String createEmptyValue(Type type, boolean isMutable);
		
	}
	
}
