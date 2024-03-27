package babs.mindforge.util.block;

import java.util.Collection;
import java.util.Iterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import babs.mindforge.util.ArrayInto;

/**
 * SortedArray class is an array that is automatically sorted when elements are added. All other methods perform 
 * their standard operations since it will not affect the order of the elements. SortedArrays are not resizable. 
 * SortedArray implements Block and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The Comparable element type.
 * @see Block
 * @see Comparable
 * @since JDK-21
 */
public class SortedArray<E extends Comparable<E>> implements Block<E> {
	
	/**
	 * Ascending sorting order value.
	 */
	public static final boolean ASCENDING = true;
	/**
	 * Descending sorting order value.
	 */
	public static final boolean DESCENDING = false;
	
	/**
	 * A read/write lock used to ensure thread-safety.
	 */
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 * The read lock from the read/write lock.
	 */
	private final Lock readLock = lock.readLock();
	/**
	 * The write lock from the read/write lock.
	 */
	private final Lock writeLock = lock.writeLock();
	
	/**
	 * The array backing the Array class.
	 */
	protected Object[] arr;
	/**
	 * Flag specifying the sorting order where true = ascending and false = descending.
	 */
	private boolean order;

	/**
	 * Constructor that creates a SortedArray with the specified size will all elements set to null. The sorting 
	 * order is defaulted to ascending.
	 * @param size The size of this Array.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public SortedArray(int size) 
			throws NegativeArraySizeException {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create an Array with a negative size.");
		
		arr = new Object[size];
		
		for (int i = 0; i < size; ++i)
			arr[i] = null;
		
		order = true;
	}
	
	/**
	 * Constructor that creates an Array with the same elements as the specified array and automatically sorts them.
	 * @param arr The array to store into this.
	 * @since JDK-21
	 */
	public SortedArray(E[] arr) {
		this.arr = new Object[arr.length];
		this.addAll(ArrayInto.collection(arr));
	}
	
	/**
	 * Constructor that creates a SortedArray with the specified size will all elements set to null. The sorting 
	 * order is set to the specified sorting order.
	 * @param size The size of this Array.
	 * @param order The sorting order.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public SortedArray(int size, boolean order) 
			throws NegativeArraySizeException {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create an Array with a negative size.");
		
		arr = new Object[size];
		
		for (int i = 0; i < size; ++i)
			arr[i] = null;
		
		this.order = order;
	}
	
	/**
	 * Replaces the a null element with the specified element and then sorts this SortedArray. If no null elements 
	 * exist, this returns false. Adding a null element throws an exception.
	 * @param e The element to add.
	 * @return True if e is added, otherwise false.
	 * @throws NullPointerException Thrown if e is null.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E e) 
			throws NullPointerException {
		if (e == null)
			throw new NullPointerException("Cannot add a null element to the Array.");
		
		writeLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] == null) {
					arr[i] = e;
					return true;
				}
				else if ((order == ASCENDING && e.compareTo((E)arr[i]) < 0) ||
						(order == DESCENDING && e.compareTo((E)arr[i]) > 0)) {
					for (int j = arr.length - 1; j > i; --j)
						arr[j] = arr[j - 1];
					
					arr[i] = e;
					
					return true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return false;
	}
	
	/**
	 * Replaces null elements with the elements in the specified Collection. Any null elements in the specified 
	 * Collection will cause an exception to be thrown. Added elements are automatically sorted.
	 * @param c The Collection to add.
	 * @return True if elements were added, otherwise false.
	 * @throw NullPointerException Thrown if any element in c is null.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> c) 
			throws NullPointerException {
		Iterator<? extends E> it = c.iterator();
		boolean ret = true;
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				E e = it.next();
				boolean r = false;
				
				for (int i = 0; i < arr.length && r == false; ++i) {
					if (arr[i] == null) {
						arr[i] = e;
						r = true;
					}
					else if ((order == ASCENDING && e.compareTo((E)arr[i]) < 0) ||
							(order == DESCENDING && e.compareTo((E)arr[i]) > 0)) {
						for (int j = arr.length - 1; j > i; --j)
							arr[j] = arr[j - 1];
						
						arr[i] = e;
						
						r = true;
					}
				}
				
				ret &= r;
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
	/**
	 * Replaces all elements with null values. The size of the Array does not change.
	 * @since JDK-21
	 */
	@Override
	public void clear() {
		writeLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i)
				arr[i] = null;
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public Object clone() {
		SortedArray<E> ret = new SortedArray<E>(arr.length);
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i)
				ret.arr[i] = arr[i];
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}
	
	@Override
	public boolean contains(Object o) {
		if (o == null)
			return false;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] != null && arr[i].equals(o))
					return true;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		boolean ret = true;
		
		while (it.hasNext()) {
			ret &= this.contains(it.next());
		}
		
		return ret;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o instanceof Array<?>) {
			if (((Array<?>)o).size() != this.size())
				return false;
			
			readLock.lock();
			
			try {
				for (int i = 0; i < arr.length; ++i) {
					if (!((Array<?>)o).arr[i].equals(arr[i]))
						return false;
				}
			}
			finally {
				readLock.unlock();
			}
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= this.sizeUsed() || index >= this.size())
			throw new ArrayIndexOutOfBoundsException("Cannot set Array value due to out-of-bounds index.");
		
		readLock.lock();
		
		try {
			return (E)arr[index];
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public int hashCode() {
		readLock.lock();
		
		try {
			return arr.hashCode();
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public int indexOf(E e) {
		if (e == null)
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i].equals(e))
					return i;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return -1;
	}

	/**
	 * Returns true if all elements in this Array are null.
	 * @return True if all elements are null, otherwise false.
	 * @since JDK-21
	 */
	@Override
	public boolean isEmpty() {
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] != null)
					return false;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new SortedArrayIterator<E>(this);
	}
	
	/**
	 * Creates a new SortedArray by joining the two specified arrays and automatically sorts the joined array.
	 * @param <E> The Comparable element type.
	 * @param arr1 The first array.
	 * @param arr2 The second array.
	 * @return A SortedArray containing arr1 and arr2 sorted.
	 */
	public static <E extends Comparable<E>> SortedArray<E> join(E[] arr1, E[] arr2) {
		SortedArray<E> ret = new SortedArray<E>(arr1.length + arr2.length);
		ret.addAll(ArrayInto.collection(arr1));
		ret.addAll(ArrayInto.collection(arr2));
		return ret;
	}
	
	@Override
	public int lastIndexOf(E e) {
		if (e == null)
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (arr[i].equals(e))
					return i;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return -1;
	}
	
	/**
	 * Returns the sorting order of this SortedArray.
	 * @return The sorting order.
	 * @since JDK-21
	 */
	public boolean order() {
		readLock.lock();
		
		try {
			return order;
		}
		finally {
			readLock.unlock();
		}
	}
	
	/**
	 * Removes the element at the specified index by shifting all the following elements, overwriting the element to 
	 * remove, and setting the last element to null.
	 * @param index The index of the element to remove.
	 * @return The removed element.
	 * @throws ArrayIndexOutOfBoundsException Thrown if index is out-of-bounds.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= this.sizeUsed())
			throw new ArrayIndexOutOfBoundsException("Cannot remove element at index due to out-of-bounds index.");
		
		writeLock.lock();
		
		try {
			E ret = (E)arr[index];
			arr[index] = null;
			
			for (int j = index; j < arr.length - 1; ++j)
				arr[j] = arr[j + 1];
			
			arr[arr.length - 1] = null;
			
			return ret;
		}
		finally {
			writeLock.unlock();
		}
	}
	
	/**
	 * Removes the first occurrence of the specified Object by shifting all the following elements, overwriting the 
	 * element to remove, and setting the last element to null.
	 * @param o The Object to remove.
	 * @return True if o was removed, otherwise false.
	 * @since JDK-21
	 */
	@Override
	public boolean remove(Object o) {
		writeLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] != null && arr[i].equals(o)) {
					arr[i] = null;
					
					for (int j = i; j < arr.length - 1; ++j)
						arr[j] = arr[j + 1];
					
					arr[arr.length - 1] = null;
					
					return true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return false;
	}

	/**
	 * Removes any elements that are contained within the specified Collection by setting those elements to null.
	 * @param c The Collection to remove.
	 * @return True if elements were removed, otherwise false.
	 * @since JDK-21
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		boolean ret = true;
		
		while (it.hasNext()) {
			ret |= this.remove(it.next());
		}
		
		return ret;
	}
	
	@Override
	public boolean removeAny(Object o) {
		boolean ret = false;
		
		writeLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] != null && arr[i].equals(o)) {
					arr[i] = null;
					
					for (int j = i; j < arr.length - 1; ++j)
						arr[j] = arr[j + 1];
					
					arr[arr.length - 1] = null;
					
					ret = true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
	/**
	 * Removes the last occurrence of the specified Object by shifting all the following elements, overwriting the 
	 * element to remove, and setting the last element to null.
	 * @param o The Object to remove.
	 * @return True if o was removed, otherwise false.
	 * @since JDK-21
	 */
	@Override
	public boolean removeLast(Object o) {
		writeLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (arr[i] != null && arr[i].equals(o)) {
					arr[i] = null;
					
					for (int j = i; j < arr.length - 1; ++j)
						arr[j] = arr[j + 1];
					
					arr[arr.length - 1] = null;
					
					return true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean ret = false;
		
		writeLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (!c.contains(arr[i])) {
					arr[i] = null;
					ret = true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
	/**
	 * Reverses the order of this SortedArray.
	 * @return A SortedArray containing this SortedArray in reverse order.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	public SortedArray<E> reverse() {
		readLock.lock();
		
		try {
			SortedArray<E> ret = new SortedArray<E>(this.sizeUsed(), !order);
			
			for (int i = 0; i < this.sizeUsed(); ++i)
				ret.add((E)arr[i]);
			
			return ret;
		}
		finally {
			readLock.unlock();
		}
	}
	
	/**
	 * Returns the size of this Array which is the maximum number of elements this Array can hold.
	 * @returns The maximum number of elements this Array can hold.
	 * @since JDK-21
	 */
	@Override
	public int size() {
		readLock.lock();
		
		try {
			return arr.length;
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public int sizeUnused() {
		int ret = 0;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] == null)
					ret++;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}
	
	@Override
	public int sizeUsed() {
		int ret = 0;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] != null)
					ret++;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}
	
	/**
	 * Creates a sub-array from this SortedArray containing elements from [start, end). Since this SortedArray is 
	 * already sorted, the returned SortedArray will automatically be sorted as well.
	 * @param start The index to start at (included).
	 * @param end The index to stop at (excluded).
	 * @return A SortedArray containing elements of this from [start, end).
	 * @throws IllegalArgumentException Thrown if start is negative or if end is greater than {@link #sizeUsed()} or 
	 * if start is greater than or equal to end.
	 * @since JDK-21
	 */
	@Override
	public SortedArray<E> subBlock(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.sizeUsed() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		SortedArray<E> ret = new SortedArray<E>(end - start);
		
		for (int i = start; i < end; ++i)
			ret.add(this.get(i));
		
		return ret;
	}

	@Override
	public Object[] toArray() {
		Object[] copy = new Object[this.sizeUsed()];
		
		readLock.lock();
		
		try {
			for (int i = 0; i < copy.length; ++i)
				copy[i] = arr[i];
		}
		finally {
			readLock.unlock();
		}
		
		return copy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		Object[] copy = new Object[this.sizeUsed()];
		
		readLock.lock();
		
		try {
			for (int i = 0; i < copy.length; ++i)
				copy[i] = arr[i];
		}
		finally {
			readLock.unlock();
		}
		
		if (a.length >= copy.length) {
			for (int i = 0; i < copy.length; ++i)
				a[i] = (T)copy[i];
			
			return a;
		}
		
		T[] ret = (T[])copy;
		
		return ret;
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (i < arr.length - 1)
					ret += (arr[i] == null) ? "null, " : arr[i].toString() + ", ";
				else
					ret += (arr[i] == null) ? "null" : arr[i].toString();
			}
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}

}
