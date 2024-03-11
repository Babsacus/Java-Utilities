package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import babs.mindforge.util.ArrayInto;

/**
 * FloatArray class is a wrapper for a primitive float array. This class provides
 * convenience methods for performing array operations and manipulations. FloatArray
 * implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.1
 * @see PrimitiveArray
 * @since 21
 */
public class FloatArray implements PrimitiveArray {
	
	/**
	 * The float array backing the FloatArray.
	 */
	private float[] arr;
	
	/**
	 * Constructor that creates a FloatArray with the specified size will all elements 
	 * set to 0.
	 * @param size The size of this FloatArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since 21
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
	 * @since 21
	 */
	public FloatArray(float[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a FloatArray from a null float array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		FloatArray ret = new FloatArray(arr.length);
		
		synchronized(this) {
			for (int i = 0; i < arr.length; ++i)
				ret.arr[i] = arr[i];
		}
		
		return ret;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null)
			return false;
		
		for (int i = 0; i < arr.length; ++i) {
			if (o.equals(Float.valueOf(arr[i])))
				return true;
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
			
			for (int i = 0; i < arr.length; ++i) {
				if (!(((FloatArray)o).arr[i] == arr[i]))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public Float get(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= arr.length)
			throw new ArrayIndexOutOfBoundsException("Cannot get value due to index out-of-bounds.");
		
		return arr[index];
	}
	
	@Override
	public int hashCode() {
		return arr.hashCode();
	}
	
	@Override
	public int indexOf(Object o) {
		if (o == null || !(o instanceof Float))
			return -1;
		
		for (int i = 0; i < arr.length; ++i) {
			if (((Float)o).floatValue() == arr[i])
				return i;
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
		
		for (int i = arr.length - 1; i >= 0; --i) {
			if (((Float) o).floatValue() == arr[i])
				return i;
		}
		
		return -1;
	}
	
	@Override
	public void set(int index, Object o) 
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
		if (index < 0 || index >= arr.length)
			throw new ArrayIndexOutOfBoundsException("Cannot set value due to index out-of-bounds.");
		
		if (o == null)
			throw new NullPointerException("Cannot set FloatArray value to a null value.");
		
		if (!(o instanceof Float))
			throw new IllegalArgumentException("Cannot set FloatArray value to a non-Float object.");
		
		synchronized(this) {
			arr[index] = ((Float)o);
		}
	}
	
	@Override
	public int size() {
		return arr.length;
	}
	
	@Override
	public FloatArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		FloatArray ret = new FloatArray(end - start);
		
		for (int i = start; i < end; ++i)
			ret.set(i - start, arr[i]);
		
		return ret;
	}

	/**
	 * Returns a copy of the float array backing this FloatArray.
	 * @return A copy of the float array.
	 * @since 21
	 */
	public float[] toArray() {
		float[] copy = new float[arr.length];
		
		synchronized(this) {
			for (int i = 0; i < arr.length; ++i)
				copy[i] = arr[i];
		}
		
		return copy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		Float[] copy = new Float[arr.length];
		
		synchronized(this) {
			for (int i = 0; i < arr.length; ++i)
				copy[i] = arr[i];
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
		
		for (int i = 0; i < arr.length; ++i) {
			if (i < arr.length - 1)
				ret += arr[i] + " ";
			else
				ret += arr[i];
		}
		
		return ret;
	}

}
