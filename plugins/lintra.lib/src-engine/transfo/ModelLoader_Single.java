package transfo;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.LinkedList;
import java.util.List;

import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;

public class ModelLoader_Single {

	protected String modelPath;
	protected IArea srcModelArea;
	private ClassLoader classLoader;
	double numElemsLoaded = 0;
	double firstId;
	
	public ModelLoader_Single(String modelPath, IArea modelArea, double firstId) {
		this(modelPath, modelArea, firstId, ModelLoader_Single.class.getClassLoader());
	}

	public ModelLoader_Single(String modelPath, IArea modelArea, double firstId, ClassLoader classLoader) {
		this.modelPath = modelPath;
		this.srcModelArea = modelArea;
		this.classLoader = classLoader;
		this.numElemsLoaded = 0;
		this.firstId = firstId;
	}
	
	public void run() {
		// ClassModelGeneration cmg = new ClassModelGeneration(area);
		// cmg.loadModel(model, area);

		double id = firstId;
		try {
			
			FileInputStream fis = new FileInputStream(modelPath);
			// ObjectInputStream ois = new ObjectInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(fis) {
				@Override
				protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
					String name = desc.getName();
			        try {
			            return Class.forName(name, false, classLoader);
			        } catch (ClassNotFoundException ex) {
			           return super.resolveClass(desc);
			        }
				}
			};
			
			Object o = ois.readObject();
			
			try {

				while (o != null) {
					
					((IdentifiableElement)o).setId(Double.toString(id));
					srcModelArea.write((IdentifiableElement)o);
					numElemsLoaded++;
					id ++;
					o = ois.readObject();
				}
				ois.close();
				fis.close();
				
			} catch (EOFException e) {
				// when this exception is thrown means that there are no more
				// objects in the file.
				ois.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getNumElemsLoaded() {
		return numElemsLoaded;
	}

	public void setNumElemsLoaded(double numElemsLoaded) {
		this.numElemsLoaded = numElemsLoaded;
	}
	
	
}
