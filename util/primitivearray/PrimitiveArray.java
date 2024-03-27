package babs.mindforge.util.primitivearray;

import java.util.Collection;
import java.util.Iterator;

/**
 * PrimitiveArray interface is used to represent a class wrapper for any primitive array type.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @since JDK-21
 */
public interface PrimitiveArray {

	/**
	 * Returns true if this PrimitiveArray contains the specified Object.
	 * @param o The Object to find.
	 * @return True if this contains o, otherwise false.
	 * @since JDK-21
	 */
	public boolean contains(Object o);
	
	/**
	 * Return true if this PrimitiveArray contains all of the elements in the specified Collection.
	 * @param c The Collection of elements to find.
	 * @return True if this contains all of c, otherwise false.
	 * @since JDK-21
	 */
	public boolean containsAll(Collection<?> c);
	
	/**
	 * Returns the Object at the specified index.
	 * @param index The index of the Object to return.
	 * @return The Object at index.
	 * @throws ArrayIndexOutOfBoundsException Thrown if index is out-of-bounds.
	 * @since JDK-21
	 */
	public Object get(int index) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Returns the index of the specified Object, or -1 if the Object is not in this PrimitiveArray.
	 * @param o The Object to find.
	 * @return The index of o, or -1 if o is not in this.
	 * @since JDK-21
	 */
	public int indexOf(Object o);
	
	/**'
	 * Returns an Iterator for this PrimitiveArray.
	 * @return An Iterator for this.
	 * @since JDK-21
	 */
	public Iterator<?> iterator();
	
	/**
	 * Returns the last index of the specified Object, or -1 if the Object is not in this PrimitiveArray.
	 * @param o The Object to find.
	 * @return The last index of o, or -1 if o is not in this.
	 * @since JDK-21
	 */
	public int lastIndexOf(Object o);
	
	/**
	 * Sets the Object at the specified index to the specified Object.
	 * @param index The index to set.
	 * @param o The Object to set at index.
	 * @throws ArrayIndexOutOfBoundsException Thrown if index is out-of-bounds.
	 * @throws IllegalArgumentException Thrown if o is not an instance of this PrimitiveArray's type.
	 * @throws NullPointerException Thrown if o is null.
	 * @since JDK-21
	 */
	public void set(int index, Object o) 
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException;
	
	/**
	 * Returns the size of this PrimitiveArray.
	 * @return The size of this.
	 * @since JDK-21
	 */
	public int size();
	
	/**
	 * Returns a PrimitiveArray containing the elements from [start, end).
	 * @param start The index to start at (inclusive).
	 * @param end The index to stop at (exclusive).
	 * @return A PrimitiveArray containing elements from [start, end).
	 * @throws IllegalArgumentException Thrown if start or end indices are out-of-bounds or if start is greater than 
	 * or equal to end..
	 * @since JDK-21
	 */
	public PrimitiveArray subArray(int start, int end)throws IllegalArgumentException;
	
	/**
	 * Returns an array of the specified type, containing the elements in this PrimitiveArray. If all the elements 
	 * can fit into the specified array, then that array is filled with this PrimitiveArray and returned. Otherwise, 
	 * a new array is created of the specified type and filled with this PrimitiveArray and returned.
	 * @param <T> The array type.
	 * @param a The array to fill with this.
	 * @return Returns a if this fits in a, otherwise a T[] containing this.
	 * @since JDK-21
	 */
	public <T> T[] toArray(T[] a);
	
}
