package a2l.tests.imdb.identity.optimised;

import lintra2.transfo.IFootprint;
import lintra2.stats.IStatsRecorder;
import a2l.runtime.ITransformationFactory;
import a2l.runtime.IModel;
import a2l.runtime.InputExtent;
import a2l.tests.imdb.identity.optimised.IdentityIMDbGlobalContext;
import a2l.runtime.IModel.IOutputModel;

public class IdentityIMDbRunner_Partitioned_NoPost implements ITransformationFactory {
	private InputExtent inputExtent;
	private IdentityIMDbGlobalContext globalContext;
	private int numThreads;
	private IFootprint footprint;
	private IStatsRecorder stats;
	private boolean immediateWrite;
	private lintra2.transfo.IDataSource INDataSource;
	private IModel INModel;
	private org.eclipse.emf.ecore.resource.Resource OUTModelResource;
	private org.eclipse.emf.ecore.resource.Resource OUTMetamodelResource;
	private IOutputModel OUTModel;

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setNumThreads(int n) {
		numThreads = n;

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setFootprint(IFootprint n) {
		footprint = n;

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setStatsRecorder(IStatsRecorder n) {
		stats = n;

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost doImmediateWrite(boolean n) {
		immediateWrite = n;

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setIN(
			org.eclipse.emf.ecore.resource.Resource modelINresource) {
		INDataSource = new lintra.emf.EMFDataSource(modelINresource, footprint);

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setIN(java.lang.String modelINxmiFile,
			java.lang.String mmMMxmiFile) {
		lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.readModel(modelINxmiFile,
				mmMMxmiFile);
		return setIN(m.getModel());
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setOUT(
			org.eclipse.emf.ecore.resource.Resource modelOUTResource,
			org.eclipse.emf.ecore.resource.Resource mmMM1Resource) {
		OUTModelResource = modelOUTResource;

		OUTMetamodelResource = mmMM1Resource;

		return this;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost setOUT(java.lang.String modelOUTxmiFile,
			java.lang.String mmMM1xmiFile) {
		lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.newModel(modelOUTxmiFile,
				mmMM1xmiFile);
		return setOUT(m.getModel(), m.getMetamodel());
	}

	public org.eclipse.emf.ecore.resource.Resource getOUTResource() {
		return OUTModelResource;
	}

	public a2l.tests.imdb.identity.optimised.IdentityIMDbRunner_Partitioned_NoPost run() throws java.lang.Exception {
		a2l.tests.imdb.identity.optimised.IdentityIMDb trafo0;
		if (this.stats == null)
			this.stats = IStatsRecorder.NULL_RECORDER;
		;

		stats.startConfiguration();

//		this.inputExtent = new InputExtent();
//		this.globalContext = new a2l.tests.imdb.identity.optimised.IdentityIMDbGlobalContext();
//		this.INModel = this.INDataSource.createModel();
//		inputExtent.addAll(this.INModel.allInstances());
//		;
		this.globalContext = new a2l.tests.imdb.identity.optimised.IdentityIMDbGlobalContext();
		this.inputExtent = this.INDataSource.toInputExtentPartitioned(numThreads);
		this.INModel = this.INDataSource.createModel();
		;
		
		this.OUTModel = new a2l.runtime.emf.EMFOutputModel(OUTModelResource, OUTMetamodelResource);

		stats.endConfiguration();

		stats.startLaunch();
		// a2l.runtime.DirectExecutor executor = new a2l.runtime.DirectExecutor(numThreads, this, inputExtent);
		a2l.runtime.PartitionedExecutor executor = new a2l.runtime.PartitionedExecutor(numThreads, this, inputExtent);
		executor.execute();
		stats.endLaunch();
		stats.startPostprocessing();
		//executor.postprocessing();
		stats.endPostprocessing();
		;

		stats.startSerialization();

		if (immediateWrite) {
			OUTModel.write();
		}
		stats.endSerialization();

		return this;
	}

	public lintra2.transfo.ITransformation2 create() {
		a2l.tests.imdb.identity.optimised.IdentityIMDb trafo = new a2l.tests.imdb.identity.optimised.IdentityIMDb(
				this.inputExtent, this.globalContext);

		trafo.setIN(INModel);

		trafo.setOUT(OUTModel);

		return trafo;
	}
}