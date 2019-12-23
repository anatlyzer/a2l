package a2l.tests.java2graph.optimised;

import lintra2.transfo.IFootprint;

public class Java2GraphFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.FieldDeclaration) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.Package) {
return true;
} else { return false;
}}}