package emfm2lintra;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import blackboard.IdentifiableElement;

public class EmfObject2LintraObject implements Runnable {

	IdentifiableElement result;
	
	public EmfObject2LintraObject(EObject currentObject, String mmName, Map<EObject, String> map) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	public IdentifiableElement getResult() {
        return result;
    }

}
