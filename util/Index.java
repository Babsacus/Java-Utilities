package babs.mindforge.util;

import java.util.Objects;

/**
 * Index record represents an index or set of indices of an array or multi-dimensional array element. The index 
 * value(s) are represented by an array of integers.
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @param value The list of index values.
 * @since JDK-21
 */
public record Index(int ...value) {
	
	/**
	 * The value representing an invalid or non-existent index value.
	 */
	public static final int INVALID = -1;
	/**
	 * The maximal index value as recommended by jdk.internal.util.ArraysSupport.
	 */
	public static final int MAX = Integer.MAX_VALUE - 8;
	
	/**
	 * Constructor that creates an Index with the specified index value(s).
	 * @param value The list of index values.
	 * @throws IndexOutOfBoundsException Thrown if length of index list is out-of-bounds or if an index in the list is
	 * out-of-bounds.
	 * @throws NullPointerException Thrown if index is null.
	 * @since JDK-21
	 */
	public Index {
		Objects.requireNonNull(value);
		Objects.checkIndex(value.length, MAX);
		
		for (int i = 0; i < value.length; ++i) {
			if (value[i] < INVALID || value[i] > MAX)
				throw new IndexOutOfBoundsException("Index value at " + i + " out-of-bounds.");
		}
	}
	
}
