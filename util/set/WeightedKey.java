package babs.mindforge.util.set;

import java.util.Map.Entry;

/**
 * WeightedKey class represents a key value that has a weight value associated with it.
 * The weight value in a WeightedKey has an {@link #update(float)} method and a {@link 
 * #normalize()} method that are used by WeightedSets to update and normalize the weight
 * based on the other weights in the WeightedSet. WeightedKey implements Entry and is 
 * thread-safe.
 * 
 * @author Monroe Gordon
 * @version 0.0.1
 * @param <E> The key type.
 * @see WeightedSet
 * @since 21
 */
public class WeightedKey<E> implements Entry<E, Float> {
	
	/**
	 * The key value.
	 */
	private E key;
	/**
	 * The value associated with the key. This value represents the weight of the 
	 * key.
	 */
	private Float value;
	
	/**
	 * Constructor that initializes this WeightedKey with the specified key and a
	 * weight value of 1.
	 * @param key The key value.
	 * @since 21
	 */
	public WeightedKey(E key) {
		if (key == null)
			throw new NullPointerException("Cannot create a WeightedKey with a null key.");
		
		this.key = key;
		value = 1.0f;
	}
	
	/**
	 * Returns true if the specified Object is equal to this WeightedKey, meaning
	 * they have the same key and value.
	 * @param o The Object to compare to.
	 * @return True if o equals this, otherwise false.
	 * @since 21
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o instanceof WeightedKey<?>)
			return ((WeightedKey<?>)o).getKey().equals(key) && ((WeightedKey<?>)o).getValue().equals(value);
		
		return false;
	}

	@Override
	public E getKey() {
		return key;
	}

	@Override
	public Float getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return key.hashCode() + (((Float)value).hashCode() << 1);
	}
	
	/**
	 * Normalizes the weight value by dividing it by the specified max weight value.
	 * If the max weight value is 0, the weight value remains unchanged.
	 * @param max The max weight value. This is the greatest weight value among this
	 * WeightedKey and others it is grouped with, typically in a WeightedSet.
	 * @return The normalized weight value.
	 * @see WeightSet
	 * @since 21
	 */
	public synchronized Float normalize(float max) {
		if (max > 0.0f)
			value /= max;
		
		return value;
	}

	@Override
	public synchronized Float setValue(Float value) {
		Float ret = value;
		this.value = value;
		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %f)", key.toString(), value);
	}
	
	/**
	 * Updates the weight value by incrementing it by 1.
	 * @return The updated weight value.
	 * @since 21
	 */
	public synchronized Float update() {
		value += 1.0f;
		return value;
	}

}
