package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import babs.mindforge.util.ArrayInto;

/**
 * FloatArray class is a wrapper for a primitive float array. This class provides convenience methods for performing 
 * array operations and manipulations. FloatArray implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @see PrimitiveArray
 * @since JDK-21
 */
public class FloatArray implements PrimitiveArray {
	
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
	 * The float array backing the FloatArray.
	 */
	private float[] arr;
	
	/**
	 * Constructor that creates a FloatArray with the specified size will all elements set to 0.
	 * @param size The size of this FloatArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public FloatArray(int size) {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create a FloatArray with a negative size.");
		
		arr = new float[size];
	}
	
	/**
	 * Constructor that creates a FloatArray from the specified float array.
	 * @param array The float array to use.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public FloatArray(float[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a FloatArray from a null float array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		FloatArray ret = new FloatArray(arr.length);
		
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
				if (o.equals(Float.valueOf(arr[i])))
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
		
		if (o instanceof FloatArray) {
			if (((FloatArray)o).size() != this.size())
				return false;
			
			readLock.lock();
			
			try {
				for (int i = 0; i < arr.length; ++i) {
					if (!(((FloatArray)o).arr[i] == arr[i]))
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
	 * Converts a byte array into a FloatArray.
	 * @param array The byte array to convert.
	 * @return A FloatArray containing the byte array.
	 * @throws IllegalArgumentException Thrown if array's length is not evenly divisible by {@link Float#BYTES}.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static FloatArray from(byte[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null byte array into a FloatArray.");
		if (array.length % Float.BYTES != 0)
			throw new IllegalArgumentException("Byte array size is incompatible with float size.");
		FloatArray ret = new FloatArray(array.length / Float.BYTES);
		for (int i = 0; i < array.length / Float.BYTES; ++i) {
			int v = 0;
			for (int j = 0; j < Float.BYTES; ++j)
				v |= (array[j + (i * Float.BYTES)] << (Byte.SIZE * (Float.BYTES - 1 - j)));
			ret.set(i, Float.intBitsToFloat(v));
		}
		return ret;
	}
	
	@Override
	public Float get(int index) 
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
		if (o == null || !(o instanceof Float))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (((Float)o).floatValue() == arr[i])
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
		if (o == null || !(o instanceof Float))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (((Float) o).floatValue() == arr[i])
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
			throw new NullPointerException("Cannot set FloatArray value to a null value.");
		
		if (!(o instanceof Float))
			throw new IllegalArgumentException("Cannot set FloatArray value to a non-Float object.");
		
		writeLock.lock();
		
		try {
			arr[index] = ((Float)o);
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
	public FloatArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		FloatArray ret = new FloatArray(end - start);
		
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
	 * Returns a copy of the float array backing this FloatArray.
	 * @return A copy of the float array.
	 * @since JDK-21
	 */
	public float[] toArray() {
		float[] copy = new float[arr.length];
		
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
		Float[] copy = new Float[arr.length];
		
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
