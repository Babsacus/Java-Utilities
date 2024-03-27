package babs.mindforge.util.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * LimitedSet class represents a {@link UniqueSet} with a maximum element capacity. The default maximum capacity is 
 * 10, but this can be changed through the {@link #LimitedSet(int)} constructor. If the LimitedSet reaches its 
 * maximum capacity, no more elements can be added until other elements are removed. All other rules regarding 
 * UniqueSets apply to LimitedSets. LimitedSet extends UniqueSet and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The element type.
 * @see UniqueSet
 * @see Vector
 * @since JDK-21
 */
public class LimitedSet<E> extends UniqueSet<E> {
	
	/**
	 * The default maximum capacity of a LimitedSet.
	 */
	public static final int DEF_MAX_CAPACITY = 10;

	/**
	 * The maximum capacity of elements in the LimitedSet.
	 */
	protected int maxCapacity;
	
	/**
	 * Default constructor that creates an empty LimitedSet with a maximum capacity equal to the default capacity of 
	 * a LimitedSet.
	 * @since JDK-21
	 */
	public LimitedSet() {
		set = new ArrayList<E>(DEF_MAX_CAPACITY);
		maxCapacity = DEF_MAX_CAPACITY;
	}
	
	/**
	 * Default constructor that creates an empty LimitedSet with a maximum capacity equal to the specified maximum 
	 * capacity.
	 * @param maxCapacity The maximum capacity of this.
	 * @since JDK-21
	 */
	public LimitedSet(int maxCapacity) {
		if (maxCapacity < 0)
			throw new IllegalArgumentException("Cannot create a LimitedSet with a negative maximum capacity.");
		
		set = new ArrayList<E>(maxCapacity);
		this.maxCapacity = maxCapacity;
	}
	
	/**
	 * Constructor that initializes this LimitedSet to the unique contents of the specified Collection. The maximum 
	 * capacity of this LimitedSet will be set to the greater of the size of the specified Collection or the default
	 * capacity of a Vector.
	 * @param c The Collection to store into this LimitedSet.
	 * @since JDK-21
	 */
	public LimitedSet(Collection<? extends E> c) {
		maxCapacity = (c.size() > DEF_MAX_CAPACITY) ? c.size() : DEF_MAX_CAPACITY;
		set = new ArrayList<E>(maxCapacity);
		this.addAll(c);
	}
	
	/**
	 * Adds the specified element to this LimitedSet, if it is not already contained in this LimitedSet, and if this 
	 * LimitedSet has not reached its maximum capacity. This returns false if the specified element is null or if 
	 * this LimitedSet already contains the specified element or if this LimitedSet is full.
	 * @param e The element to add.
	 * @return True if e is added, false otherwise.
	 * @since JDK-21
	 */
	@Override
	public boolean add(E e) {
		if (e == null)
			return false;
		
		writeLock.lock();
		
		try {
			if (!this.contains(e) && set.size() < maxCapacity) {
				return set.add(e);
			}
			else {
				return false;
			}
		}
		finally {
			writeLock.unlock();
		}
	}
	
	/**
	 * Adds the specified Collection of elements to this LimitedSet, if they are not already contained in this 
	 * LimitedSet, and if this LimitedSet has not reached its maximum capacity. This returns false if not all 
	 * elements in the specified Collection could be added or if the specified Collection is null.
	 * @param c The Collection to add.
	 * @return True if all of c is added, false otherwise.
	 * @since JDK-21
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c == null)
			return false;
		
		Iterator<? extends E> it = c.iterator();
		boolean ret = true;
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				E e = it.next();
				boolean r = false;
				
				if (!this.contains(e) && set.size() < maxCapacity) {
					r = set.add(e);
				}
				
				ret &= r;
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
	/**
	 * Returns the maximum element capacity of this LimitedSet.
	 * @return The maximum capacity of this.
	 * @since JDK-21
	 */
	public int maxCapacity() {
		readLock.lock();
		
		try {
			return maxCapacity;
		}
		finally {
			readLock.unlock();
		}
	}
	
	/**
	 * This sets the maximum element capacity of this LimitedSet to the specified value. If there are more elements 
	 * than the new maximum element capacity allows for, the last elements added to this LimitedSet that exceed the
	 * maximum element capacity are removed.
	 * @param maxCapacity The new maximum element capacity.
	 * @since JDK-21
	 */
	public void setMaxCapacity(int maxCapacity) {
		writeLock.lock();
		
		try {
			if (this.maxCapacity != maxCapacity) {
				this.maxCapacity = maxCapacity;
				
				while (this.size() > maxCapacity) {
					set.removeLast();
				}
				
				set.ensureCapacity(maxCapacity);
			}
		}
		finally {
			writeLock.unlock();
		}
	}
	
}
