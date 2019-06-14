package a2l.runtime;

import java.util.List;

// TODO: Create proper interfaces and so on
public class InputExtendPartitioned extends InputExtent {

	private List<List<Object>> jobs;

	public InputExtendPartitioned(List<List<Object>> jobs) {
		this.jobs = jobs;
	}

	public List<? extends Object> getJob(int i) {
		return jobs.get(i);
	}

	
	@Override
	public void add(Object o) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addAll(Iterable<? extends Object> objects) {
		throw new UnsupportedOperationException();
	}
	
	public long size() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Object get(long i) {
		throw new UnsupportedOperationException();
	}
	
	
}
