package a2l.driver;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import a2l.driver.IMetaDriver.ITransformationConfigurator;
import anatlyzer.atl.analyser.IAnalyserResult;
import linda.atlcompiler.ICompilationContext;
import lintra.atlcompiler.javagen.JClass;

public class DriverConfiguration {

	protected HashMap<String, IMetaDriver> drivers = new HashMap<>();
	
	public DriverConfiguration addDriver(String mmName, IMetaDriver driver) {
		drivers.put(mmName, driver);
		return this;
	}
	
	public IMetaDriver get(String mmName) {
		if ( ! drivers.containsKey(mmName) )
			throw new IllegalStateException();
		return drivers.get(mmName);
	}
	
	public Collection<IMetaDriver> getDrivers() {
		return drivers.values();
	}

	//
	// Code generation methods
	//
	
	/**
	 * Delegates the transformation class configuration to the drivers.
	 * Since this is a global configuration, only one call is done for each driver class.
	 * 
	 * @param tclass The transformation class
	 */
	public void configureTransformationClass(ICompilationContext ctx, JClass tclass) {
		HashSet<ITransformationConfigurator> set = new HashSet<ITransformationConfigurator>();
		for (IMetaDriver driver : drivers.values()) {
			
			for (ITransformationConfigurator config : driver.getTransformationConfigurators()) {
				if ( set.contains(config) )
					continue;			
				
				config.configureTransformationClass(ctx, this, tclass);
				set.add(config);
			}
			
		}
	}
	
}
