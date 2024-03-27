package babs.mindforge.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tuple class represents a group of immutable Objects. The Objects can be of any type and can be null. This class is 
 * simply of storage container for different Objects. Once a Tuple is created, it cannot have Objects added or 
 * removed. Objects in the Tuple are stored in the order they were specified and can be accessed through their index 
 * value. There is also a {@link #getAs(Class, int)} method that can attempt to return the desired Object cast as the 
 * desired class. If the cast fails, null is returned instead. Objects can be added or removed from a Tuple, but 
 * these methods return a new Tuple containing the change to the original Tuple. The original Tuple remains unchanged. 
 * Tuple is thread-safe since they are immutable.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @since JDK-21
 */
public final class Tuple {
	
	/**
	 * Vector of objects backing the Tuple.
	 */
	private ArrayList<Object> arr;
	
	/**
	 * Default constructor that creates an empty Tuple.
	 * @since JDK-21
	 */
	public Tuple() {
		arr = new ArrayList<Object>();
	}
	
	/**
	 * Constructor that initializes this Tuple to contain the specified list of Objects.
	 * @param objects The Objects to store.
	 * @since JDK-21
	 */
	public Tuple(Object ...objects) {
		arr = new ArrayList<Object>(objects.length);
		
		for (int i = 0; i < objects.length; ++i) {
			arr.add(objects[i]);
		}
	}
	
	/**
	 * Returns a new Tuple containing this Tuple plus the specified Object to add.
	 * @param o The Object to add.
	 * @return A Tuple containing this and o.
	 * @since JDK-21
	 */
	public Tuple add(Object o) {
		Tuple ret = (Tuple)this.clone();
		ret.arr.add(o);
		return ret;
	}
	
	/**
	 * Returns a new Tuple containing this Tuple plus the specified Object to add.
	 * @param objects The Objects to add.
	 * @return A Tuple containing this and o.
	 * @since JDK-21
	 */
	public Tuple addAll(Object ...objects) {
		Tuple ret = (Tuple)this.clone();
		ret.arr.addAll(ArrayInto.collection(objects));
		return ret;
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
	 * @since JDK-21
	 */
	public Object get(int index) 
			throws ArrayIndexOutOfBoundsException {
		if (index >= arr.size())
			throw new ArrayIndexOutOfBoundsException("Cannot get Tuple Object due to out-of-bounds index.");
		
		return arr.get(index);
	}
	
	/**
	 * Returns the Object at the specified index casted to the specified class. If the Object at index is not an 
	 * instance of the specified class, null is returned.
	 * @param <T> Any type.
	 * @param clazz The class to cast the Object to.
	 * @param index The index of the Object.
	 * @return The Object at index cast as T, or null if cast fails.
	 * @since JDK-21
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
	 * Returns true if this Tuple contains no Objects.
	 * @return True if this is empty.
	 * @since JDK-21
	 */
	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	/**
	 * Returns an iterator over the elements in the Tuple.
	 * @return An iterator over this.
	 * @since JDK-21
	 */
	public Iterator<Object> iterator() {
		return arr.iterator();
	}
	
	/**
	 * Returns a new Tuple containing this Tuple minus the specified Object to remove. This removes the first 
	 * occurrence of the specified Object.
	 * @param o The Object to remove.
	 * @return A Tuple containing this without o.
	 * @since JDK-21
	 */
	public Tuple remove(Object o) {
		Tuple ret = (Tuple)this.clone();
		ret.arr.remove(o);
		return ret;
	}
	
	/**
	 * Returns a new Tuple containing this Tuple minus all the specified Objects. This removes any occurrence of each 
	 * specified Object.
	 * @param objects The Objects to remove.
	 * @return A Tuple containing this without objects.
	 * @since JDK-21
	 */
	public Tuple removeAll(Object ...objects) {
		Tuple ret = (Tuple)this.clone();
		for (int i = 0; i < objects.length; ++i)
			ret = ret.removeAny(objects[i]);
		return ret;
	}
	
	/**
	 * Returns a new Tuple containing this Tuple minus the specified Object to remove. This removes any occurrence of 
	 * the specified Object.
	 * @param o The Object to remove.
	 * @return A Tuple containing this without o.
	 * @since JDK-21
	 */
	public Tuple removeAny(Object o) {
		Tuple ret = (Tuple)this.clone();
		boolean removed = true;
		while (removed) {
			removed = ret.arr.remove(o);
		};
		return ret;
	}
	
	/**
	 * Returns a new Tuple containing this Tuple minus the specified Object to remove. This removes the last 
	 * occurrence of the specified Object.
	 * @param o The Object to remove.
	 * @return A Tuple containing this without o.
	 * @since JDK-21
	 */
	public Tuple removeLast(Object o) {
		Tuple ret = (Tuple)this.clone();
		for (int i = ret.arr.size() - 1; i >= 0; --i) {
			if (ret.arr.get(i).equals(o)) {
				ret.arr.remove(i);
				return ret;
			}
		}
		return ret;
	}
	
	/**
	 * Returns the number of Objects in this Tuple.
	 * @return The size of this.
	 * @since JDK-21
	 */
	public int size() {
		return arr.size();
	}
	
	/**
	 * Returns this Tuple as an array.
	 * @return this Tuple as an array.
	 * @since JDK-21
	 */
	public Object[] toArray() {
		return arr.toArray();
	}
	
	@Override 
	public String toString() {
		String ret = "Tuple: ";
		
		if (this.isEmpty()) {
			ret += "Empty";
		}
		else {
			for (int i = 0; i < arr.size(); ++i) {
				if (arr.get(i) == null)
					ret += "null";
				else
					ret += arr.get(i).toString();
				
				if (i < arr.size() - 1)
					ret += ", ";
			}
		}
		
		return ret;
	}
	
}
