package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import babs.mindforge.util.ArrayInto;

/**
 * IntegerArray class is a wrapper for a primitive int array. This class provides convenience methods for performing 
 * array operations and manipulations. IntegerArray implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @see PrimitiveArray
 * @since JDK-21
 */
public class IntegerArray implements PrimitiveArray {
	
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
	 * The int array backing the IntegerArray.
	 */
	private int[] arr;
	
	/**
	 * Constructor that creates a IntegerArray with the specified size will all elements set to 0.
	 * @param size The size of this IntegerArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public IntegerArray(int size) {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create a IntegerArray with a negative size.");
		
		arr = new int[size];
	}
	
	/**
	 * Constructor that creates a IntegerArray from the specified int array.
	 * @param array The int array to use.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public IntegerArray(int[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a IntegerArray from a null int array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		IntegerArray ret = new IntegerArray(arr.length);
		
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
				if (o.equals(Integer.valueOf(arr[i])))
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
		if (c == null)
			return false;
		
		Iterator<?> it = c.iterator();
		
		while (it.hasNext()) {
			if (!contains(it.next()))
				return false;
		}
		
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o instanceof IntegerArray) {
			if (((IntegerArray)o).size() != this.size())
				return false;
			
			readLock.lock();
			
			try {
				for (int i = 0; i < arr.length; ++i) {
					if (!(((IntegerArray)o).arr[i] == arr[i]))
						return false;
				}
			}
			finally {
				readLock.lock();
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Converts a byte array into a IntegerArray.
	 * @param array The byte array to convert.
	 * @return A IntegerArray containing the byte array.
	 * @throws IllegalArgumentException Thrown if array's length is not evenly divisible by {@link Integer#BYTES}.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static IntegerArray from(byte[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null byte array into a IntegerArray.");
		if (array.length % Integer.BYTES != 0)
			throw new IllegalArgumentException("Byte array size is incompatible with int size.");
		IntegerArray ret = new IntegerArray(array.length / Integer.BYTES);
		for (int i = 0; i < array.length / Integer.BYTES; ++i) {
			int v = 0;
			for (int j = 0; j < Integer.BYTES; ++j)
				v |= (array[j + (i * Integer.BYTES)] << (Byte.SIZE * (Integer.BYTES - 1 - j)));
			ret.set(i, v);
		}
		return ret;
	}
	
	@Override
	public Integer get(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= this.size())
			throw new ArrayIndexOutOfBoundsException("Cannot get value due to index out-of-bounds.");
		
		readLock.lock();
		
		try {
			return arr[index];
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
	public int indexOf(Object o) {
		if (o == null || !(o instanceof Integer))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (((Integer)o).intValue() == arr[i])
					return i;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return -1;
	}

	@Override
	public Iterator<?> iterator() {
		return ArrayInto.collection(arr).iterator();
	}
	
	@Override
	public int lastIndexOf(Object o) {
		if (o == null || !(o instanceof Integer))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (((Integer) o).intValue() == arr[i])
					return i;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return -1;
	}
	
	@Override
	public void set(int index, Object o) 
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
		if (index < 0 || index >= this.size())
			throw new ArrayIndexOutOfBoundsException("Cannot set value due to index out-of-bounds.");
		
		if (o == null)
			throw new NullPointerException("Cannot set IntegerArray value to a null value.");
		
		if (!(o instanceof Integer))
			throw new IllegalArgumentException("Cannot set IntegerArray value to a non-Integer object.");
		
		writeLock.lock();
		
		try {
			arr[index] = ((Integer)o);
		}
		finally {
			writeLock.unlock();
		}
	}
	
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
	public IntegerArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		IntegerArray ret = new IntegerArray(end - start);
		
		readLock.lock();
		
		try {
			for (int i = start; i < end; ++i)
				ret.set(i - start, arr[i]);
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}

	/**
	 * Returns a copy of the int array backing this IntegerArray.
	 * @return A copy of the int array.
	 * @since JDK-21
	 */
	public int[] toArray() {
		int[] copy = new int[arr.length];
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i)
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
		Integer[] copy = new Integer[arr.length];
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i)
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
					ret += arr[i] + " ";
				else
					ret += arr[i];
			}
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}

}
