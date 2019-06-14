package a2l.runtime;

import java.util.Collection;

public interface IModel {

	Collection<? extends Object> allInstances();

	boolean belongsTo(Object obj);

	public static interface IOutputModel extends IModel {
		
		void addPartial(PartialOutputModel oUTModel_PartialOutput_);

		void add(Object obj);
		
		public void write();
	}

	Object forBinding(Object o, String resolvingRule);
}
