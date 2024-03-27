package babs.mindforge.util.block;

import java.util.Collection;

/**
 * Block interface represents a Collection that is a block of contiguous memory that cannot be resized. Empty 
 * elements in a Block are set to null. This means null elements cannot be added to a Block. A Block has three 
 * different size methods: {@link #size()}, {@link #sizeUnused()}, and {@link #sizeUsed()}. The size method returns 
 * the total size of the Block, meaning the maximum number of elements the Block can hold. The sizeUnused method 
 * returns the number of null elements in the Block, which represent unused elements. The sizeUsed method returns the 
 * number of non-null elements, which are actual elements stored in the Block. A class that implements Block needs to 
 * either provide a constructor that requires the size of the Block, or a default size for the Block. Block extends 
 * Collection.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param <E> The element type.
 * @see Collection
 * @since JDK-21
 */
public interface Block<E> extends Collection<E> {
	
	/**
	 * Returns the element at the specified index, if the index is within the bounds of [0, sizeUsed()).
	 * @param index The index of the element to return.
	 * @return The element at index.
	 * @since JDK-21
	 */
	public E get(int index);

	/**
	 * Returns the first index of the specified element. If the specified element is not in this Block, this returns 
	 * -1.
	 * @param e The element to find.
	 * @return The first index of e, or -1 if e is null or not in this.
	 * @since JDK-21
	 */
	public int indexOf(E e);
	
	/**
	 * Returns the last index of the specified element. If the specified element is not in this Block, this returns -1.
	 * @param e The element to find.
	 * @return The last index of e, or -1 if e is null or not in this.
	 * @since JDK-21
	 */
	public int lastIndexOf(E e);
	
	/**
	 * Removes the element at the specified index..
	 * @param index The index of the element to remove.
	 * @return The removed element.
	 * @since JDK-21
	 */
	public E remove(int index);
	
	/**
	 * Removes any occurrence of the specified Object as if repeatedly calling {@link Collection#remove(Object)} until 
	 * it returns false.
	 * @param o The Object to remove.
	 * @return True if o was removed at all, otherwise false.
	 * @since JDK-21
	 */
	public boolean removeAny(Object o);
	
	/**
	 * Removes the last occurrence of the specified Object.
	 * @param o The Object to remove.
	 * @return True if o was removed, otherwise false.
	 * @since JDK-21
	 */
	public boolean removeLast(Object o);
	
	/**
	 * Returns the number of null elements in this Block which are unused elements.
	 * @return The number of null elements.
	 * @since JDK-21
	 */
	public int sizeUnused();
	
	/**
	 * Returns the number of non-null elements in this Block.
	 * @return The number of non-null elements.
	 * @since JDK-21
	 */
	public int sizeUsed();
	
	/**
	 * Creates a sub-block from this Block containing elements from [start, end).
	 * @param start The index to start at (included).
	 * @param end The index to stop at (excluded).
	 * @return A Block containing elements of this from [start, end).
	 * @since JDK-21
	 */
	public Block<? extends E> subBlock(int start, int end);
	
}
