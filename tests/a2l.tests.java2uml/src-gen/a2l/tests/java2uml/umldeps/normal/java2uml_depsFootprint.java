package a2l.tests.java2uml.umldeps.normal;

import lintra2.transfo.IFootprint;

public class java2uml_depsFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof org.eclipse.gmt.modisco.java.Type) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.TypeAccess) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.PrimitiveType) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.Model) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.FieldDeclaration) {
return true;
}else if ( o instanceof org.eclipse.gmt.modisco.java.Package) {
return true;
} else { return false;
}}}