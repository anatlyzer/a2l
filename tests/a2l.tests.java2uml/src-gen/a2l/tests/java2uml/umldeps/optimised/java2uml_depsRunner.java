package a2l.tests.java2uml.umldeps.optimised;

import lintra2.transfo.IFootprint;
import lintra2.stats.IStatsRecorder;
import a2l.runtime.ITransformationFactory;
import a2l.runtime.IModel;
import a2l.runtime.InputExtent;
import a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext;
import a2l.runtime.IModel.IOutputModel;

public class java2uml_depsRunner implements ITransformationFactory {
	private InputExtent inputExtent;
	private java2uml_depsGlobalContext globalContext;
	private int numThreads;
	private IFootprint footprint;
	private IStatsRecorder stats;
	private boolean immediateWrite;
	private lintra2.transfo.IDataSource CMDataSource;
	private IModel CMModel;
	private org.eclipse.emf.ecore.resource.Resource UCDModelResource;
	private org.eclipse.emf.ecore.resource.Resource UCDMetamodelResource;
	private IOutputModel UCDModel;

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setNumThreads(int n) {
		numThreads = n;

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setFootprint(IFootprint n) {
		footprint = n;

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setStatsRecorder(IStatsRecorder n) {
		stats = n;

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner doImmediateWrite(boolean n) {
		immediateWrite = n;

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setCM(
			org.eclipse.emf.ecore.resource.Resource modelCMresource) {
		CMDataSource = new lintra.emf.EMFDataSource(modelCMresource, footprint);

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setCM(java.lang.String modelCMxmiFile,
			java.lang.String mmJMMxmiFile) {
		lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.readModel(modelCMxmiFile,
				mmJMMxmiFile);
		return setCM(m.getModel());
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setUCD(
			org.eclipse.emf.ecore.resource.Resource modelUCDResource,
			org.eclipse.emf.ecore.resource.Resource mmUMLMMResource) {
		UCDModelResource = modelUCDResource;

		UCDMetamodelResource = mmUMLMMResource;

		return this;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner setUCD(java.lang.String modelUCDxmiFile,
			java.lang.String mmUMLMMxmiFile) {
		lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.newModel(modelUCDxmiFile,
				mmUMLMMxmiFile);
		return setUCD(m.getModel(), m.getMetamodel());
	}

	public org.eclipse.emf.ecore.resource.Resource getUCDResource() {
		return UCDModelResource;
	}

	public a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner run() throws java.lang.Exception {
		a2l.tests.java2uml.umldeps.optimised.java2uml_deps trafo0;
		if (this.stats == null)
			this.stats = IStatsRecorder.NULL_RECORDER;
		;

		stats.startConfiguration();

		this.inputExtent = new InputExtent();
		this.globalContext = new a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext();
		this.CMModel = this.CMDataSource.createModel(this.globalContext::addAllInstancesObject, globalContext);
		inputExtent.addAll(this.CMModel.allInstances());
		inputExtent.shuffle();
		;

		this.UCDModel = new a2l.runtime.emf.EMFOutputModel(UCDModelResource, UCDMetamodelResource);

		stats.endConfiguration();

		System.out.println("Starting execution...");
		stats.startLaunch();
		a2l.runtime.DirectExecutor executor = new a2l.runtime.DirectExecutor(numThreads, this, inputExtent);
		executor.execute();
		executor.addProfilingTo(stats);
		System.out.println("Finished execution...");
		stats.endLaunch();
		stats.startPostprocessing();
		executor.postprocessing(this.globalContext);
		stats.endPostprocessing();
		;

		stats.startSerialization();

		if (immediateWrite) {
			UCDModel.write();
		}
		stats.endSerialization();

		return this;
	}

	public lintra2.transfo.ITransformation2 create() {
		a2l.tests.java2uml.umldeps.optimised.java2uml_deps trafo = new a2l.tests.java2uml.umldeps.optimised.java2uml_deps(
				this.inputExtent, this.globalContext);

		trafo.setCM(CMModel);

		trafo.setUCD(UCDModel);

		return trafo;
	}
}