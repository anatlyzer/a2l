package lintra.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import a2l.utils.A2LUtils;
import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.editor.AtlEditorExt;
import anatlyzer.atl.index.AnalysisIndex;
import linda.atlcompiler.LindaCompiler;
import linda.atlcompiler.LintraJDT;

public class CompileFile extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if ( selection instanceof TextSelection ) {
			IEditorPart editor = HandlerUtil.getActiveEditor(event);
			if ( editor instanceof AtlEditorExt ) {
				AtlEditorExt atlEditor = (AtlEditorExt) editor;
				IFile file = (IFile) atlEditor.getUnderlyingResource();

				AnalysisResult result = AnalysisIndex.getInstance().getAnalysis(file);
				if ( result != null ) {
					try { 
						new LintraJDT(result.getAnalyser()).exec(A2LUtils.createCompiler(result.getAnalyser()));
					} catch ( Exception e ) {
						e.printStackTrace();
						ErrorDialog.openError(HandlerUtil.getActiveShell(event), "Error", e.getMessage(), createMultiStatus(e.getMessage(), e) );
					}
				}
				
			}
		}
		
	
		return null;
	}

	
    private static MultiStatus createMultiStatus(String msg, Throwable t) {

        List<Status> childStatuses = new ArrayList<>();
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

         for (StackTraceElement stackTrace: stackTraces) {
                Status status = new Status(IStatus.ERROR,
                                "com.example.e4.rcp.todo", stackTrace.toString());
                childStatuses.add(status);
        }

        MultiStatus ms = new MultiStatus("com.example.e4.rcp.todo",
                        IStatus.ERROR, childStatuses.toArray(new Status[] {}),
                        t.toString(), t);
        return ms;
}
}
