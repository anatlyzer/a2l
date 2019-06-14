package a2l.tests.findcouples.lintra;

import lintra2.blackboard.IdMapper;
import lintra2.runners.MTLauncherOutplace;
import lintra2.transfo.IFootprint;
import lintra2.stats.IStatsRecorder;

public class FindCouplesIMDbRunner {
private MTLauncherOutplace mtLauncher;
	private int numThreads;
	private IFootprint footprint;
	private IStatsRecorder stats;
	private lintra2.transfo.IDataSource INDataSource;
	private org.eclipse.emf.ecore.resource.Resource OUTModelResource;
	private org.eclipse.emf.ecore.resource.Resource OUTMetamodelResource;
public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setNumThreads(int n){
numThreads = n;

	return this;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setFootprint(IFootprint n){
footprint = n;

	return this;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setStatsRecorder(IStatsRecorder n){
stats = n;

	return this;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setIN(org.eclipse.emf.ecore.resource.Resource modelINresource){
INDataSource = new lintra.emf.EMFDataSource(modelINresource, footprint);

	return this;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setIN(java.lang.String modelINxmiFile, java.lang.String mmMMxmiFile){
lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.readModel(modelINxmiFile, mmMMxmiFile);return setIN(m.getModel());
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setOUT(org.eclipse.emf.ecore.resource.Resource modelOUTResource, org.eclipse.emf.ecore.resource.Resource mmMM1Resource){
OUTModelResource = modelOUTResource;

	OUTMetamodelResource = mmMM1Resource;

	return this;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner setOUT(java.lang.String modelOUTxmiFile, java.lang.String mmMM1xmiFile){
lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.newModel(modelOUTxmiFile, mmMM1xmiFile);return setOUT(m.getModel(), m.getMetamodel());
}
	public org.eclipse.emf.ecore.resource.Resource getOUTResource(){
return OUTModelResource;
}
	public a2l.tests.findcouples.lintra.FindCouplesIMDbRunner run() throws java.lang.Exception{
IdMapper idMapper0;
a2l.tests.findcouples.lintra.FindCouplesIMDb trafo1;if ( this.stats == null ) this.stats = IStatsRecorder.NULL_RECORDER;;

	stats.startConfiguration();

	mtLauncher = new MTLauncherOutplace(); mtLauncher.createBlackboard();mtLauncher.createSrcArea("IN", this.INDataSource);;

	idMapper0 = new lintra.emf.EMFTargetIdMapper();

	mtLauncher.createTrgArea("OUT", idMapper0);;

	stats.endConfiguration();

	stats.startLaunch();
a2l.tests.findcouples.lintra.FindCouplesIMDb t =  new a2l.tests.findcouples.lintra.FindCouplesIMDb(mtLauncher.getArea(mtLauncher.getSrcAreas(), "IN"), mtLauncher.getArea(mtLauncher.getTrgAreas(), "OUT"), mtLauncher.getCachingArea());double time = mtLauncher.launch(t, mtLauncher.getSrcAreas().stream().map(a -> a.getName()).collect(java.util.stream.Collectors.toList()).toArray(new String[mtLauncher.getSrcAreas().size()]),numThreads <= 0 ? 1 : numThreads);// System.out.println(time);
stats.endLaunch();
stats.startPostprocessing();
t.postprocessing();stats.endPostprocessing();
;

	trafo1 = t;

	stats.startSerialization();

	trafo1.writeOUT(OUTModelResource);
	stats.endSerialization();

	mtLauncher.getSrcAreas().forEach(a -> a.clear());mtLauncher.getTrgAreas().forEach(a -> a.clear());mtLauncher.destroy();;

	return this;
}}