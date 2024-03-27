package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import babs.mindforge.util.ArrayInto;

/**
 * ByteArray class is a wrapper for a primitive byte array. This class provides convenience methods for performing 
 * array operations and manipulations. ByteArray implements PrimitiveArray and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @see PrimitiveArray
 * @since JDK-21
 */
public class ByteArray implements PrimitiveArray {
	
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
	 * The byte array backing the ByteArray.
	 */
	private byte[] arr;
	
	/**
	 * Constructor that creates a ByteArray with the specified size will all elements set to 0.
	 * @param size The size of this ByteArray.
	 * @throws NegativeArraySizeException Thrown if size is negative.
	 * @since JDK-21
	 */
	public ByteArray(int size) {
		if (size < 0)
			throw new NegativeArraySizeException("Cannot create a ByteArray with a negative size.");
		
		arr = new byte[size];
	}
	
	/**
	 * Constructor that creates a ByteArray from the specified byte array.
	 * @param array The byte array to use.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public ByteArray(byte[] array) {
		if (array == null)
			throw new NullPointerException("Cannot create a ByteArray from a null byte array.");
		
		arr = array;
	}
	
	@Override
	public Object clone() {
		ByteArray ret = new ByteArray(arr.length);
		
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
				if (o.equals(Byte.valueOf(arr[i])))
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
		
		if (o instanceof ByteArray) {
			if (((ByteArray)o).size() != this.size())
				return false;
			
			readLock.lock();
			
			try {
				for (int i = 0; i < arr.length; ++i) {
					if (!(((ByteArray)o).arr[i] == arr[i]))
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
	 * Converts a boolean value into a ByteArray.
	 * @param value The boolean value to convert.
	 * @return A ByteArray containing the boolean value.
	 * @since JDK-21
	 */
	public static ByteArray from(boolean value) {
		ByteArray ret = new ByteArray(Byte.BYTES);
		ret.arr[0] = value ? (byte)1 : (byte)0;
		return ret;
	}
	
	/**
	 * Converts a boolean array into a ByteArray.
	 * @param array The boolean array to convert.
	 * @return A ByteArray containing the boolean array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(boolean[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null boolean array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length);
		for (int i = 0; i < array.length; ++i)
			ret.arr[i] = array[i] ? (byte)1 : (byte)0;
		return ret;
	}
	
	/**
	 * Converts a byte value into a ByteArray.
	 * @param value The byte value to convert.
	 * @return A ByteArray containing the byte value.
	 * @since JDK-21
	 */
	public static ByteArray from(byte value) {
		ByteArray ret = new ByteArray(Byte.BYTES);
		ret.arr[0] = value;
		return ret;
	}
	
	/**
	 * Converts a byte array into a ByteArray.
	 * @param array The byte array to convert.
	 * @return A ByteArray containing the byte array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(byte[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null byte array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length);
		for (int i = 0; i < array.length; ++i)
			ret.arr[i] = array[i];
		return ret;
	}
	
	/**
	 * Converts a char value into a ByteArray.
	 * @param value The char value to convert.
	 * @return A ByteArray containing the char value.
	 * @since JDK-21
	 */
	public static ByteArray from(char value) {
		ByteArray ret = new ByteArray(Character.BYTES);
		char mask = 0x00FF;
		for (int i = 0; i < Character.BYTES; ++i)
			ret.arr[i] = (byte)((value >> (Byte.SIZE * (Character.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts a char array into a ByteArray.
	 * @param array The char array to convert.
	 * @return A ByteArray containing the char array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(char[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null char array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Character.BYTES);
		char mask = 0x00FF;
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < Character.BYTES; ++j) {
				ret.arr[j + (i * Character.BYTES)] = 
						(byte)((array[i] >> (Byte.SIZE * (Character.BYTES - 1 - j))) & mask);
			}
		}
		return ret;
	}
	
	/**
	 * Converts a double value into a ByteArray.
	 * @param value The double value to convert.
	 * @return A ByteArray containing the double value.
	 * @since JDK-21
	 */
	public static ByteArray from(double value) {
		ByteArray ret = new ByteArray(Double.BYTES);
		long v = Double.doubleToRawLongBits(value);
		long mask = 0x00000000000000FF;
		for (int i = 0; i < Double.BYTES; ++i)
			ret.arr[i] = (byte)((v >> (Byte.SIZE * (Double.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts a double array into a ByteArray.
	 * @param array The double array to convert.
	 * @return A ByteArray containing the double array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(double[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null double array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Double.BYTES);
		long mask = 0x00000000000000FF;
		for (int i = 0; i < array.length; ++i) {
			long v = Double.doubleToRawLongBits(array[i]);
			for (int j = 0; j < Double.BYTES; ++j)
				ret.arr[j + (i * Double.BYTES)] = (byte)((v >> (Byte.SIZE * (Double.BYTES - 1 - j))) & mask);
		}
		return ret;
	}
	
	/**
	 * Converts a float value into a ByteArray.
	 * @param value The float value to convert.
	 * @return A ByteArray containing the float value.
	 * @since JDK-21
	 */
	public static ByteArray from(float value) {
		ByteArray ret = new ByteArray(Float.BYTES);
		int v = Float.floatToRawIntBits(value);
		int mask = 0x000000FF;
		for (int i = 0; i < Float.BYTES; ++i)
			ret.arr[i] = (byte)((v >> (Byte.SIZE * (Float.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts a float array into a ByteArray.
	 * @param array The float array to convert.
	 * @return A ByteArray containing the float array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(float[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null float array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Float.BYTES);
		int mask = 0x000000FF;
		for (int i = 0; i < array.length; ++i) {
			int v = Float.floatToRawIntBits(array[i]);
			for (int j = 0; j < Float.BYTES; ++j)
				ret.arr[j + (i * Float.BYTES)] = (byte)((v >> (Byte.SIZE * (Float.BYTES - 1 - j))) & mask);
		}
		return ret;
	}
	
	/**
	 * Converts an int value into a ByteArray.
	 * @param value The int value to convert.
	 * @return A ByteArray containing the int value.
	 * @since JDK-21
	 */
	public static ByteArray from(int value) {
		ByteArray ret = new ByteArray(Integer.BYTES);
		int mask = 0x000000FF;
		for (int i = 0; i < Integer.BYTES; ++i)
			ret.arr[i] = (byte)((value >> (Byte.SIZE * (Integer.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts an int array into a ByteArray.
	 * @param array The int array to convert.
	 * @return A ByteArray containing the int array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(int[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null int array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Integer.BYTES);
		int mask = 0x000000FF;
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < Integer.BYTES; ++j)
				ret.arr[j + (i * Integer.BYTES)] = (byte)((array[i] >> (Byte.SIZE * (Integer.BYTES - 1 - j))) & mask);
		}
		return ret;
	}
	
	/**
	 * Converts a long value into a ByteArray.
	 * @param value The long value to convert.
	 * @return A ByteArray containing the long value.
	 * @since JDK-21
	 */
	public static ByteArray from(long value) {
		ByteArray ret = new ByteArray(Long.BYTES);
		long mask = 0x00000000000000FF;
		for (int i = 0; i < Long.BYTES; ++i)
			ret.arr[i] = (byte)((value >> (Byte.SIZE * (Long.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts a long array into a ByteArray.
	 * @param array The long array to convert.
	 * @return A ByteArray containing the long array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(long[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null long array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Long.BYTES);
		long mask = 0x00000000000000FF;
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < Long.BYTES; ++j)
				ret.arr[j + (i * Long.BYTES)] = (byte)((array[i] >> (Byte.SIZE * (Long.BYTES - 1 - j))) & mask);
		}
		return ret;
	}
	
	/**
	 * Converts a short value into a ByteArray.
	 * @param value The short value to convert.
	 * @return A ByteArray containing the short value.
	 * @since JDK-21
	 */
	public static ByteArray from(short value) {
		ByteArray ret = new ByteArray(Short.BYTES);
		short mask = 0x00FF;
		for (int i = 0; i < Short.BYTES; ++i)
			ret.arr[i] = (byte)((value >> (Byte.SIZE * (Short.BYTES - 1 - i))) & mask);
		return ret;
	}
	
	/**
	 * Converts a short array into a ByteArray.
	 * @param array The short array to convert.
	 * @return A ByteArray containing the short array.
	 * @throws NullPointerException Thrown if array is null.
	 * @since JDK-21
	 */
	public static ByteArray from(short[] array) 
			throws NullPointerException {
		if (array == null)
			throw new NullPointerException("Cannot convert a null short array into a ByteArray.");
		ByteArray ret = new ByteArray(array.length * Short.BYTES);
		short mask = 0x00FF;
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < Short.BYTES; ++j)
				ret.arr[j + (i * Short.BYTES)] = (byte)((array[i] >> (Byte.SIZE * (Short.BYTES - 1 - j))) & mask);
		}
		return ret;
	}
	
	/**
	 * Convenience method to convert a String into a ByteArray.
	 * @param str The String to convert.
	 * @return A ByteArray containing the String.
	 * @throws NullPointerException Thrown if str is null.
	 * @since JDK-21
	 */
	public static ByteArray from(String str) 
			throws NullPointerException {
		if (str == null)
			throw new NullPointerException("Cannot convert a null String into a ByteArray.");
		char[] c = str.toCharArray();
		return ByteArray.from(c);
	}
	
	@Override
	public Byte get(int index) 
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
		if (o == null || !(o instanceof Byte))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < arr.length; ++i) {
				if (((Byte)o).byteValue() == arr[i])
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
		if (o == null || !(o instanceof Byte))
			return -1;
		
		readLock.lock();
		
		try {
			for (int i = arr.length - 1; i >= 0; --i) {
				if (((Byte) o).byteValue() == arr[i])
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
			throw new NullPointerException("Cannot set ByteArray value to a null value.");
		
		if (!(o instanceof Byte))
			throw new IllegalArgumentException("Cannot set ByteArray value to a non-Byte object.");
		
		writeLock.lock();
		
		try {
			arr[index] = ((Byte)o);
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
	public ByteArray subArray(int start, int end) 
			throws IllegalArgumentException {
		if (start < 0 || end > this.size() || start >= end)
			throw new IllegalArgumentException("Cannot create a sub-array due to invalid indices.");
		
		ByteArray ret = new ByteArray(end - start);
		
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
	 * Returns a copy of the byte array backing this ByteArray.
	 * @return A copy of the byte array.
	 * @since JDK-21
	 */
	public byte[] toArray() {
		byte[] copy = new byte[arr.length];
		
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
		Byte[] copy = new Byte[arr.length];
		
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
