package babs.mindforge.util.block;

import java.util.Iterator;

/**
 * SortedArrayIterator class creates an Iterator for a SortedArray. The SortedArrayIterator copies the specified 
 * SortedArray so that the Iterator is detached from the actual SortedArray. Therefore, changing the Array contents 
 * through the SortedArrayIterator will not change the original Array. This allows the SortedArrayIterator to maintain 
 * the thread safety of the SortedArray. SortedArrayIterator implements Iterator.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The SortedArray element type.
 * @see SortedArray
 * @see Iterator
 * @since JDK-21
 */
public class SortedArrayIterator<E extends Comparable<E>> implements Iterator<E> {
	
	/**
	 * The Array that the ArrayIterator iterates over.
	 */
	private SortedArray<E> arr;
	/**
	 * Current iterator index.
	 */
	private int index;
	
	/**
	 * Constructor that creates an SortedArrayIterator from the specified SortedArray.
	 * @param arr The SortedArray to create an Iterator from.
	 * @throws NullPointerException Thrown if arr is null.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	public SortedArrayIterator(SortedArray<E> arr) 
			throws NullPointerException {
		if (arr == null)
			throw new NullPointerException("Cannot create an SortedArrayIterator from a null SortedArray.");
		
		this.arr = (SortedArray<E>)arr.clone();
		index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < arr.sizeUsed();
	}

	@Override
	public E next() {
		E ret = arr.get(index);
		index++;
		return ret;
	}

}
