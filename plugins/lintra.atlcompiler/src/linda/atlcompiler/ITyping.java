package linda.atlcompiler;

import java.util.function.Supplier;

import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;

public interface ITyping {

	void createLibType(String pkg, String type);
	
	JTypeRef createTypeRef(String string);
	JTypeRef createTypeRef(JType t);

	JTypeRef createMetaTypeRef(Metaclass m);
	JTypeRef createMetaTypeImplRef(Metaclass m);

	JTypeRef createArrayTypeRef(String string);

	JTypeRef createParamTypeRef(String type, String containedType);
	JTypeRef createParamNTypeRef(JType type, JTypeRef...types);

	JTypeRef createTypeRef(Type type);
	JTypeRef createTypeRef(Type type, boolean isMutable);
	
	JTypeRef createTypeRef(Type type, Supplier<JTypeRef> baseType);

	JType getType(String type);
	
	String getType(Type t);

	String getModelName(Metaclass inferredType);

	public static enum MutabilityAttribute {
		MUTABLE,
		NON_MUTABLE
	}
	
}