package a2l.runtime.stdlib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This is intended to enable EMF list iterations bypassing the standard EMF
 * Iterator implementations which are known to be inefficient.
 * 
 */
public class FastIterableList<E> implements java.util.List<E> {

	private List<E> impl;
	private int size;

	public FastIterableList(List<E> impl) {
		this.impl = impl;
		this.size = impl.size();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return impl.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return new FastIterator();
	}

	@Override
	public Object[] toArray() {
		return this.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.toArray(a);
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return impl.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) {
		return impl.get(index);
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		return impl.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return impl.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListFastIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return impl.subList(fromIndex, toIndex);
	}

	private class FastIterator implements Iterator<E> {

		int cursor; // index of next element to return

		FastIterator() {
		}

		public boolean hasNext() {
			return cursor != size;
		}

		public E next() {
			int i = cursor;
			if (i >= size)
				throw new NoSuchElementException();
			cursor = i + 1;
			return get(i);
		}

	}

	private class ListFastIterator extends FastIterator implements ListIterator<E> {
		private ListFastIterator(int index) {
			super();
			cursor = index;
		}

		public boolean hasPrevious() {
			return cursor != 0;
		}

		public int nextIndex() {
			return cursor;
		}

		public int previousIndex() {
			return cursor - 1;
		}

		@SuppressWarnings("unchecked")
		public E previous() {
			int i = cursor - 1;
			if (i < 0)
				throw new NoSuchElementException();
			cursor = i;
			return get(i);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
		}
	}

}
