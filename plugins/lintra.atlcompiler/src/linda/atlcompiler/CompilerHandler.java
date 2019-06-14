package linda.atlcompiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.apache.commons.io.input.ReaderInputStream;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;

import a2l.utils.A2LUtils;
import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;

public class CompilerHandler implements AtlStandaloneCompiler {

	@Override
	public CompileTimeError[] compile(InputStream in, String outputFileName) {
		System.out.println("CompilerHandler.compile()");
		try {
			AnalyserData data = new AnalyserExecutor().exec(in);
			new LintraJDT(data.getAnalyser()).exec(A2LUtils.createCompiler(data.getAnalyser()));
			
			return new CompileTimeError[0];
		} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
			return new CompileTimeError[] { new CompileTimeError("error", "0:0", e.getMessage()) };			
		}
	}

	@Override
	public EObject[] compileWithProblemModel(InputStream in, String outputFileName) {
		System.out.println("CompilerHandler.compileWithProblemModel()");
		try {
			AnalyserData data = new AnalyserExecutor().exec(in);
			if ( data == null )
				return new EObject[0];
			new LintraJDT(data.getAnalyser()).exec(A2LUtils.createCompiler(data.getAnalyser()));
			
			return new EObject[0];
		} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
			// EClass c = EcoreFactory.eINSTANCE.createEClass();
			// c.setName();
			throw new RuntimeException(e);
		}
	}

	@Override
	public EObject[] compileWithProblemModel(InputStream in, OutputStream outputStream) {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject[] compileWithProblemModel(IModel atlModel, OutputStream outputStream) {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject[] compileWithProblemModel(IModel atlModel, String outputFileName) {
		throw new UnsupportedOperationException();
	}

	// This is for ATL 3.7...
	
	@Override
	public CompileTimeError[] compile(Reader in, String outputFileName) {
		System.out.println("CompilerHandler.compile(Reader, String)");
		return compile(new ReaderInputStream(in), outputFileName);
	}

	@Override
	public EObject[] compileWithProblemModel(Reader in, String outputFileName) {
		System.out.println("CompilerHandler.compileWithProblemModel(Reader, String)");
		return compileWithProblemModel(new ReaderInputStream(in), outputFileName);
		
	}

	@Override
	public EObject[] compileWithProblemModel(Reader in, OutputStream outputStream) {
		throw new UnsupportedOperationException();
	}

}
