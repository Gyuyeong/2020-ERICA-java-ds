package positional_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E>{
	
	private class ArrayIterator implements Iterator<E> {
		private int j = 0;
		private boolean removable = false;
		
		public boolean hasNext() {
			return j < size;
		}
		
		public E next() throws NoSuchElementException {
			if (j == size) {
				throw new NoSuchElementException("No next element");
			}
			removable = true;
			return data[j++];
		}
		
		public void remove() throws IllegalStateException {
			if (!removable) {
				throw new IllegalStateException("nothing to remove");
			}
			ArrayList.this.remove(j - 1);
			j--;
			removable = false;
		}
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
	public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;
	
	public ArrayList() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		// TODO Auto-generated method stub
		checkIndex(i, size + 1);
		if (size == data.length) {
			throw new IllegalStateException("Array is full");
		}
		
		for (int k = size - 1; k >= i; k--) {
			data[k + 1] = data[k];
		}
		data[i] = e;
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++) {
			data[k] = data[k + 1];
		}
		data[size - 1] = null;
		size--;
		return temp;
	}
	
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	
}
