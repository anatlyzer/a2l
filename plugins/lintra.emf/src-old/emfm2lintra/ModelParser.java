package emfm2lintra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import lintra.lingen.LinGen;
import runners.MTLauncherOutplace;

public class ModelParser {

	private ClassLoader classLoader = ModelParser.class.getClassLoader();

	public static void lintra2xmi(IArea area, String ecorePath, String xmiPath) throws Exception {
		ModelParser parser = new ModelParser();
		parser.lintra2xmi(ecorePath, area, xmiPath);
	}
	
//	public static void lintra2xmi(ClassLoader classLoader, String ecorePath, String serPath, String xmiPath) throws Exception {
//		ModelParser parser = new ModelParser();
//		parser.classLoader = classLoader;
//		parser.lintra2xmi(ecorePath, serPath, xmiPath);
//	}

	public static void xmi2lintra(ClassLoader classLoader, String pathEcoreMMFile, String pathXMIMFile, String pathSerFile) throws Exception {
		ModelParser parser = new ModelParser();
		parser.classLoader = classLoader;
		parser.xmi2lintra(pathEcoreMMFile, pathXMIMFile, pathSerFile);
	}

//  jesusc: Removed because this cannot work using loadModel, which assigns ids on its own
//	public void lintra2xmi(String ecorePath, String serPath, String xmiPath) throws Exception{
//		MTLauncherOutplace mtLauncher = new MTLauncherOutplace();
//		mtLauncher.createBlackboard();
//		mtLauncher.loadModel("srcArea", 1.0, serPath, classLoader); // TODO: Parmeterize
//		lintra2xmi(ecorePath, mtLauncher.getSrcAreas().get(0), xmiPath);
//	}
		
	public void lintra2xmi(String ecorePath, IArea area, String xmiPath) throws IOException, BlackboardException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		 
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map m = reg.getExtensionToFactoryMap();
		m.put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();

		Resource metamodel;
		if (ecorePath.contains("http://") || ecorePath.contains("www.")) {
			metamodel = resSet.getResource(URI.createURI(ecorePath), true);
		} else {
			metamodel = resSet.getResource(URI.createFileURI(ecorePath), true);
			adapt(metamodel);
		}
		
		metamodel.getContents().forEach(p -> resSet.getPackageRegistry().put(((EPackage) p).getNsURI(), p));
		// resSet.getPackageRegistry().put(ep0.getNsURI(), ep0);
		
		// We need to handle all packages. 
		// As a restriction we assume no name clashes between classifiers in different packages
		ArrayList<EClassifier> allClassifiers = new ArrayList<>();
		metamodel.getContents().forEach(p -> {
			allClassifiers.addAll(((EPackage) p).getEClassifiers());
		});
		
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"xmi", new XMIResourceFactoryImpl() {
//					public Resource createResource(URI uri) {
//						XMIResource xmiResource = new XMIResourceImpl(uri);
//						return xmiResource;
//					}
//				});

		Resource myModel = resSet.createResource(
				URI.createURI(xmiPath));
				
		Map<String, EObject> mapEObjects = new HashMap<String, EObject>();
		
		EList<EObject> modelObjects = new BasicEList<EObject>();
		
		for (IdentifiableElement ie : area.read(area.size())){
			String className = ie.getClass().getName().substring(ie.getClass().getName().lastIndexOf(".")+1);
			// Create the instance
			EClass eclass = (EClass) allClassifiers.get(indexOfIn(className, allClassifiers));
			EObject eobject = eclass.getEPackage().getEFactoryInstance().create(eclass);
			eclass.eAllContents();
			eclass.getEAllAttributes();
			eclass.getESuperTypes();
			eclass.getEAllGenericSuperTypes();
			
			// Set its attributes
			List<Field> fields = obtainFields(ie.getClass());
			for (Field field : fields){
				Object value = obtainValue(ie, field);
				if (value==null){
//					System.out.println(field+" is null");
				} else{ 
				if (!field.getName().equals("serialVersionUID")){
					if (field.getName().endsWith("IsComposed")){
						// Do nothing
					} else {
						if (field.getName().equals("id") || field.getName().equals("trgId")){ // ids
							//Do nothing
						} else if (field.getType().getTypeName().toString().contains("String") && field.getName().toLowerCase().endsWith("id")){ //reference
							//References must be created in a second phase
						} else if (field.getType().getName().contains(".Enums$")) { // enum
							EAttribute eattr4 = eclass.getEAllAttributes().get(indexOfIn(field.getName(), eclass.getEAllAttributes())); // setting enum
							eclass.getEStructuralFeatures().add(eattr4);
							String enumName = field.getType().getTypeName().substring(field.getType().getTypeName().indexOf("$")+1);
							if (enumName.endsWith("[]")){enumName=enumName.substring(0, enumName.length()-2);}
							EEnum eenum = (EEnum) allClassifiers.get(indexOfIn(enumName, allClassifiers));
							if (field.getType().isArray()){
								List<Object> list = new LinkedList<Object>();
								for (Object obj : (Object[])value){
									list.add(eenum.getEEnumLiteral(obj.toString()));
								}
								eobject.eSet(eattr4, list);
							} else {
								eobject.eSet(eattr4, eenum.getEEnumLiteral(value.toString()));
							}
							
						} else { // attribute
							String attName = field.getName();
							EStructuralFeature f = eclass.getEStructuralFeature(attName);
							EAttribute eattr = null;
							if ( f instanceof EAttribute ) {
								eattr = (EAttribute) f;
							} else {
								continue;
							}
							
							// EAttribute eattr = eclass.getEAllAttributes().get(indexOfIn(attName, eclass.getEAllAttributes()));
							
							if (field.getType().isArray()){
								if(field.getType().equals(int[].class)){
									List<Integer> list = new LinkedList<Integer>();
									for (int integ : (int[])value){
										list.add(integ);
									}
									eobject.eSet(eattr, list);
								} else if(field.getType().equals(double[].class)){
									List<Double> list = new LinkedList<Double>();
									for (double integ : (double[])value){
										list.add(integ);
									}
									eobject.eSet(eattr, list);
								} else if(field.getType().equals(String[].class)){
									List<String> list = Arrays.asList((String[])value);
									eobject.eSet(eattr, list);
								} else if(field.getType().equals(boolean[].class)){
									List<Boolean> list = new LinkedList<Boolean>(); 
									for (boolean integ : (boolean[])value){
										list.add(integ);
									}
									eobject.eSet(eattr, list);
								}
							} else {
								eobject.eSet(eattr, value);
							}
						}
					}
				}
				}
			}	
			
			mapEObjects.put(ie.getId(), eobject);
		}
		
		
		// Set references
		for (IdentifiableElement ie : area.read(area.size())){
			
			String className = ie.getClass().getName().substring(ie.getClass().getName().lastIndexOf(".")+1);
			EClass eclass = (EClass) allClassifiers.get(indexOfIn(className, allClassifiers));
			EObject eobject = mapEObjects.get(ie.getId());
			
			List<Field> fields = obtainFields(ie.getClass());
		
			for (Field field : fields) {
				Object value = obtainValue(ie, field);
				if (value!=null){
				if (!field.getName().equals("serialVersionUID")) {
					
						if (field.getName().equals("id") || field.getName().equals("trgId")) {
							// Do nothing
						//} else if (field.getName().toLowerCase().endsWith("id") && field.getType().getName().contains("String")) { // reference
						} else if ( field.getAnnotation(lintra.utils.Reference.class) != null ) {
							String refName = field.getName(); //.substring(0, field.getName().length() - 2);

							// EReference eref = eclass.getEAllReferences().get(indexOfIn(refName, eclass.getEAllReferences()));
							EStructuralFeature f = eclass.getEStructuralFeature(refName);
							EReference eref = null;
							if ( f instanceof EReference) {
								eref = (EReference) f;
							} else {
								continue;
							}
							
							if (value.getClass().isArray()){
								String[] ids = (String[]) value;
								List<EObject> l = new LinkedList<EObject>();
								for (String id : ids){
									if ( mapEObjects.get(id) == null ) {
										System.out.println(id);
										throw new IllegalStateException("Cannot find id: " + id);
									}
									l.add(mapEObjects.get(id));
								}
								eobject.eSet(eref, l);
							} else if (!value.getClass().isArray()){
								EObject eo = mapEObjects.get(value);
								eobject.eSet(eref, eo);
							}
						}
					
					}
				}
			}
			// Save the instance in case it is not conteined in any resource
			if (eobject.eContainer()==null){
				modelObjects.add(eobject);
			}
		}
		
		// Add all the instances to the model and serialize it to an xmi file
		for(EObject o : modelObjects) {
			if ( o.eContainer() == null )
				myModel.getContents().add(o);
		}
		myModel.save(null);
	}

	private Object obtainValue(IdentifiableElement ie, Field field)
			throws IllegalAccessException, InvocationTargetException {
		Object value = null;
		Class<?> clazz = ie.getClass();
		Method[] methods = clazz.getMethods();
		for (Method m : methods){
			if (m.getName().equals("get"+firstToUpper(field.getName()))){
				value = m.invoke(ie, null);
			}
		}
		return value;
	}
	
	private void setValue(IdentifiableElement ie, String fieldName, Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> clazz = ie.getClass();
		Method[] methods = clazz.getMethods();
		for (Method m : methods){
			if (m.getName().equals("set"+firstToUpper(fieldName))){
				value = m.invoke(ie, value);
			}
		}
	}

	private List<Field> obtainFields(
			Class<? extends IdentifiableElement> class1) {
		List<Field> fields = new LinkedList<Field>();
		fields.addAll(Arrays.asList(class1.getDeclaredFields()));
		Class classAux = class1.getSuperclass();
		while(classAux!=null && classAux.getDeclaredFields()!=null){
			fields.addAll(Arrays.asList(classAux.getDeclaredFields()));
			classAux = classAux.getSuperclass();
		}
		return fields;
	}

	private int indexOfIn(String name, List<? extends ENamedElement> eList) {
		boolean found = false;
		int i=0;
		while (!found && i<eList.size()){
			found = eList.get(i).getName().equals(name);
			i++;
		}
		if (found){
			return i-1;
		} else {
			return -1;
		}
	}
	
	private static void printEAllAttributes(EClass eclass) {
		eclass.getEAllAttributes();
		for (ENamedElement att : eclass.getEAllAttributes()){
			System.out.print(att.getName()+" ");
		}
		System.out.println();
	}

	private String firstToUpper(String mmname) {
		return mmname.substring(0, 1).toUpperCase()+mmname.substring(1, mmname.length());
	}
	
	public void xmi2lintra(String pathEcoreMMFile, String pathXMIMFile, String pathSerFile)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException, NoSuchMethodException, SecurityException, IOException {
		
		ResourceSet resSet = readInModel(pathEcoreMMFile);
		Resource model = resSet.getResource(URI.createFileURI(pathXMIMFile), true);

		Map<EObject, String> map = createObjects2IdsMap(model.getContents());
		
		List<IdentifiableElement> modelElems = new LinkedList<IdentifiableElement>();
		
		
		for (Iterator it2 = model.getAllContents(); it2.hasNext();) {
			EObject currentObject = (EObject) it2.next();
			modelElems.add(emfObject2LintraObject(currentObject, pathEcoreMMFile, map));
		}
		
		writeSer(modelElems, pathSerFile);
	}

	private IdentifiableElement emfObject2LintraObject(EObject currentObject, String pathEcoreMMFile, Map<EObject, String> map) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
				
		/* Create object */
		//Class<?> clazz = classLoader.loadClass(mmName(pathEcoreMMFile)+"." + currentObject.eClass().getName());
		Class<?> clazz = classLoader.loadClass(mmName(currentObject)+"." + currentObject.eClass().getName());
		
		Class[] cArg = new Class[1 + currentObject.eClass().getEAllAttributes().size() + currentObject.eClass().getEAllReferences().size()];
		Object[] cParams = new Object[1 + currentObject.eClass().getEAllAttributes().size() + currentObject.eClass().getEAllReferences().size()];
		cArg[0] = String.class; // the first param of every constructor is the id which is of type String
		cParams[0] = map.get(currentObject); // id
		int i = 1;		
		for (Iterator it2 = currentObject.eClass().getEAllStructuralFeatures().iterator(); it2.hasNext();) {
			
			Object ef = it2.next();
			if (ef instanceof EAttribute){
				
				EAttribute attribute = (EAttribute) ef;
				if (attribute.getEType().getName().equals("EString")){
					parseStringAtt(currentObject, cArg, cParams, i, attribute);
				} else if (attribute.getEType().getName().equals("EDouble")){
					parseDoubleAtt(currentObject, cArg, cParams, i, attribute);
				} else if (attribute.getEType().getName().equals("EInt")){
					parseIntegerAtt(currentObject, cArg, cParams, i, attribute);
				} else if (attribute.getEType().getName().equals("EBoolean")){
					parseBooleanAtt(currentObject, cArg, cParams, i, attribute);
				} else if (attribute.getEType().eClass().getName().equals("EEnum")){
					parseEnumAtt(currentObject, pathEcoreMMFile, cArg, cParams, i, attribute);
				} else {
					// Heuristics to detect custom datatypes (as in KM3-based meta-models)
					if ( attribute.getEType().getName().toLowerCase().contains("string") ) {
						parseStringAtt(currentObject, cArg, cParams, i, attribute);
					}  else if (attribute.getEType().getName().toLowerCase().contains("int")){
						parseIntegerAtt(currentObject, cArg, cParams, i, attribute);
					} else {
						// This is to handle attributes whose type is a Java class (e.g., java.lang.Object)
						if ( attribute.getEType().getInstanceClassName() != null ) {
							Class<?> type = classLoader.loadClass(attribute.getEType().getInstanceClassName());
							Object value  = currentObject.eGet(attribute);
							if ( attribute.isMany() ) throw new UnsupportedOperationException();
							
							cArg[i] = type;
							cParams[i] = value;
						} else {
							System.out.println(attribute.getEType());
							System.out.println("Finish implementation!");
						}
					}
				}
			} else {
				EReference reference = (EReference) ef;
				if (reference.isMany()){
					cArg[i] = String[].class;
					List<EObject> l = (List<EObject>) currentObject.eGet(reference);
					String[] params = new String[l.size()];
					for (int k=0; k<l.size(); k++){
						params[k] = map.get(l.get(k)); 
					}
					cParams[i] = params; // ids
				} else {
					cArg[i] = String.class;
					EObject o = (EObject) currentObject.eGet(reference);
					cParams[i] = map.get(o); // id
				}
			}
			i++;
		}

		Constructor<?> ctor = clazz.getConstructor(cArg);
		Object object = ctor.newInstance( cParams );
		
		return ((IdentifiableElement)object);
	}

	private void parseEnumAtt(EObject currentObject,
			String pathEcoreMMFile, Class[] cArg, Object[] cParams, int i, EAttribute attribute) throws ClassNotFoundException {
		Class clazzArg;
		if (attribute.isMany()){
			EcoreEList datatypelist = (EcoreEList) currentObject.eGet(attribute);
			
			clazzArg = classLoader.loadClass(mmName(pathEcoreMMFile)+".Enums$"+attribute.getEType().getName());
			cArg[i] = Array.newInstance(clazzArg, datatypelist.size()).getClass();
			
			Object aux = null;
			if (datatypelist!=null && datatypelist.size()>0){
				aux = Array.newInstance(clazzArg, datatypelist.size());
				for (int k=0; k<datatypelist.size(); k++){
					Object value = parseSingleEnumAtt(datatypelist.get(k), clazzArg);
					Array.set(aux, k, value);
				}
			}
			cParams[i] = aux;
			
		} else {
			// clazzArg = classLoader.loadClass(mmName(pathEcoreMMFile)+".Enums$"+attribute.getEType().getName());
			clazzArg = classLoader.loadClass(mmName(pathEcoreMMFile)+"."+attribute.getEType().getName());
			cArg[i] = clazzArg;
			cParams[i] = parseSingleEnumAtt(currentObject.eGet(attribute), clazzArg);
		}
	}

	private Object parseSingleEnumAtt(Object enumAtt, Class clazzArg) {
		Object result = null;
		Object[] literals = clazzArg.getFields();
		Object[] values = clazzArg.getEnumConstants();
		boolean found = false;
		int k=0;
		while (k<literals.length && !found){
			if (enumAtt.toString().equals(values[k].toString())){
				result = Enum.valueOf(clazzArg, literals[k].toString().substring(literals[k].toString().lastIndexOf(".")+1));
				found = true;
			}
			k++;
		}
		return result;
	}

	private void parseBooleanAtt(EObject currentObject, Class[] cArg,
			Object[] cParams, int i, EAttribute attribute) {
		if (attribute.isMany()){
			cArg[i] = boolean[].class;
			EDataTypeEList datatypelist = (EDataTypeEList) currentObject.eGet(attribute);
			boolean[] aux = null;
			if (datatypelist!=null && datatypelist.size()>0){
				aux = new boolean[datatypelist.size()];
				for (int k=0; k<datatypelist.size(); k++){
					aux[k] = (boolean) datatypelist.get(k);
				}
			}
			cParams[i] = (Object) aux;
		} else {
			cArg[i] = boolean.class;
			cParams[i] = currentObject.eGet(attribute);
		}
	}

	private static void parseStringAtt(EObject currentObject, Class[] cArg,
			Object[] cParams, int i, EAttribute attribute) {
		if (attribute.isMany()){
			cArg[i] = String[].class;
			EDataTypeEList datatypelist = (EDataTypeEList) currentObject.eGet(attribute);
			String[] aux = null;
			if (datatypelist!=null && datatypelist.size()>0){
				aux = new String[datatypelist.size()];
				for (int k=0; k<datatypelist.size(); k++){
					aux[k] = (String) datatypelist.get(k);
				}
			}
			cParams[i] = (Object) aux;
		} else {
			cArg[i] = String.class;
			cParams[i] = currentObject.eGet(attribute);
		}
	}

	private static void parseDoubleAtt(EObject currentObject, Class[] cArg,
			Object[] cParams, int i, EAttribute attribute) {
		if (attribute.isMany()){
			cArg[i] = double[].class;
			EDataTypeEList datatypelist = (EDataTypeEList) currentObject.eGet(attribute);
			double[] aux = null;
			if (datatypelist!=null && datatypelist.size()>0){
				aux = new double[datatypelist.size()];
				for (int k=0; k<datatypelist.size(); k++){
					aux[k] = (double) datatypelist.get(k);
				}
			}
			cParams[i] = (double[]) aux;
		} else {
			cArg[i] = double.class;
			cParams[i] = Double.parseDouble(currentObject.eGet(attribute).toString());
		}
	}

	private static void parseIntegerAtt(EObject currentObject, Class[] cArg,
			Object[] cParams, int i, EAttribute attribute) {
		if (attribute.isMany()){
			cArg[i] = int[].class;
			EDataTypeEList datatypelist = (EDataTypeEList) currentObject.eGet(attribute);
			int[] aux = null;
			if (datatypelist!=null && datatypelist.size()>0){
				aux = new int[datatypelist.size()];
				for (int k=0; k<datatypelist.size(); k++){
					aux[k] = (int) datatypelist.get(k);
				}
			}
			cParams[i] = (int[]) aux;
		} else {
			cArg[i] = int.class;
			Object v = currentObject.eGet(attribute);
			cParams[i] = v == null ? 0 : Integer.parseInt(v.toString());
		}
	}


	private String mmName(EObject obj) {
		EPackage ep0 = obj.eClass().getEPackage();
		if ( ep0 == null ) throw new IllegalStateException();
		return LinGen.getPkgName(ep0);
	}
	
	private static String mmName(String pathEcoreMMFile) {
//		return pathEcoreMMFile.substring(pathEcoreMMFile.lastIndexOf("\\")+1, pathEcoreMMFile.lastIndexOf("."));
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map m = reg.getExtensionToFactoryMap();
		m.put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();

		Resource metamodel;
		if (pathEcoreMMFile.contains("http://")
				|| pathEcoreMMFile.contains("www.")) {
			metamodel = resSet
					.getResource(URI.createURI(pathEcoreMMFile), true);
		} else {
			metamodel = resSet.getResource(
					URI.createFileURI(pathEcoreMMFile), true);
		}
		
		EPackage ep0 = (EPackage) metamodel.getContents().get(0);
		return LinGen.getPkgName(ep0);
		// return ep0.getName();
	}

	private static ResourceSet readInModel(String pathEcoreMMFile) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map m = reg.getExtensionToFactoryMap();
		m.put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();

		Resource metamodel;
		if ( pathEcoreMMFile.equals("http://www.eclipse.org/emf/2002/Ecore") ) {
			metamodel = EcorePackage.eINSTANCE.eResource();
		} if (pathEcoreMMFile.contains("http://") || pathEcoreMMFile.contains("www.")) {
			// metamodel = resSet.getResource(URI.createURI(pathEcoreMMFile), true);
			EPackage pkg = (EPackage) Registry.INSTANCE.get(pathEcoreMMFile);
			metamodel = pkg.eResource();
		} else {
			metamodel = resSet.getResource(URI.createFileURI(pathEcoreMMFile), true);
			adapt(metamodel);
		}
		
		for (EObject obj : metamodel.getContents()) {
			resSet.getPackageRegistry().put(((EPackage) obj).getNsURI(), obj);
		}

//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"xmi", new XMIResourceFactoryImpl() {
//					public Resource createResource(URI uri) {
//						XMIResource xmiResource = new XMIResourceImpl(uri);
//						return xmiResource;
//					}
//				});
		return resSet;
	}
	
	double currentId = 1;
	
	private Map<EObject, String> createObjects2IdsMap(List<EObject> elem) {
		Map<EObject, String> objects2Ids = new HashMap<EObject, String>();
		objects2Ids.putAll(createObjects2IdsMapRec(elem, objects2Ids));
		return objects2Ids;
	}
	
	private Map<EObject, String> createObjects2IdsMapRec(List<EObject> elem, Map<EObject, String> objects2Ids) {
		for (EObject e : elem) {
			objects2Ids.put(e, Double.toString(currentId)); currentId++;
			if (e.eContents() != null) {
				objects2Ids.putAll(createObjects2IdsMapRec(e.eContents(), objects2Ids));
			}
		}
		return objects2Ids;
	}
	
	private static void writeSer(List<IdentifiableElement> elems, String path) throws IOException {
		FileOutputStream saveFile = new FileOutputStream(path);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		for (IdentifiableElement o : elems) {
			save.writeObject(o);
		}
		save.close();
	}

	
	// Copied from the ATL plug-in EReferenceModel. This is needed to make the parser
	// work with KM3 exported meta-models (not very elegant workaround though...)
	private static void adapt(Resource metamodel) {
		for (Iterator<EObject> i = metamodel.getAllContents(); i.hasNext();) {
			EObject v = i.next();
			if ( ! (v instanceof EDataType) ) 
				continue;
			EDataType dt = (EDataType)v;
			String tname = dt.getName();
			String icn = dt.getInstanceClassName();
			if (icn == null) {
				if (tname.equals("Boolean")) { //$NON-NLS-1$
					icn = "boolean"; //$NON-NLS-1$
				} else if (tname.equals("Double") || tname.equals("Real")) { //$NON-NLS-1$ //$NON-NLS-2$
					icn = "java.lang.Double"; //$NON-NLS-1$
				} else if (tname.equals("Float")) { //$NON-NLS-1$
					icn = "java.lang.Float"; //$NON-NLS-1$
				} else if (tname.equals("Integer")) { //$NON-NLS-1$
					icn = "java.lang.Integer"; //$NON-NLS-1$
				} else if (tname.equals("String")) { //$NON-NLS-1$
					icn = "java.lang.String"; //$NON-NLS-1$
				}
				if (icn != null) {
					dt.setInstanceClassName(icn);
				}
			}
		}
	}

}
