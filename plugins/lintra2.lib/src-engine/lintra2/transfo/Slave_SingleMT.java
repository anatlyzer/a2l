package lintra2.transfo;

import java.util.Collection;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IdentifiableElement;
import lintra2.blackboard.SearchByIdRange;

public class Slave_SingleMT implements Runnable, ISlave {

	int threadId;
	IArea todoArea;
	ITransformation transfoImpl;

	public Slave_SingleMT(int threadId, ITransformation transfoImpl, IArea todoArea) {
		this.threadId = threadId;
		this.todoArea = todoArea;
		this.transfoImpl = transfoImpl;
	}

	@Override
	public synchronized void run() {

// jesusc: This is an attemp to avoid the overhead of creating a new
//         list for each chunk of work...
//		try {
//			Job we = askForWork();
//			while (we != null) {
//				double minId = we.getMinID();
//				double maxId = we.getMaxID();
//				IArea area = we.getArea();
//				for (double i = minId; i <= maxId; i++) {
//					Object ie = area.read(Double.toString(i));
//					if (ie != null){
//						((ITransformation2) transfoImpl).transform(ie, null);
//					}
//				}
//				
//				// System.out.println("Slave "+threadId+" transformed "+ we.minID + "-" + we.maxID +" elements");
//				we = askForWork();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Job we = askForWork();
			while (we != null) {
				if ( transfoImpl instanceof ITransformation2 ) {
					ITransformation2 t = (ITransformation2) transfoImpl;
					new SearchByIdRange(we.getMinID(), we.getMaxID(), true).applyTo(we.getArea(), o -> {
						try {
							t.transform(o);
						} catch (BlackboardException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});					
				} else {
					Collection<Object> objs = we.getArea().read(
							new SearchByIdRange(we.getMinID(), we.getMaxID(), true));
					transfoImpl.transform(objs, null);
					// System.out.println("Slave "+threadId+" transformed "+ we.minID + "-" + we.maxID +" elements");
				}
				we = askForWork();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private Job askForWork() throws BlackboardException {
		ToDo todoQueue = (ToDo) todoArea.take(LinTraParameters.TODO_ID);
		while(todoQueue == null){
			// it will be null if it is been taken by other slave, therefore the slave must retry until it find it
			todoQueue = (ToDo) todoArea.take(LinTraParameters.TODO_ID);
		}
		Job we = todoQueue.poll();
		/**
		 * depending on the behavior we want when there's no element available
		 * we can choose: l.poll() -> return null l.remove() -> an exception is
		 * thrown l.take() -> waits until there's elements available (the
		 * implementation uses method notify())
		 */
		todoArea.write(todoQueue);
		return we;
	}

}
