package babs.mindforge.util.block;

import java.util.Iterator;

/**
 * ArrayIterator class creates an Iterator for an Array. The ArrayIterator copies the specified Array so that the 
 * Iterator is detached from the actual Array. Therefore, changing the Array contents through the ArrayIterator will 
 * not change the original Array. This allows the ArrayIterator to maintain the thread safety of the Array. 
 * ArrayIterator implements Iterator.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The Array element type.
 * @see Array
 * @see Iterator
 * @since JDK-21
 */
public class ArrayIterator<E> implements Iterator<E> {
	
	/**
	 * The Array that the ArrayIterator iterates over.
	 */
	private Array<E> arr;
	/**
	 * Current iterator index.
	 */
	private int index;
	
	/**
	 * Constructor that creates an ArrayIterator from the specified Array.
	 * @param arr The Array to create an Iterator from.
	 * @throws NullPointerException Thrown if arr is null.
	 * @since JDK-21
	 */
	@SuppressWarnings("unchecked")
	public ArrayIterator(Array<E> arr) 
			throws NullPointerException {
		if (arr == null)
			throw new NullPointerException("Cannot create an ArrayIterator from a null Array.");
		
		this.arr = (Array<E>)arr.clone();
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
