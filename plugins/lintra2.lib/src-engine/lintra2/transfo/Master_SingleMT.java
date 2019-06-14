package lintra2.transfo;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;

public class Master_SingleMT implements IMaster {

	IArea workTODOArea;
	int numThreads;
	
	public Master_SingleMT(IArea workTODOArea, int numThreads) {
		this.workTODOArea = workTODOArea;
    	this.numThreads = numThreads;
	}
	
	public synchronized void organizeWork(IArea srcArea) throws BlackboardException {
		/* Inizialize workTODOArea */
		ToDo todo = (ToDo) workTODOArea.read(LinTraParameters.TODO_ID);
		if (todo == null){
			todo = new ToDo();
		}
    	double i = srcArea.getFirstId();
    	double lastId = srcArea.getLastId();
    	int increase = computeOptimalIncrease(numThreads, lastId-srcArea.getFirstId(), LinTraParameters.JOB_SIZE);
    	while(i<lastId){
    		todo.add(new Job(srcArea, i, i+increase));
    		i=i+increase + 1;
    	}
    	workTODOArea.write(todo);	
	}

	private synchronized int computeOptimalIncrease(int numThreads, double numElems, int workExcerptSize) {
		int increase;
		if (numElems / numThreads <  1){
    		increase = 1;
    	} else if (numElems / numThreads <  workExcerptSize){
    		increase = (int) (numElems / numThreads);
    	} else {
    		increase = workExcerptSize;
    	}
		return increase;
	}
	
}
