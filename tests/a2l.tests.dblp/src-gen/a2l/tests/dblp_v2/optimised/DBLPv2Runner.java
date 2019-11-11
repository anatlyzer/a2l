package a2l.tests.dblp_v2.optimised;

import lintra2.transfo.IFootprint;
import lintra2.stats.IStatsRecorder;
import a2l.runtime.ITransformationFactory;
import a2l.runtime.IModel;
import a2l.runtime.InputExtent;
import a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext;
import a2l.runtime.IModel.IOutputModel;

public class DBLPv2Runner implements ITransformationFactory{
private InputExtent inputExtent;
	private DBLPv2GlobalContext globalContext;
	private int numThreads;
	private IFootprint footprint;
	private IStatsRecorder stats;
	private boolean immediateWrite;
	private lintra2.transfo.IDataSource INDataSource;
	private IModel INModel;
	private org.eclipse.emf.ecore.resource.Resource OUTModelResource;
	private org.eclipse.emf.ecore.resource.Resource OUTMetamodelResource;
	private IOutputModel OUTModel;
public a2l.tests.dblp_v2.optimised.DBLPv2Runner setNumThreads(int n){
numThreads = n;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setFootprint(IFootprint n){
footprint = n;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setStatsRecorder(IStatsRecorder n){
stats = n;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner doImmediateWrite(boolean n){
immediateWrite = n;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setIN(org.eclipse.emf.ecore.resource.Resource modelINresource){
INDataSource = new lintra.emf.EMFDataSource(modelINresource, footprint);

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setIN(java.lang.String modelINxmiFile, java.lang.String mmMMxmiFile){
lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.readModel(modelINxmiFile, mmMMxmiFile);return setIN(m.getModel());
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setOUT(org.eclipse.emf.ecore.resource.Resource modelOUTResource, org.eclipse.emf.ecore.resource.Resource mmMM1Resource){
OUTModelResource = modelOUTResource;

	OUTMetamodelResource = mmMM1Resource;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner setOUT(java.lang.String modelOUTxmiFile, java.lang.String mmMM1xmiFile){
lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.newModel(modelOUTxmiFile, mmMM1xmiFile);return setOUT(m.getModel(), m.getMetamodel());
}
	public org.eclipse.emf.ecore.resource.Resource getOUTResource(){
return OUTModelResource;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2Runner run() throws java.lang.Exception{
a2l.tests.dblp_v2.optimised.DBLPv2 trafo0;if ( this.stats == null ) this.stats = IStatsRecorder.NULL_RECORDER;;

	stats.startConfiguration();

	this.inputExtent = new InputExtent(); this.globalContext = new a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext();this.INModel = this.INDataSource.createModel(this.globalContext::addAllInstancesObject);inputExtent.addAll(this.INModel.allInstances());;

	this.OUTModel = new a2l.runtime.emf.EMFOutputModel(OUTModelResource, OUTMetamodelResource);

	stats.endConfiguration();

	stats.startLaunch();
a2l.runtime.DirectExecutor executor = new a2l.runtime.DirectExecutor(numThreads, this, inputExtent);executor.execute();executor.addProfilingTo(stats);stats.endLaunch();
stats.startPostprocessing();
executor.postprocessing(this.globalContext);stats.endPostprocessing();
;

	stats.startSerialization();

	if ( immediateWrite) {
OUTModel.write();}
	stats.endSerialization();

	return this;
}
	public lintra2.transfo.ITransformation2 create(){
a2l.tests.dblp_v2.optimised.DBLPv2 trafo = new a2l.tests.dblp_v2.optimised.DBLPv2(this.inputExtent, this.globalContext);

	trafo.setIN(INModel);

	trafo.setOUT(OUTModel);

	return trafo;
}}