package lintra2.runners;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//import MavenPrj.MavenPrj.InfinispanBlackboard;
import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.HashMapBlackboard;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IBlackboard;
import lintra2.blackboard.IBlackboard.Policy;
import lintra2.blackboard.IdMapper;
import lintra2.blackboard.IdentifiableElement;
import lintra2.blackboard.IdentifiableElementMapper;
import lintra2.transfo.CurrentId;
import lintra2.transfo.IDataSource;
import lintra2.transfo.IMaster;
import lintra2.transfo.ITransformation;
import lintra2.transfo.Master_SingleMT;
import lintra2.transfo.Slave_SingleMT;

public class MTLauncherOutplace {
	
	IBlackboard blackboard;
	IArea workTODOArea, cachingModelArea, ids4RuleWNoInputElem;
	List<IArea> srcModelAreas, trgModelAreas, auxiliaryAreas;
	
	public List<IArea> getSrcAreas(){
		return srcModelAreas;
	}
	
	public List<IArea> getTrgAreas(){
		return trgModelAreas;
	}
	
	public IArea getIds4RuleWNoInputElem() {
		return ids4RuleWNoInputElem;
	}

	public IArea getArea(List<IArea> areas, String name){
		boolean found = false;
		int i = 0;
		while (i<areas.size() && !found){
			if (areas.get(i).getName().equals(name)) {
				found = true;
			}
			i++;
		}
		if (found){
			return areas.get(i-1);
		} else {
			return null;
		}
	}

	public void setSrcAreas(List<IArea> srcAreas){
		srcModelAreas = srcAreas;
	}
	
	public void setTrgAreas(List<IArea> trgAreas){
		trgModelAreas = trgAreas;
	}
	
	public IArea getCachingArea() {
		return cachingModelArea;
	}

	public void createBlackboard() throws BlackboardException{
		blackboard = new HashMapBlackboard();
//		blackboard = new HazelcastBlackboard();
//		blackboard = new EhcacheBlackboard();
//		blackboard = new GigaSpacesBlackboard();
//		blackboard = new InfinispanBlackboard();
//		blackboard = new CoherenceBlackboard();
		workTODOArea = blackboard.createArea("processorSpace", Policy.LOCK_TO_READ, new IdentifiableElementMapper());
		srcModelAreas = new LinkedList<IArea>();
		trgModelAreas = new LinkedList<IArea>(); // blackboard.createArea("processorSpace_Trg", Policy.NEVER_LOCK);
		cachingModelArea = blackboard.createArea("processorSpace_caching", Policy.NEVER_LOCK, new IdentifiableElementMapper());
		auxiliaryAreas = new LinkedList<IArea>();
		ids4RuleWNoInputElem = blackboard.createArea("ids2RuleWNoInputElem", Policy.NEVER_LOCK, new IdentifiableElementMapper()); initializeAreaIds4RuleWNoInputElem(ids4RuleWNoInputElem);
	}
	
	public void createTrgArea(String areaName, IdMapper idMapper) throws BlackboardException {
		IArea area = getArea(trgModelAreas, areaName);
		if (area == null){
			area = blackboard.createArea(areaName, Policy.NEVER_LOCK, idMapper);
			trgModelAreas.add(area);
		} else {
			throw new BlackboardException("Target area with the same name already exists.");
		}
	}
	
	private void initializeAreaIds4RuleWNoInputElem(IArea area) throws BlackboardException {
		CurrentId cid = new CurrentId(1.0);
		area.write(cid);
	}
	
	public List<IArea> getAuxiliaryAreas(){
		return auxiliaryAreas;
	}
	
//	public void loadModel(String areaName, String[] modelPath) throws Exception {
//		IArea area = getSrcArea(areaName);
//		if (area == null){
//			area = blackboard.createArea(areaName, Policy.NEVER_LOCK);
//			srcModelAreas.add(area);
//		}
//		List<Thread> ts = new LinkedList<Thread>();
//		for (int i=0; i<modelPath.length; i++){
//			Thread t = new Thread(new ModelLoader_Single(modelPath[i], area));
//			ts.add(t);
//			t.start();
//		}
//		for (int i=0; i<modelPath.length; i++){
//			ts.get(i).join();
//		}
//	}
	
	public void createSrcArea(String areaName, IDataSource source) throws Exception {
		IArea area = getArea(srcModelAreas, areaName);
		if (area == null){
			area = blackboard.createArea(areaName, Policy.NEVER_LOCK, source.getIdMapper());
			source.fill(area);
			srcModelAreas.add(area);
		}
	}
	
	
//	public double loadModel(String areaName, double firstId, String modelPath) throws Exception {
//		return loadModel(areaName, firstId, modelPath, getClass().getClassLoader());
//	}
	
//	public double loadModel(String areaName, double firstId, String modelPath, ClassLoader classLoader) throws Exception {
//		IArea area = getArea(srcModelAreas, areaName);
//		if (area == null){
//			area = blackboard.createArea(areaName, Policy.NEVER_LOCK);
//			srcModelAreas.add(area);
//		}
//		ModelLoader_Single mls = new ModelLoader_Single(modelPath, area, firstId, classLoader);
//		mls.run();
//		area.setFirstId(firstId);
//		area.setLastId(firstId+mls.getNumElemsLoaded());
//		return mls.getNumElemsLoaded();
//	}
	
	public double launch(ITransformation transfo, String[] mainAreas, int numThreads) throws Exception{
		
		IMaster master = new Master_SingleMT(workTODOArea, numThreads);
		for (String areaName : mainAreas){
			IArea area = getArea(srcModelAreas, areaName);
			((Master_SingleMT)master).organizeWork(area);
		}

		double time0 = System.currentTimeMillis();
		
		List<Thread> ts = new LinkedList<Thread>();
		for (int j=0; j<numThreads; j++){
			Thread t = new Thread(new Slave_SingleMT(j, transfo, workTODOArea), "Lintra Thread " + j);
			t.start();
			ts.add(t);
    	}
		for (int j=0; j<ts.size(); j++){
			ts.get(j).join();
		}
		double timeF = (System.currentTimeMillis() - time0) / 1000;
		
		return timeF;
	}

	public void destroy() {
		for (IArea a : srcModelAreas){
			blackboard.destroyArea(a);	
		}
		for (IArea a : trgModelAreas){
			blackboard.destroyArea(a);	
		}
		blackboard.destroyArea(cachingModelArea);
		blackboard.destroyArea(workTODOArea);
		for (IArea a : auxiliaryAreas){
			blackboard.destroyArea(a);	
		}
	}
	
	public void clearTrgAndTodo(){
		for (IArea a : srcModelAreas){
			blackboard.clearArea(a);	
		}
		for (IArea a : trgModelAreas){
			blackboard.clearArea(a);	
		}
		blackboard.clearArea(cachingModelArea);
		blackboard.clearArea(workTODOArea);
		for (IArea a : auxiliaryAreas){
			blackboard.clearArea(a);	
		}
	}

	public void serialize(IArea trgArea, String modelPath) throws BlackboardException, IOException {
		
		FileOutputStream fis = new FileOutputStream(modelPath);
		ObjectOutputStream ois = new ObjectOutputStream(fis);
		
		Collection<IdentifiableElement> elems;
		while(trgArea.size()!=0){
			elems = trgArea.take(1000);
			for (IdentifiableElement ie : elems){
				ois.writeObject(ie);
			}
		}
		ois.close();
		fis.close();
	}
	
}
