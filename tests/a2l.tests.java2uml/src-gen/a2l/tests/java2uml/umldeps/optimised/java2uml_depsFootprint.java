package a2l.tests.java2uml.umldeps.optimised;

import lintra2.transfo.IFootprint;

public class java2uml_depsFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) || (o instanceof org.eclipse.gmt.modisco.java.Package) || (o instanceof org.eclipse.gmt.modisco.java.Model);
}}