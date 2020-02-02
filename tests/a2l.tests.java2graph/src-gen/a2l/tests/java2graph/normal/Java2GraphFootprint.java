package a2l.tests.java2graph.normal;

import lintra2.transfo.IFootprint;

public class Java2GraphFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.java2graph.normal.Java2GraphGlobalContext context = (a2l.tests.java2graph.normal.Java2GraphGlobalContext) p_context;

	return (o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) || (o instanceof org.eclipse.gmt.modisco.java.FieldDeclaration);
}}