package lintra.utils;

public class ReflectiveObject {

	private Object obj;

	public ReflectiveObject(Object obj) {
		this.obj = obj;
	}
	
	public String getName() {
		return obj.getClass().getSimpleName();
	}
	
}
