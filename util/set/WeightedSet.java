package babs.mindforge.util.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * WeightedSet class represents a set of WeightedKeys, which are key values with a weight value associated with them. 
 * Unlike normal sets, when checking if a WeightedSet contains an item, the item can just be the key value alone. The
 * associated weight value does not have to be included, since the weight value will change often. When an element is 
 * added to a WeightedSet, if the set already contains the element, the weight value for that element is incremented 
 * and then all weights in the set are normalized based on the maximum weight value in the set. WeightedSets have a 
 * default maximum capacity of 1000. This can be changed with the {@link #WeightedSet(int)} constructor. If an 
 * element is added that will cause the WeightedSet to exceed its maximum capacity, then the element with the lowest 
 * weight value will be removed to allow the new element to be added. WeightedSet extends LimitedSet and is 
 * thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The element type.
 * @see LimitedSet
 * @see WeightedKey
 * @since JDK-21
 */
public class WeightedSet<E> extends LimitedSet<WeightedKey<E>> {
	
	/**
	 * Default constructor that creates an empty WeightedSet with the default maximum capacity.
	 * @since JDK-21
	 */
	public WeightedSet() {
		maxCapacity = DEF_MAX_CAPACITY;
		set = new ArrayList<WeightedKey<E>>(DEF_MAX_CAPACITY);
	}
	
	/**
	 * Default constructor that creates an empty WeightedSet with the specified maximum capacity.
	 * @param maxCapacity The maximum capacity of this.
	 * @since JDK-21
	 */
	public WeightedSet(int maxCapacity) {
		if (maxCapacity < 0)
			throw new IllegalArgumentException("Cannot create a LimitedSet with a negative maximum capacity.");
		
		this.maxCapacity = maxCapacity;
		set = new ArrayList<WeightedKey<E>>(maxCapacity);
	}
	
	/**
	 * Constructor that initializes this WeightedSet to the contents of the specified Collection. This WeightedSet's 
	 * maximum capacity will be set to the greater of the size of the specified Collection or the default maximum 
	 * capacity.
	 * @param c The Collection to store into this WeightedSet.
	 * @since JDK-21
	 */
	public WeightedSet(Collection<? extends E> c) {
		maxCapacity = (c.size() > DEF_MAX_CAPACITY) ? c.size() : DEF_MAX_CAPACITY;
		set = new ArrayList<WeightedKey<E>>(maxCapacity);
		this.addAllKeys(c);
	}
	
	/**
	 * Constructor that initializes this WeightedSet to the contents of the specified WeightedSet.
	 * @param c The WeightedSet to store into this WeightedSet.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	private WeightedSet(WeightedSet<E> set) {
		this.maxCapacity = set.maxCapacity;
		this.set = (ArrayList<WeightedKey<E>>)set.set.clone();
	}
	
	/**
	 * Adds the specified WeightedKey to this WeightedSet, if it does not already contain the specified WeightedKey. 
	 * If this contains the specified WeightedKey, the weight of that WeightedKey is incremented and then all weight 
	 * values for each element in this WeightedSet are normalized based on the maximum weight value in this 
	 * WeightedSet. If adding the specified element will exceed this WeightedSet's maximum capacity, then the element 
	 * with the lowest weight value will be removed to allow the specified element to be added. This returns false if 
	 * the specified WeightedKey is null.
	 * @param e The WeightedKey to add.
	 * @return This returns false if e is null, otherwise true.
	 * @since JDK-21
	 */
	@Override
	public boolean add(WeightedKey<E> e) {
		if (e == null)
			return false;
		
		writeLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).equals(e)) {
					set.get(i).update();
					
					float max = this.max();
					
					for (int j = 0; j < set.size(); ++j)
						set.get(j).normalize(max);
					
					return true;
				}
			}
			
			if (this.size() == maxCapacity) {
				set.remove(this.minIndex());
			}
				
			set.add(e);
		}
		finally {
			writeLock.unlock();
		}
		
		return true;
	}
	
	/**
	 * Adds the specified key to this WeightedSet, if it does not already contain the specified key. If this contains 
	 * the specified key, the weight of that key is incremented and then all weight values for each element in this 
	 * WeightedSet are normalized based on the maximum weight value in this WeightedSet. If adding the specified key 
	 * will exceed this WeightedSet's maximum capacity, then the element with the lowest weight value will be removed 
	 * to allow the specified key to be added. This returns false if the specified key is null.
	 * @param e The key to add.
	 * @return This returns false if e is null, otherwise true.
	 * @since JDK-21
	 */
	public boolean addKey(E e) {
		if (e == null)
			return false;
		
		writeLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getKey().equals(e)) {
					set.get(i).update();
					
					float max = this.max();
					
					for (int j = 0; j < set.size(); ++j)
						set.get(j).normalize(max);
					
					return true;
				}
			}
			
			if (this.size() == maxCapacity) {
				set.remove(this.minIndex());
			}
				
			set.add(new WeightedKey<E>(e));
		}
		finally {
			writeLock.unlock();
		}
		
		return true;
	}
	
	/**
	 * Adds all the elements in the specified Collection to this WeightedSet, if it does not already contain the 
	 * elements. If this contains the elements, the weight of the contained elements are incremented and then all 
	 * weight values for each element in this WeightedSet are normalized based on the maximum weight value in this 
	 * WeightedSet. If adding the specified Collection will exceed this WeightedSet's maximum capacity, then the 
	 * elements with the lowest weight values will be removed to allow the excess elements to be added. This returns 
	 * false if the specified Collection is null.
	 * @param c The Collection of elements to add.
	 * @return This returns false if c is null, otherwise true.
	 * @since JDK-21
	 */
	@Override
	public boolean addAll(Collection<? extends WeightedKey<E>> c) {
		if (c == null)
			return false;
		
		Iterator<? extends WeightedKey<E>> it = c.iterator();
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				WeightedKey<E> e = it.next();
				boolean r = false;
				
				for (int i = 0; i < set.size() && r == false; ++i) {
					if (set.get(i).equals(e)) {
						set.get(i).update();
						
						float max = this.max();
						
						for (int j = 0; j < set.size(); ++j)
							set.get(j).normalize(max);
						
						r = true;
					}
				}
				
				if (this.size() == maxCapacity) {
					set.remove(this.minIndex());
				}
					
				set.add(e);
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return true;
	}
	
	/**
	 * Adds all the keys in the specified Collection to this WeightedSet, if it does not already contain the keys. If 
	 * this contains the keys, the weight of the contained keys are incremented and then all weight values for each 
	 * element in this WeightedSet are normalized based on the maximum weight value in this WeightedSet. If adding 
	 * the specified Collection will exceed this WeightedSet's maximum capacity, then the elements with the lowest 
	 * weight values will be removed to allow the excess elements to be added. This returns false if the specified 
	 * Collection is null.
	 * @param c The Collection of keys to add.
	 * @return This returns false if c is null, otherwise true.
	 * @since JDK-21
	 */
	public boolean addAllKeys(Collection<? extends E> c) {
		if (c == null)
			return false;
		
		Iterator<? extends E> it = c.iterator();
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				E e = it.next();
				boolean r = false;
				
				for (int i = 0; i < set.size() && r == false; ++i) {
					if (set.get(i).getKey().equals(e)) {
						set.get(i).update();
						
						float max = this.max();
						
						for (int j = 0; j < set.size(); ++j)
							set.get(j).normalize(max);
						
						r = true;
					}
				}
				
				if (this.size() == maxCapacity) {
					set.remove(this.minIndex());
				}
					
				set.add(new WeightedKey<E>(e));
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return true;
	}
	
	@Override
	public WeightedSet<E> clone() {
		return new WeightedSet<E>(this);
	}
	
	/**
	 * Returns true if this WeightedSet contains the specified key.
	 * @param e The key to find.
	 * @return True if this contains e.
	 * @since JDK-21
	 */
	public boolean containsKey(E e) {
		readLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getKey().equals(e))
					return true;
			}
		}
		finally {
			readLock.unlock();
		}
		
		return false;
	}
	
	/**
	 * Returns true if this WeightedSet contains all of the keys in the specified Collection.
	 * @param c The Collection of keys to find.
	 * @return True if this contains all of c.
	 * @since JDK-21
	 */
	public boolean containsAllKeys(Collection<E> c) {
		Iterator<E> it = c.iterator();
		
		while (it.hasNext()) {
			if (!this.contains(it.next()))
				return false;
		}
		
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o instanceof WeightedSet<?>)
			return ((WeightedSet<?>)o).size() == this.size() && ((WeightedSet<?>)o).set.containsAll(set);
		
		return false;
	}
	
	/**
	 * Finds and returns the maximum weight value in this WeightedSet.
	 * @return The maximum weight value in this.
	 * @since JDK-21
	 */
	public float max() {
		float max = 0.0f;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getValue() > max)
					max = set.get(i).getValue();
			}
		}
		finally {
			readLock.unlock();
		}
		
		return max;
	}
	
	/**
	 * Finds and returns the minimum weight value in this WeightedSet.
	 * @return The minimum weight value in this.
	 * @since JDK-21
	 */
	public float min() {
		float min = 1.0f;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getValue() <= min)
					min = set.get(i).getValue();
			}
		}
		finally {
			readLock.unlock();
		}
		
		return min;
	}
	
	/**
	 * Finds and returns the index of the element with the minimum weight value.
	 * @return The index of the minimum weight value.
	 * @since JDK-21
	 */
	private int minIndex() {
		float min = 1.0f;
		int index = 0;
		
		readLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getValue() <= min) {
					min = set.get(i).getValue();
					index = i;
				}
			}
		}
		finally {
			readLock.unlock();
		}
		
		return index;
	}
	
	/**
	 * Removes the WeightedKey with the specified key from this WeightedSet.
	 * @param e The key to remove.
	 * @return True if the specified key was removed, otherwise false.
	 * @since JDK-21
	 */
	public boolean removeKey(E e) {
		writeLock.lock();
		
		try {
			for (int i = 0; i < set.size(); ++i) {
				if (set.get(i).getKey().equals(e)) {
					set.remove(i);
					return true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return false;
	}
	
	/**
	 * Removes the WeightedKeys containing the keys in the specified Collection from this WeightedSet.
	 * @param c The Collection of keys to remove.
	 * @return True if this WeightedSet is changed after this method call.
	 * @since JDK-21
	 */
	public boolean removeAllKeys(Collection<E> c) {
		Iterator<E> it = c.iterator();
		boolean ret = false;
		
		writeLock.lock();
		
		try {
			while (it.hasNext()) {
				E e = it.next();
				boolean r = false;
				
				for (int i = 0; i < set.size() && r == false; ++i) {
					if (set.get(i).getKey().equals(e)) {
						set.remove(i);
						r = true;
					}
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		writeLock.lock();
		
		try {
			return set.removeAll(c);
		}
		finally {
			writeLock.unlock();
		}
	}
	
	/**
	 * Removes any WeightedKeys that do not have their key value in the specified Collection of keys, thereby 
	 * retaining only the WeightedKeys whose key value is contained in the specified Collection.
	 * @param c The Collection of keys to retain.
	 * @return True if this WeightedSet is changed after this method call.
	 * @since JDK-21
	 */
	public boolean retainAllKeys(Collection<E> c) {
		boolean ret = false;
		
		writeLock.lock();
		
		try {
			for (int i = set.size() - 1; i >= 0; --i) {
				if (!c.contains(set.get(i).getKey())) {
					set.remove(i);
					ret = true;
				}
			}
		}
		finally {
			writeLock.unlock();
		}
		
		return ret;
	}
	
}
