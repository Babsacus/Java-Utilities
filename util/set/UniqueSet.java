package babs.mindforge.util.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * UniqueSet class is a set of unique values, meaning no duplicate or null values can be contained within a UniqueSet. 
 * A UniqueSet does not store elements in any particular order. Elements in a UniqueSet can be iterated over by 
 * retrieving an iterator via the {@link #iterator()} method. UniqueSet implements Set and is thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The element type.
 * @see Set
 * @since JDK-21
 */
public class UniqueSet<E> implements Set<E> {
	
	/**
	 * A read/write lock used to ensure thread-safety.
	 */
	protected final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 * The read lock from the read/write lock.
	 */
	protected final Lock readLock = lock.readLock();
	/**
	 * The write lock from the read/write lock.
	 */
	protected final Lock writeLock = lock.writeLock();
	
	/**
	 * The Vector backing the UniqueSet.
	 */
	protected ArrayList<E> set;
	
	/**
	 * Default constructor that creates an empty UniqueSet.
	 * @since JDK-21
	 */
	public UniqueSet() {
		set = new ArrayList<E>();
	}
	
	/**
	 * Constructor that initializes this UniqueSet to the unique contents of the specified Collection.
	 * @param c The Collection to store into this UniqueSet.
	 * @since JDK-21
	 */
	public UniqueSet(Collection<? extends E> c) {
		set = new ArrayList<E>();
		this.addAll(c);
	}

	/**
	 * Adds the specified element to this UniqueSet, if this UniqueSet does not already contain the specified element. 
	 * This returns false is the specified element is null or is already in this UniqueSet.
	 * @param e The element to add.
	 * @return True if e is added, otherwise false.
	 * @since JDK-21	 
	 */
	@Override
	public synchronized boolean add(E e) {
		if (e == null)
			return false;
		
		writeLock.lock();
		
		try {
			if (!this.contains(e)) {
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
	 * Adds the specified Collection of elements to this UniqueSet, if this UniqueSet does not already contain the 
	 * specified elements. This returns false is the specified Collection is null or is already in this UniqueSet.
	 * @param c The Collection to add.
	 * @return True if this UniqueSet is changed after this method call.
	 * @since JDK-21	 
	 */
	@Override
	public synchronized boolean addAll(Collection<? extends E> c) {
		if (c == null)
			return false;
		
		Iterator<? extends E> it = c.iterator();
		boolean ret = false;
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				E e = it.next();
				boolean r = false;
				
				if (!this.contains(e)) {
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
	
	@Override
	public synchronized void clear() {
		writeLock.lock();
		
		try {
			set.clear();
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public Object clone() {
		return new UniqueSet<E>(set);
	}
	
	@Override
	public boolean contains(Object o) {
		readLock.lock();
		
		try {
			return set.contains(o);
		}
		finally {
			readLock.unlock();
		}
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
		readLock.lock();
		
		try {
			return set.hashCode();
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public boolean isEmpty() {
		readLock.lock();
		
		try {
			return set.isEmpty();
		}
		finally {
			readLock.unlock();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		return ((ArrayList<E>)set.clone()).iterator();
	}

	@Override
	public synchronized boolean remove(Object o) {
		writeLock.lock();
		
		try {
			return set.remove(o);
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public synchronized boolean removeAll(Collection<?> c) {
		writeLock.lock();
		
		try {
			return set.removeAll(c);
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public synchronized boolean retainAll(Collection<?> c) {
		writeLock.lock();
		
		try {
			return set.retainAll(c);
		}
		finally {
			writeLock.unlock();
		}
	}
	
	@Override
	public int size() {
		readLock.lock();
		
		try {
			return set.size();
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public Object[] toArray() {
		readLock.lock();
		
		try {
			return set.toArray();
		}
		finally {
			readLock.unlock();
		}
	}

	@Override
	public <T> T[] toArray(T[] a) {
		readLock.lock();
		
		try {
			return set.toArray(a);
		}
		finally {
			readLock.unlock();
		}
	}
	
	@Override
	public String toString() {
		String ret = "{ ";
		
		readLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (i < set.size() - 1)
					ret += set.get(i).toString() + ", ";
				else
					ret += set.get(i).toString();
			}
			
			ret += " }";
		}
		finally {
			readLock.unlock();
		}
		
		return ret;
	}

}
