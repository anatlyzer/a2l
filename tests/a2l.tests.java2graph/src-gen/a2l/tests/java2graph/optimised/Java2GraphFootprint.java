package a2l.tests.java2graph.optimised;

import lintra2.transfo.IFootprint;

public class Java2GraphFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) || (o instanceof org.eclipse.gmt.modisco.java.FieldDeclaration);
}}