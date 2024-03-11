package babs.mindforge.util;

import java.util.ArrayList;

/**
 * Tuple class represents a group of 1 or more Objects. The Objects can be of any type and can be
 * null. This class is simply of storage container for different Objects. Once a Tuple is created,
 * it cannot have Objects added or removed. Objects in the Tuple are stored in the order they
 * were specified and can be accessed through their index value. There is also a {@link 
 * #getAs(Class, int)} method that can attempt to return the desired Object cast as the desired 
 * class. If the cast fails, null is returned instead. Tuples are thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.1
 * @since 21
 */
public final class Tuple {
	
	/**
	 * Vector of objects backing the Tuple.
	 */
	private ArrayList<Object> arr;

	/**
	 * Default constructor that creates a Tuple containing a single null Object.
	 */
	public Tuple() {
		arr = new ArrayList<Object>();
		arr.add(null);
	}
	
	/**
	 * Constructor that initializes this Tuple to contain the specified list of Objects.
	 * @param objects The Objects to store.
	 * @since 21
	 */
	public Tuple(Object ...objects) {
		arr = new ArrayList<Object>(objects.length);
		
		for (int i = 0; i < objects.length; ++i) {
			arr.add(objects[i]);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object clone() {
		Tuple ret = new Tuple();
		ret.arr = (ArrayList<Object>)arr.clone();
		return ret;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Tuple))
			return false;
		
		return ((Tuple)o).arr.equals(arr);
	}
	
	/**
	 * Returns the Object at the specified index.
	 * @param index The index of the Object.
	 * @return The Object at index.
	 * @throws ArrayIndexOutOfBoundsException Thrown if index is out-of-bounds.
	 * @since 21
	 */
	public Object get(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index >= arr.size())
			throw new ArrayIndexOutOfBoundsException("Cannot get Tuple Object due to out-of-bounds index.");
		
		return arr.get(index);
	}
	
	/**
	 * Returns the Object at the specified index casted to the specified class. If the Object
	 * at index is not an instance of the specified class, null is returned.
	 * @param <T> Any type.
	 * @param clazz The class to cast the Object to.
	 * @param index The index of the Object.
	 * @return The Object at index cast as T, or null if cast fails.
	 * @since 21
	 */
	@SuppressWarnings("unchecked")
	public <T extends Object> T getAs(Class<T> clazz, int index) {
		if (index >= arr.size())
			throw new ArrayIndexOutOfBoundsException("Cannot get Tuple Object due to out-of-bounds index.");
		
		if (arr.get(index).getClass().equals(clazz))
			return (T)arr.get(index);
		else
			return null;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		
		for (int i = 0; i < arr.size(); ++i) {
			hash += arr.get(i).hashCode() << (i % 32);
		}
		
		return hash;
	}
	
	/**
	 * Returns true if this Tuple has no Objects or only contains null Objects.
	 * @return True if this is empty.
	 * @since 21
	 */
	public boolean isEmpty() {
		if (arr.isEmpty())
			return true;
		
		for (int i = 0; i < arr.size(); ++i) {
			if (arr.get(i) != null)
				return false;
		}
		
		return true;
	}
	
	/**
	 * Returns the number of Objects in this Tuple.
	 * @return The size of this.
	 * @since 21
	 */
	public int size() {
		return arr.size();
	}
	
}
