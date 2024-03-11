package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import babs.mindforge.util.ArrayInto;

/**
 * ShortArray class is a wrapper for a primitive short array. This class provides
 * convenience methods for performing array operations and manipulations. ShortArray
 * implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.1
 * @see PrimitiveArray
 * @since 21
 */
public class ShortArray implements PrimitiveArray {
	
	/**
	 * The short array backing the ShortArray.
	 */
	private short[] arr;
	
	/**
	 * Constructor that creates a ShortArray with the specified size will all elements 
	 * set to 0.
	 * @param size The size of this ShortArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since 21
	 */
	public ShortArray(int size) {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create a ShortArray with a negative size.");
		
		arr = new short[size];
	}
	
	/**
	 * Constructor that creates a ShortArray from the specified short array.
	 * @param array The short array to use.
	 * @throws NullPointerException Thrown if array is null.
	 * @since 21
	 */
	public ShortArray(short[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a ShortArray from a null short array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		ShortArray ret = new ShortArray(arr.length);
		
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
			if (o.equals(Short.valueOf(arr[i])))
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
		
		if (o instanceof ShortArray) {
			if (((ShortArray)o).size() != this.size())
				return false;
			
			for (int i = 0; i < arr.length; ++i) {
				if (!(((ShortArray)o).arr[i] == arr[i]))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public Short get(int index) 
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
		if (o == null || !(o instanceof Short))
			return -1;
		
		for (int i = 0; i < arr.length; ++i) {
			if (((Short)o).shortValue() == arr[i])
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
		if (o == null || !(o instanceof Short))
			return -1;
		
		for (int i = arr.length - 1; i >= 0; --i) {
			if (((Short) o).shortValue() == arr[i])
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
			throw new NullPointerException("Cannot set ShortArray value to a null value.");
		
		if (!(o instanceof Short))
			throw new IllegalArgumentException("Cannot set ShortArray value to a non-Short object.");
		
		synchronized(this) {
			arr[index] = ((Short)o);
		}
	}
	
	@Override
	public int size() {
		return arr.length;
	}
	
	@Override
	public ShortArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		ShortArray ret = new ShortArray(end - start);
		
		for (int i = start; i < end; ++i)
			ret.set(i - start, arr[i]);
		
		return ret;
	}

	/**
	 * Returns a copy of the short array backing this ShortArray.
	 * @return A copy of the short array.
	 * @since 21
	 */
	public short[] toArray() {
		short[] copy = new short[arr.length];
		
		synchronized(this) {
			for (int i = 0; i < arr.length; ++i)
				copy[i] = arr[i];
		}
		
		return copy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		Short[] copy = new Short[arr.length];
		
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
