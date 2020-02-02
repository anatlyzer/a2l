package lintra2.runners;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import a2l.runtime.IGlobalContext;
import a2l.runtime.IModel;
import a2l.runtime.InputExtent;
import a2l.runtime.lintra.ILintraModel;
import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IdMapper;
import lintra2.blackboard.IdentifiableElement;
import lintra2.transfo.IDataSource;
import lintra2.transfo.IDataSource.AllInstancesAdder;
import lintra2.transfo.TraceFunction;

public class LintraDataSource implements IDataSource {

	private ILintraModelReader reader;
	private LintraIdMapper idMapper;
	private String metamodelName;
	
	public LintraDataSource(ILintraModelReader reader, String modelName, String metamodelName) {
		this.reader = reader;
		this.idMapper = new LintraIdMapper(modelName, metamodelName);
		this.metamodelName = metamodelName;
	}
	
	@Override
	public IdMapper getIdMapper() {
		return idMapper;
	}

	@Override
	public void fill(IArea area) {
		int i = 0;
		for (Object o : reader.getAllObjects()) {
			try {
				((IdentifiableElement) o).setTrgId(metamodelName);
				area.write(o);
				i++;
			} catch (BlackboardException e) {
				throw new RuntimeException(e);
			}
		}
		
		idMapper.setNumElements(i);
	}
	
	public static class LintraIdMapper implements IdMapper<Object>{

		private int numElements;
		private String modelName;
		private String metamodelName;
		
		public LintraIdMapper(int numElements, String modelName, String metamodelName) {
			this.numElements = numElements;
			this.modelName = modelName;
			this.metamodelName = metamodelName;
		}

		public void setNumElements(int numElements) {
			this.numElements = numElements;
		}

		public LintraIdMapper(String modelName, String metamodelName) {
			this(0, metamodelName, metamodelName);
		}

		@Override
		public String getId(Object e) {
			if ( e instanceof IdentifiableElement )
				return ((IdentifiableElement) e).getId();
			return null;
		}

		@Override
		public void addMapping(Object e, String id) {
			((IdentifiableElement) e).setId(id);
			((IdentifiableElement) e).setTrgId(metamodelName);
			// contents.add((IdentifiableElement) e); // TODO: Use some text-encoding strategy to avoid having the hashset just for belongsTo
		}

		// private HashSet<IdentifiableElement> contents = new HashSet<IdentifiableElement>();
		
		@Override
		public boolean belongsTo(Object obj) {
			if ( obj instanceof IdentifiableElement ) {
				return ((IdentifiableElement) obj).getTrgId().equals(metamodelName); 
			}
			return false;
			// return contents.contains(obj);
		}


		@Override
		public int getFirstId() {
			return 0;
		}

		@Override
		public int getLastId() {
			return getFirstId() + this.numElements;
		}
		
	}

	@Override
	public IModel createModel(AllInstancesAdder adder, IGlobalContext context) {
		return new LintraModel(reader.getAllObjects(), metamodelName);
	}

	public static class LintraModel implements IModel, ILintraModel {

		private List<Object> allInstances;
		private HashMap<String, Object> idToObject; 
		
		public LintraModel(Collection<Object> allObjects, String metamodelName) {
			this.allInstances = new ArrayList<Object>(allObjects.size());
			this.idToObject = new HashMap<String, Object>(allObjects.size());
			for (Object o : allObjects) {
				((IdentifiableElement) o).setTrgId(metamodelName);
				allInstances.add(o);
				
				idToObject.put(((IdentifiableElement) o).getId(), o);
			}
			
		}

		@Override
		public List<? extends Object> allInstances() {
			return this.allInstances;
		}

		@Override
		public boolean belongsTo(Object obj) {
			return allInstances.contains(obj);
		}

		public Object read(String id) {
			return idToObject.get(id);
		}

		/**
		 * I used <T> to skip compiler checks "thanks" to erasure
		 */
		public <T> List<T> readAll(Collection<String> list) {
			ArrayList result = new ArrayList<>(list.size());
			for (String string : list) {
				Object o = read(string);
				if ( o != null )
					result.add(o);
			}
			return result;
		}

		@Override
		public Object forBinding(Object o, String resolvingRule) {
			if (resolvingRule == null) {
				return ((IdentifiableElement) o).getId();
			}
			return TraceFunction.resolve(((IdentifiableElement) o).getId(), 0, resolvingRule);
		}

//		@Override
//		public String getId(Object m) {
//			int indexOf = allInstances.indexOf(m);
//			if ( indexOf == - 1)
//				return null;
//			return indexOf + "";
//		}
	
	}

	@Override
	public InputExtent toInputExtent() {
		InputExtent extent = new InputExtent();
		extent.addAll(reader.getAllObjects());
		return extent;	
	}

	@Override
	public InputExtent toInputExtentPartitioned(int numThreads) {
		throw new UnsupportedOperationException();
		
	}
	
//	
//
//	protected String modelPath;
//	protected IArea srcModelArea;
//	private ClassLoader classLoader;
//	double numElemsLoaded = 0;
//	double firstId;
//	
//	public ModelLoader_Single(String modelPath, IArea modelArea, double firstId) {
//		this(modelPath, modelArea, firstId, ModelLoader_Single.class.getClassLoader());
//	}
//
//	public ModelLoader_Single(String modelPath, IArea modelArea, double firstId, ClassLoader classLoader) {
//		this.modelPath = modelPath;
//		this.srcModelArea = modelArea;
//		this.classLoader = classLoader;
//		this.numElemsLoaded = 0;
//		this.firstId = firstId;
//	}
//	
//	public void run() {
//		// ClassModelGeneration cmg = new ClassModelGeneration(area);
//		// cmg.loadModel(model, area);
//
//		double id = firstId;
//		try {
//			
//			FileInputStream fis = new FileInputStream(modelPath);
//			// ObjectInputStream ois = new ObjectInputStream(fis);
//			ObjectInputStream ois = new ObjectInputStream(fis) {
//				@Override
//				protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
//					String name = desc.getName();
//			        try {
//			            return Class.forName(name, false, classLoader);
//			        } catch (ClassNotFoundException ex) {
//			           return super.resolveClass(desc);
//			        }
//				}
//			};
//			
//			Object o = ois.readObject();
//			
//			try {
//
//				while (o != null) {
//					
//					((IdentifiableElement)o).setId(Double.toString(id));
//					srcModelArea.write((IdentifiableElement)o);
//					numElemsLoaded++;
//					id ++;
//					o = ois.readObject();
//				}
//				ois.close();
//				fis.close();
//				
//			} catch (EOFException e) {
//				// when this exception is thrown means that there are no more
//				// objects in the file.
//				ois.close();
//				fis.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public double getNumElemsLoaded() {
//		return numElemsLoaded;
//	}
//
//	public void setNumElemsLoaded(double numElemsLoaded) {
//		this.numElemsLoaded = numElemsLoaded;
//	}
//
	

}

