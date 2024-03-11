package babs.mindforge.util.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * UniqueSet class is a set of unique values, meaning no duplicate or null values can be
 * contained within a UniqueSet. A UniqueSet does not store elements in any particular
 * order. Elements in a UniqueSet can be iterated over by retrieving an iterator via the 
 * {@link #iterator()} method. UniqueSet implements Set and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.1
 * @param <E> The element type.
 * @see Set
 * @since 21
 */
public class UniqueSet<E> implements Set<E> {
	
	/**
	 * The Vector backing the UniqueSet.
	 */
	protected ArrayList<E> set;
	
	/**
	 * Default constructor that creates an empty UniqueSet.
	 * @since 21
	 */
	public UniqueSet() {
		set = new ArrayList<E>();
	}
	
	/**
	 * Constructor that initializes this UniqueSet to the unique contents of the 
	 * specified Collection.
	 * @param c The Collection to store into this UniqueSet.
	 * @since 21
	 */
	public UniqueSet(Collection<? extends E> c) {
		set = new ArrayList<E>();
		this.addAll(c);
	}

	/**
	 * Adds the specified element to this UniqueSet, if this UniqueSet does not
	 * already contain the specified element. This returns false is the specified
	 * element is null or is already in this UniqueSet.
	 * @param e The element to add.
	 * @return True if e is added, otherwise false.
	 * @since 21	 
	 */
	@Override
	public synchronized boolean add(E e) {
		if (e == null)
			return false;
		
		if (!this.contains(e))
			return set.add(e);
		else
			return false;
	}
	
	/**
	 * Adds the specified Collection of elements to this UniqueSet, if this 
	 * UniqueSet does not already contain the specified elements. This returns 
	 * false is the specified Collection is null or is already in this UniqueSet.
	 * @param c The Collection to add.
	 * @return True if this UniqueSet is changed after this method call.
	 * @since 21	 
	 */
	@Override
	public synchronized boolean addAll(Collection<? extends E> c) {
		if (c == null)
			return false;
		
		Iterator<? extends E> it = c.iterator();
		boolean ret = false;
		
		while (it.hasNext()) {
			ret |= this.add(it.next());
		}
		
		return ret;
	}
	
	@Override
	public synchronized void clear() {
		set.clear();
	}
	
	@Override
	public Object clone() {
		return new UniqueSet<E>(set);
	}
	
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o instanceof UniqueSet<?>)
			return ((UniqueSet<?>)o).size() == this.size() && ((UniqueSet<?>)o).containsAll(set);
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return set.hashCode();
	}
	
	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		return ((UniqueSet<E>)set.clone()).iterator();
	}

	@Override
	public synchronized boolean remove(Object o) {
		return set.remove(o);
	}
	
	@Override
	public synchronized boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}
	
	@Override
	public synchronized boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}
	
	@Override
	public int size() {
		return set.size();
	}
	
	@Override
	public Object[] toArray() {
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}
	
	@Override
	public String toString() {
		String ret = "{ ";
		
		for (int i = 0; i < set.size(); ++i) {
			if (i < set.size() - 1)
				ret += set.get(i).toString() + " ";
			else
				ret += set.get(i).toString() + " }";
		}
		
		return ret;
	}

}
