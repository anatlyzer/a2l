package lintra2.blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.HashMapArea;
import lintra2.blackboard.IArea;
import lintra2.blackboard.ISearch;
import lintra2.blackboard.IBlackboard.Policy;

public class HashMapArea<ElementType> implements IArea<ElementType> {

	/**
	 * Comments to myself: - After we exit a synchronized block, we release the
	 * monitor, which has the effect of flushing the cache to main memory, so
	 * that writes made by this thread can be visible to other threads. ----->
	 * So synchronization is needed in setter, writes/takes and methods that
	 * modify some variables. - Do I need to synchronize getters and reads too?
	 * - Volatile variables share the visibility features of synchronized, but
	 * none of the atomicity features. This means that threads will
	 * automatically see the most up-to-date value for volatile variables. - You
	 * might prefer to use volatile variables instead of locks for one of two
	 * principal reasons: simplicity or scalability. Some idioms are easier to
	 * code and read when they use volatile variables instead of locks. In
	 * addition, volatile variables (unlike locks) cannot cause a thread to
	 * block, so they are less likely to cause scalability problems. -----> So
	 * as long as the variables are volatile, I don't need to synchronize
	 * getters, reads or any other method that doesn't modify the variable.
	 */

	private static final long serialVersionUID = 1L;
	private volatile String name;
	private volatile Policy policy;
	private volatile Semaphore semaphore;
	private volatile Map<String, ElementType> area;
	private volatile boolean sessionStarted; // a session is a time frame
												// between a point in which the
												// area is locked() (i.e. the
												// semaphore is acquired) until
												// it is unlocked() (i.e. the
												// semaphore is released)
	private IdMapper<ElementType> idMapper;
	
	public HashMapArea(String name, Policy p, IdMapper<ElementType> mapper) {
		this.idMapper = mapper;
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);
		area = new ConcurrentHashMap<String, ElementType>();
		sessionStarted = false;
	}

	@Override
	public IdMapper<ElementType> getIdMapper() {
		return idMapper;
	}
	
	public String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public Policy getPolicy() {
		return policy;
	}

	public synchronized void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public synchronized void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void lock() throws BlackboardException {
		try {
			semaphore.acquire();
			sessionStarted = true;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	public void unlock() throws BlackboardException {
		semaphore.release();
		sessionStarted = false;
	}

	public Map<String, ElementType> getArea() {
		return area;
	}

	public synchronized void setArea(Map<String, ElementType> area) {
		this.area = area;
	}

	@Override
	public ElementType read(String id) throws BlackboardException {
		try {
			ElementType e;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				e = area.get(id);
				semaphore.release();
			} else {
				e = area.get(id);
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<ElementType> readAll(Collection<String> ids) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ))  && !sessionStarted) {
				semaphore.acquire();
				elems = readAllAux(ids);
				semaphore.release();
			} else {
				elems = readAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<ElementType> readAllAux(Collection<String> ids) {
		Collection<ElementType> out = new LinkedList<ElementType>();
		// String idsS = "";
		for (String id : ids) {
			if (area.get(id) != null) {
				// idsS += id + ", ";
				// System.out.println(id);
				out.add(area.get(id));
			}
		}
		// System.out.println(idsS);
		return out;
	}

	@Override
	public Collection<ElementType> read(ISearch searchMethod) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				elems = searchMethod.search(this);
				semaphore.release();
			} else {
				elems = searchMethod.search(this);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<ElementType> read(int n) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				elems = readAux(n);
				semaphore.release();
			} else {
				elems = readAux(n);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<ElementType> readAux(int n) {
		if (area.keySet().size() < n) {
			return area.values();
		} else {
			String[] keys = toArray(area.keySet()); // I've decided to load the
													// keys instead of the
													// values directly because a
													// set of String is not as
													// heavy as a set of
													// IdentifiableElements
			Collection<ElementType> elems = new LinkedList<ElementType>();
			for (int i = 0; i < n; i++) {
				elems.add(area.get(keys[i]));
			}
			return elems;
		}
	}

	@Override
	public ElementType take(String id) throws BlackboardException {
		try {
			ElementType e;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				e = area.remove(id);
				semaphore.release();
			} else {
				e = area.remove(id);
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<ElementType> takeAll(Collection<String> ids) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				elems = takeAllAux(ids);
				semaphore.release();
			} else {
				elems = takeAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<ElementType> takeAllAux(Collection<String> ids) {
		Collection<ElementType> out = new LinkedList<ElementType>();
		for (String id : ids) {
			ElementType e = area.remove(id);
			if (e != null) {
				out.add(e);
			}
		}
		return out;
	}

	@Override
	public Collection<ElementType> take(ISearch searchMethod) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				elems = searchMethod.search(this);
				removeElements(elems);
				semaphore.release();
			} else {
				elems = searchMethod.search(this);
				removeElements(elems);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<ElementType> take(int n) throws BlackboardException {
		try {
			Collection<ElementType> elems;
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)) && !sessionStarted) {
				semaphore.acquire();
				elems = takeAux(n);
				semaphore.release();
			} else {
				elems = takeAux(n);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<ElementType> takeAux(int n) {
		Collection<ElementType> elems = new LinkedList<ElementType>();
		if (area.keySet().size() < n) {
			elems = new LinkedList<ElementType>(area.values());
			area.clear();
		} else {
			String[] keys = toArray(area.keySet()); // I've decided to load the
													// keys instead of the
													// values directly because a
													// set of String is not as
													// heavy as a set of
													// IdentifiableElements
			for (int i = 0; i < n; i++) {
				elems.add(area.remove(keys[i]));
			}
		}
		return elems;
	}

	private String[] toArray(Set<String> keySet) {
		String[] array = new String[keySet.size()];
		int i = 0;
		for (String s : keySet) {
			array[i] = s;
			i++;
		}
		return array;
	}

	private synchronized void removeElements(Collection<ElementType> elems) {
		for (ElementType e : elems) {
			area.remove(idMapper.getId(e));
		}
	}

	@Override
	public synchronized boolean write(ElementType elem) throws BlackboardException {
		try {
			if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)) && !sessionStarted) {
				semaphore.acquire();
				// area.put(elem.getId(), elem.clone());
				area.put(idMapper.getId(elem), elem);
				semaphore.release();
			} else {
				// area.put(elem.getId(), elem.clone());
				area.put(idMapper.getId(elem), elem);
			}
			return true;
		} catch (InterruptedException e) { // | CloneNotSupportedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public synchronized boolean writeAll(Collection<ElementType> elems) throws BlackboardException {
		try {
			if (elems != null) {
				if ((policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)) && !sessionStarted) {
					semaphore.acquire();
					writeAllAux(elems);
					semaphore.release();
				} else {
					writeAllAux(elems);
				}
			}
			return true;
		} catch (InterruptedException | CloneNotSupportedException e) {
			throw new BlackboardException();
		}
	}

	private synchronized void writeAllAux(Collection<ElementType> elems) throws CloneNotSupportedException {

		for (ElementType e : elems) {
			try {
				if (area.containsKey(idMapper.getId(e))) {
					// System.out.println("--->"+area.get(e.getId()) + " is
					// being overwritten by " + e);
				}
				// area.put(e.getId(), (IdentifiableElement) e.clone());
				area.put(idMapper.getId(e), e);
			} catch (NullPointerException ex) {
				System.out.println("what's going on here? " + e.toString());
			}
		}
	}

	@Override
	public int size() {
		return area.size();
	}

	@Override
	public synchronized boolean clear() {
		area.clear();
		return area.keySet().size() == 0;
	}

	@Override
	public void destroy() {
		area.clear();
		area = null;
	}

	@Override
	public synchronized void print() {
		System.out.println("*Area: " + name + "*");
		for (String id : area.keySet()) {
			System.out.println(area.get(id));
		}
	}

	@Override
	public synchronized boolean equals(Object o) {
		return o instanceof HashMapArea && ((HashMapArea) o).getName().equals(name);
	}

	@Override
	public synchronized String toString() {
		return "HashMapArea [name=" + name + ", policy=" + policy + ", semaphore=" + semaphore + ", area=" + area + "]";
	}

	@Override
	public double getFirstId() {
		return idMapper.getFirstId();
	}


	@Override
	public double getLastId() {
		return idMapper.getLastId();
	}


}
