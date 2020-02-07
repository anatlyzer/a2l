package a2l.tests.java2uml.umldeps.optimised;

import lintra2.transfo.IFootprint;

public class java2uml_depsFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext context = (a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext) p_context;

	return (o instanceof org.eclipse.gmt.modisco.java.Package) || (o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) || (o instanceof org.eclipse.gmt.modisco.java.Model);
}}