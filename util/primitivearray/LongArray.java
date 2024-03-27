package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import babs.mindforge.util.ArrayInto;

/**
 * LongArray class is a wrapper for a primitive long array. This class provides convenience methods for performing 
 * array operations and manipulations. LongArray implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @see PrimitiveArray
 * @since JDK-21
 */
public class LongArray implements PrimitiveArray {
	
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
	 * The long array backing the LongArray.
	 */
	private long[] arr;
	
	/**
	 * Constructor that creates a LongArray with the specified size will all elements set to 0.
	 * @param size The size of this LongArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public LongArray(int size) {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create a LongArray with a negative size.");
		
		arr = new long[size];
	}
	
	/**
	 * Constructor that creates a LongArray from the specified long array.
	 * @param array The long array to use.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public LongArray(long[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a LongArray from a null long array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		LongArray ret = new LongArray(arr.length);
		
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
				if (o.equals(Long.valueOf(arr[i])))
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
		
		if (o instanceof LongArray) {
			if (((LongArray)o).size() != this.size())
				return false;
			
			readLock.lock();
			
			try {
				for (int i = 0; i < arr.length; ++i) {
					if (!(((LongArray)o).arr[i] == arr[i]))
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
	 * Converts a byte array into a LongArray.
	 * @param array The byte array to convert.
	 * @return A LongArray containing the byte array.
	 * @throws IllegalArgumentException Thrown if array's length is not evenly divisible by {@link Long#BYTES}.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static LongArray from(byte[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null byte array into a LongArray.");
		if (array.length % Long.BYTES != 0)
			throw new IllegalArgumentException("Byte array size is incompatible with long size.");
		LongArray ret = new LongArray(array.length / Long.BYTES);
		for (int i = 0; i < array.length / Long.BYTES; ++i) {
			long v = 0;
			for (int j = 0; j < Long.BYTES; ++j)
				v |= (array[j + (i * Long.BYTES)] << (Byte.SIZE * (Long.BYTES - 1 - j)));
			ret.set(i, v);
		}
		return ret;
	}
	
	@Override
	public Long get(int index) 
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
		if (o == null || !(o instanceof Long))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (((Long)o).longValue() == arr[i])
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
		if (o == null || !(o instanceof Long))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (((Long) o).longValue() == arr[i])
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
			throw new NullPointerException("Cannot set LongArray value to a null value.");
		
		if (!(o instanceof Long))
			throw new IllegalArgumentException("Cannot set LongArray value to a non-Long object.");
		
		writeLock.lock();
		
		try {
			arr[index] = ((Long)o);
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
	public LongArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		LongArray ret = new LongArray(end - start);
		
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
	 * Returns a copy of the long array backing this LongArray.
	 * @return A copy of the long array.
	 * @since JDK-21
	 */
	public long[] toArray() {
		long[] copy = new long[arr.length];
		
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
		Long[] copy = new Long[arr.length];
		
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
