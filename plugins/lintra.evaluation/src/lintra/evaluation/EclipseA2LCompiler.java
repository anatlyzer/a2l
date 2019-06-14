package lintra.evaluation;

import java.io.FileInputStream;

import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;

/**
 * This class must be executed in the context of an Eclipse instance.
 * 
 * @author jesus
 */
public class EclipseA2LCompiler {

	public static void compile(String file) throws Exception {
		AnalyserData result = new AnalyserExecutor().exec(new FileInputStream(file));
	}
	
}
