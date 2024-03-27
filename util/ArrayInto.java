package babs.mindforge.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * ArrayInto class provides static methods for converting an array of elements into any type of Java Collection 
 * (interface or class) in the {@link java.util} package, with the exception of Stack, SynchronousQueue, and Vector. 
 * Stack and Vector are viewed as obsolete and can be replaced with Deque and ArrayList respectively. 
 * SynchronousQueue cannot hold an array of data due to its inherent design. Static methods are also available to 
 * convert any primitive array into any type of Java Collection (interface or class).
 * 
 * @author Monroe Gordon
 * @version 0.0.0
 * @see java.util
 * @since JDK-21
 */
public class ArrayInto {
	
	/**
	 * Converts the specified array into an ArrayBlockingQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static <E> ArrayBlockingQueue<E> arrayBlockingQueue(E[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<E> ret = new ArrayBlockingQueue<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into an ArrayBlockingQueue.
	 * @param array The boolean array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Boolean> arrayBlockingQueue(boolean[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Boolean> ret = new ArrayBlockingQueue<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into an ArrayBlockingQueue.
	 * @param array The byte array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Byte> arrayBlockingQueue(byte[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Byte> ret = new ArrayBlockingQueue<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into an ArrayBlockingQueue.
	 * @param array The char array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Character> arrayBlockingQueue(char[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Character> ret = new ArrayBlockingQueue<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into an ArrayBlockingQueue.
	 * @param array The double array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Double> arrayBlockingQueue(double[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Double> ret = new ArrayBlockingQueue<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into an ArrayBlockingQueue.
	 * @param array The float array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Float> arrayBlockingQueue(float[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Float> ret = new ArrayBlockingQueue<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into an ArrayBlockingQueue.
	 * @param array The int array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Integer> arrayBlockingQueue(int[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Integer> ret = new ArrayBlockingQueue<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into an ArrayBlockingQueue.
	 * @param array The long array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Long> arrayBlockingQueue(long[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Long> ret = new ArrayBlockingQueue<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into an ArrayBlockingQueue.
	 * @param array The short array of elements to convert.
	 * @return An ArrayBlockingQueue containing the elements in array.
	 * @see ArrayBlockingQueue
	 * @since JDK-21
	 */
	public static ArrayBlockingQueue<Short> arrayBlockingQueue(short[] array) {
		if (array == null)
			return null;
		
		ArrayBlockingQueue<Short> ret = new ArrayBlockingQueue<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into an ArrayDeque.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static <E> ArrayDeque<E> arrayDeque(E[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<E> ret = new ArrayDeque<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into an ArrayDeque.
	 * @param array The boolean array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Boolean> arrayDeque(boolean[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Boolean> ret = new ArrayDeque<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into an ArrayDeque.
	 * @param array The byte array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Byte> arrayDeque(byte[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Byte> ret = new ArrayDeque<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into an ArrayDeque.
	 * @param array The char array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Character> arrayDeque(char[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Character> ret = new ArrayDeque<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into an ArrayDeque.
	 * @param array The double array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Double> arrayDeque(double[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Double> ret = new ArrayDeque<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into an ArrayDeque.
	 * @param array The float array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Float> arrayDeque(float[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Float> ret = new ArrayDeque<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into an ArrayDeque.
	 * @param array The int array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Integer> arrayDeque(int[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Integer> ret = new ArrayDeque<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into an ArrayDeque.
	 * @param array The long array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Long> arrayDeque(long[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Long> ret = new ArrayDeque<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into an ArrayDeque.
	 * @param array The short array of elements to convert.
	 * @return An ArrayDeque containing the elements in array.
	 * @see ArrayDeque
	 * @since JDK-21
	 */
	public static ArrayDeque<Short> arrayDeque(short[] array) {
		if (array == null)
			return null;
		
		ArrayDeque<Short> ret = new ArrayDeque<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into an ArrayList.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static <E> ArrayList<E> arrayList(E[] array) {
		if (array == null)
			return null;
		
		ArrayList<E> ret = new ArrayList<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into an ArrayList.
	 * @param array The boolean array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Boolean> arrayList(boolean[] array) {
		if (array == null)
			return null;
		
		ArrayList<Boolean> ret = new ArrayList<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into an ArrayList.
	 * @param array The byte array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Byte> arrayList(byte[] array) {
		if (array == null)
			return null;
		
		ArrayList<Byte> ret = new ArrayList<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into an ArrayList.
	 * @param array The char array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Character> arrayList(char[] array) {
		if (array == null)
			return null;
		
		ArrayList<Character> ret = new ArrayList<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into an ArrayList.
	 * @param array The double array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Double> arrayList(double[] array) {
		if (array == null)
			return null;
		
		ArrayList<Double> ret = new ArrayList<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into an ArrayList.
	 * @param array The float array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Float> arrayList(float[] array) {
		if (array == null)
			return null;
		
		ArrayList<Float> ret = new ArrayList<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into an ArrayList.
	 * @param array The int array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Integer> arrayList(int[] array) {
		if (array == null)
			return null;
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into an ArrayList.
	 * @param array The long array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Long> arrayList(long[] array) {
		if (array == null)
			return null;
		
		ArrayList<Long> ret = new ArrayList<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into an ArrayList.
	 * @param array The short array of elements to convert.
	 * @return An ArrayList containing the elements in array.
	 * @see ArrayList
	 * @since JDK-21
	 */
	public static ArrayList<Short> arrayList(short[] array) {
		if (array == null)
			return null;
		
		ArrayList<Short> ret = new ArrayList<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a BlockingDeque.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static <E> BlockingDeque<E> blockingDeque(E[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<E> ret = new LinkedBlockingDeque<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a BlockingDeque.
	 * @param array The boolean array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Boolean> blockingDeque(boolean[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Boolean> ret = new LinkedBlockingDeque<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a BlockingDeque.
	 * @param array The byte array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Byte> blockingDeque(byte[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Byte> ret = new LinkedBlockingDeque<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a BlockingDeque.
	 * @param array The char array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Character> blockingDeque(char[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Character> ret = new LinkedBlockingDeque<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a BlockingDeque.
	 * @param array The double array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Double> blockingDeque(double[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Double> ret = new LinkedBlockingDeque<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a BlockingDeque.
	 * @param array The float array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Float> blockingDeque(float[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Float> ret = new LinkedBlockingDeque<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a BlockingDeque.
	 * @param array The int array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Integer> blockingDeque(int[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Integer> ret = new LinkedBlockingDeque<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a BlockingDeque.
	 * @param array The long array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Long> blockingDeque(long[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Long> ret = new LinkedBlockingDeque<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a BlockingDeque.
	 * @param array The short array of elements to convert.
	 * @return A BlockingDeque containing the elements in array.
	 * @see BlockingDeque
	 * @since JDK-21
	 */
	public static BlockingDeque<Short> blockingDeque(short[] array) {
		if (array == null)
			return null;
		
		BlockingDeque<Short> ret = new LinkedBlockingDeque<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a BlockingQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static <E> BlockingQueue<E> blockingQueue(E[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<E> ret = new ArrayBlockingQueue<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a BlockingQueue.
	 * @param array The boolean array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Boolean> blockingQueue(boolean[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Boolean> ret = new ArrayBlockingQueue<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a BlockingQueue.
	 * @param array The byte array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Byte> blockingQueue(byte[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Byte> ret = new ArrayBlockingQueue<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a BlockingQueue.
	 * @param array The char array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Character> blockingQueue(char[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Character> ret = new ArrayBlockingQueue<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a BlockingQueue.
	 * @param array The double array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Double> blockingQueue(double[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Double> ret = new ArrayBlockingQueue<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a BlockingQueue.
	 * @param array The float array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Float> blockingQueue(float[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Float> ret = new ArrayBlockingQueue<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a BlockingQueue.
	 * @param array The int array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Integer> blockingQueue(int[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Integer> ret = new ArrayBlockingQueue<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a BlockingQueue.
	 * @param array The long array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Long> blockingQueue(long[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Long> ret = new ArrayBlockingQueue<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a BlockingQueue.
	 * @param array The short array of elements to convert.
	 * @return A BlockingQueue containing the elements in array.
	 * @see BlockingQueue
	 * @since JDK-21
	 */
	public static BlockingQueue<Short> blockingQueue(short[] array) {
		if (array == null)
			return null;
		
		BlockingQueue<Short> ret = new ArrayBlockingQueue<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a Collection.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static <E> Collection<E> collection(E[] array) {
		if (array == null)
			return null;
		
		Collection<E> ret = new ArrayList<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a Collection.
	 * @param array The boolean array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Boolean> collection(boolean[] array) {
		if (array == null)
			return null;
		
		Collection<Boolean> ret = new ArrayList<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a Collection.
	 * @param array The byte array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Byte> collection(byte[] array) {
		if (array == null)
			return null;
		
		Collection<Byte> ret = new ArrayList<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a Collection.
	 * @param array The char array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Character> collection(char[] array) {
		if (array == null)
			return null;
		
		Collection<Character> ret = new ArrayList<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a Collection.
	 * @param array The double array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Double> collection(double[] array) {
		if (array == null)
			return null;
		
		Collection<Double> ret = new ArrayList<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a Collection.
	 * @param array The float array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Float> collection(float[] array) {
		if (array == null)
			return null;
		
		Collection<Float> ret = new ArrayList<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a Collection.
	 * @param array The int array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Integer> collection(int[] array) {
		if (array == null)
			return null;
		
		Collection<Integer> ret = new ArrayList<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a Collection.
	 * @param array The long array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Long> collection(long[] array) {
		if (array == null)
			return null;
		
		Collection<Long> ret = new ArrayList<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a Collection.
	 * @param array The short array of elements to convert.
	 * @return A Collection containing the elements in array.
	 * @see Collection
	 * @since JDK-21
	 */
	public static Collection<Short> collection(short[] array) {
		if (array == null)
			return null;
		
		Collection<Short> ret = new ArrayList<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a ConcurrentLinkedDeque.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static <E> ConcurrentLinkedDeque<E> concurrentLinkedDeque(E[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<E> ret = new ConcurrentLinkedDeque<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a ConcurrentLinkedDeque.
	 * @param array The boolean array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Boolean> concurrentLinkedDeque(boolean[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Boolean> ret = new ConcurrentLinkedDeque<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a ConcurrentLinkedDeque.
	 * @param array The byte array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Byte> concurrentLinkedDeque(byte[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Byte> ret = new ConcurrentLinkedDeque<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a ConcurrentLinkedDeque.
	 * @param array The char array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Character> concurrentLinkedDeque(char[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Character> ret = new ConcurrentLinkedDeque<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a ConcurrentLinkedDeque.
	 * @param array The double array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Double> concurrentLinkedDeque(double[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Double> ret = new ConcurrentLinkedDeque<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a ConcurrentLinkedDeque.
	 * @param array The float array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Float> concurrentLinkedDeque(float[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Float> ret = new ConcurrentLinkedDeque<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a ConcurrentLinkedDeque.
	 * @param array The int array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Integer> concurrentLinkedDeque(int[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Integer> ret = new ConcurrentLinkedDeque<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a ConcurrentLinkedDeque.
	 * @param array The long array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Long> concurrentLinkedDeque(long[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Long> ret = new ConcurrentLinkedDeque<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a ConcurrentLinkedDeque.
	 * @param array The short array of elements to convert.
	 * @return A ConcurrentLinkedDeque containing the elements in array.
	 * @see ConcurrentLinkedDeque
	 * @since JDK-21
	 */
	public static ConcurrentLinkedDeque<Short> concurrentLinkedDeque(short[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedDeque<Short> ret = new ConcurrentLinkedDeque<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a ConcurrentLinkedQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static <E> ConcurrentLinkedQueue<E> concurrentLinkedQueue(E[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<E> ret = new ConcurrentLinkedQueue<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a ConcurrentLinkedQueue.
	 * @param array The boolean array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Boolean> concurrentLinkedQueue(boolean[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Boolean> ret = new ConcurrentLinkedQueue<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a ConcurrentLinkedQueue.
	 * @param array The byte array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Byte> concurrentLinkedQueue(byte[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Byte> ret = new ConcurrentLinkedQueue<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a ConcurrentLinkedQueue.
	 * @param array The char array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Character> concurrentLinkedQueue(char[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Character> ret = new ConcurrentLinkedQueue<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a ConcurrentLinkedQueue.
	 * @param array The double array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Double> concurrentLinkedQueue(double[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Double> ret = new ConcurrentLinkedQueue<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a ConcurrentLinkedQueue.
	 * @param array The float array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Float> concurrentLinkedQueue(float[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Float> ret = new ConcurrentLinkedQueue<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a ConcurrentLinkedQueue.
	 * @param array The int array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue(int[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Integer> ret = new ConcurrentLinkedQueue<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a ConcurrentLinkedQueue.
	 * @param array The long array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Long> concurrentLinkedQueue(long[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Long> ret = new ConcurrentLinkedQueue<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a ConcurrentLinkedQueue.
	 * @param array The short array of elements to convert.
	 * @return A ConcurrentLinkedQueue containing the elements in array.
	 * @see ConcurrentLinkedQueue
	 * @since JDK-21
	 */
	public static ConcurrentLinkedQueue<Short> concurrentLinkedQueue(short[] array) {
		if (array == null)
			return null;
		
		ConcurrentLinkedQueue<Short> ret = new ConcurrentLinkedQueue<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a ConcurrentSkipListSet.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static <E> ConcurrentSkipListSet<E> concurrentSkipListSet(E[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<E> ret = new ConcurrentSkipListSet<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a ConcurrentSkipListSet.
	 * @param array The boolean array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Boolean> concurrentSkipListSet(boolean[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Boolean> ret = new ConcurrentSkipListSet<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a ConcurrentSkipListSet.
	 * @param array The byte array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Byte> concurrentSkipListSet(byte[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Byte> ret = new ConcurrentSkipListSet<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a ConcurrentSkipListSet.
	 * @param array The char array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Character> concurrentSkipListSet(char[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Character> ret = new ConcurrentSkipListSet<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a ConcurrentSkipListSet.
	 * @param array The double array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Double> concurrentSkipListSet(double[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Double> ret = new ConcurrentSkipListSet<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a ConcurrentSkipListSet.
	 * @param array The float array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Float> concurrentSkipListSet(float[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Float> ret = new ConcurrentSkipListSet<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a ConcurrentSkipListSet.
	 * @param array The int array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Integer> concurrentSkipListSet(int[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Integer> ret = new ConcurrentSkipListSet<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a ConcurrentSkipListSet.
	 * @param array The long array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Long> concurrentSkipListSet(long[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Long> ret = new ConcurrentSkipListSet<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a ConcurrentSkipListSet.
	 * @param array The short array of elements to convert.
	 * @return A ConcurrentSkipListSet containing the elements in array.
	 * @see ConcurrentSkipListSet
	 * @since JDK-21
	 */
	public static ConcurrentSkipListSet<Short> concurrentSkipListSet(short[] array) {
		if (array == null)
			return null;
		
		ConcurrentSkipListSet<Short> ret = new ConcurrentSkipListSet<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a CopyOnWriteArrayList.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static <E> CopyOnWriteArrayList<E> copyOnWriteArrayList(E[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<E> ret = new CopyOnWriteArrayList<E>(array);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a CopyOnWriteArrayList.
	 * @param array The boolean array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Boolean> copyOnWriteArrayList(boolean[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Boolean> ret = new CopyOnWriteArrayList<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a CopyOnWriteArrayList.
	 * @param array The byte array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Byte> copyOnWriteArrayList(byte[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Byte> ret = new CopyOnWriteArrayList<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a CopyOnWriteArrayList.
	 * @param array The char array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Character> copyOnWriteArrayList(char[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Character> ret = new CopyOnWriteArrayList<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a CopyOnWriteArrayList.
	 * @param array The double array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Double> copyOnWriteArrayList(double[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Double> ret = new CopyOnWriteArrayList<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a CopyOnWriteArrayList.
	 * @param array The float array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Float> copyOnWriteArrayList(float[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Float> ret = new CopyOnWriteArrayList<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a CopyOnWriteArrayList.
	 * @param array The int array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Integer> copyOnWriteArrayList(int[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Integer> ret = new CopyOnWriteArrayList<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a CopyOnWriteArrayList.
	 * @param array The long array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Long> copyOnWriteArrayList(long[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Long> ret = new CopyOnWriteArrayList<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a CopyOnWriteArrayList.
	 * @param array The short array of elements to convert.
	 * @return A CopyOnWriteArrayList containing the elements in array.
	 * @see CopyOnWriteArrayList
	 * @since JDK-21
	 */
	public static CopyOnWriteArrayList<Short> copyOnWriteArrayList(short[] array) {
		if (array == null)
			return null;
		
		CopyOnWriteArrayList<Short> ret = new CopyOnWriteArrayList<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a DelayQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A DelayQueue containing the elements in array.
	 * @see DelayQueue
	 * @since JDK-21
	 */
	public static <E extends Delayed> DelayQueue<E> delayQueue(E[] array) {
		if (array == null)
			return null;
		
		DelayQueue<E> ret = new DelayQueue<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a Deque.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static <E> Deque<E> deque(E[] array) {
		if (array == null)
			return null;
		
		Deque<E> ret = new ArrayDeque<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a Deque.
	 * @param array The boolean array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Boolean> deque(boolean[] array) {
		if (array == null)
			return null;
		
		Deque<Boolean> ret = new ArrayDeque<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a Deque.
	 * @param array The byte array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Byte> deque(byte[] array) {
		if (array == null)
			return null;
		
		Deque<Byte> ret = new ArrayDeque<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a Deque.
	 * @param array The char array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Character> deque(char[] array) {
		if (array == null)
			return null;
		
		Deque<Character> ret = new ArrayDeque<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a Deque.
	 * @param array The double array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Double> deque(double[] array) {
		if (array == null)
			return null;
		
		Deque<Double> ret = new ArrayDeque<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a Deque.
	 * @param array The float array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Float> deque(float[] array) {
		if (array == null)
			return null;
		
		Deque<Float> ret = new ArrayDeque<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a Deque.
	 * @param array The int array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Integer> deque(int[] array) {
		if (array == null)
			return null;
		
		Deque<Integer> ret = new ArrayDeque<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a Deque.
	 * @param array The long array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Long> deque(long[] array) {
		if (array == null)
			return null;
		
		Deque<Long> ret = new ArrayDeque<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a Deque.
	 * @param array The short array of elements to convert.
	 * @return A Deque containing the elements in array.
	 * @see Deque
	 * @since JDK-21
	 */
	public static Deque<Short> deque(short[] array) {
		if (array == null)
			return null;
		
		Deque<Short> ret = new ArrayDeque<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a EnumSet.
	 * @param <E> The Enum element type.
	 * @param array The array of elements to convert.
	 * @return A EnumSet containing the elements in array.
	 * @see Enum
	 * @see EnumSet
	 * @since JDK-21
	 */
	public static <E extends Enum<E>> EnumSet<E> enumSet(E[] array) {
		if (array == null)
			return null;
		
		EnumSet<E> ret = EnumSet.copyOf(ArrayInto.collection(array));
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a HashSet.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static <E> HashSet<E> hashSet(E[] array) {
		if (array == null)
			return null;
		
		HashSet<E> ret = new HashSet<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a HashSet.
	 * @param array The boolean array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Boolean> hashSet(boolean[] array) {
		if (array == null)
			return null;
		
		HashSet<Boolean> ret = new HashSet<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a HashSet.
	 * @param array The byte array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Byte> hashSet(byte[] array) {
		if (array == null)
			return null;
		
		HashSet<Byte> ret = new HashSet<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a HashSet.
	 * @param array The char array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Character> hashSet(char[] array) {
		if (array == null)
			return null;
		
		HashSet<Character> ret = new HashSet<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a HashSet.
	 * @param array The double array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Double> hashSet(double[] array) {
		if (array == null)
			return null;
		
		HashSet<Double> ret = new HashSet<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a HashSet.
	 * @param array The float array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Float> hashSet(float[] array) {
		if (array == null)
			return null;
		
		HashSet<Float> ret = new HashSet<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a HashSet.
	 * @param array The int array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Integer> hashSet(int[] array) {
		if (array == null)
			return null;
		
		HashSet<Integer> ret = new HashSet<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a HashSet.
	 * @param array The long array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Long> hashSet(long[] array) {
		if (array == null)
			return null;
		
		HashSet<Long> ret = new HashSet<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a HashSet.
	 * @param array The short array of elements to convert.
	 * @return A HashSet containing the elements in array.
	 * @see HashSet
	 * @since JDK-21
	 */
	public static HashSet<Short> hashSet(short[] array) {
		if (array == null)
			return null;
		
		HashSet<Short> ret = new HashSet<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a LinkedBlockingDeque.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static <E> LinkedBlockingDeque<E> linkedBlockingDeque(E[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<E> ret = new LinkedBlockingDeque<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a LinkedBlockingDeque.
	 * @param array The boolean array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Boolean> linkedBlockingDeque(boolean[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Boolean> ret = new LinkedBlockingDeque<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a LinkedBlockingDeque.
	 * @param array The byte array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Byte> linkedBlockingDeque(byte[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Byte> ret = new LinkedBlockingDeque<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a LinkedBlockingDeque.
	 * @param array The char array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Character> linkedBlockingDeque(char[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Character> ret = new LinkedBlockingDeque<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a LinkedBlockingDeque.
	 * @param array The double array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Double> linkedBlockingDeque(double[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Double> ret = new LinkedBlockingDeque<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a LinkedBlockingDeque.
	 * @param array The float array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Float> linkedBlockingDeque(float[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Float> ret = new LinkedBlockingDeque<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a LinkedBlockingDeque.
	 * @param array The int array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Integer> linkedBlockingDeque(int[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Integer> ret = new LinkedBlockingDeque<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a LinkedBlockingDeque.
	 * @param array The long array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Long> linkedBlockingDeque(long[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Long> ret = new LinkedBlockingDeque<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a LinkedBlockingDeque.
	 * @param array The short array of elements to convert.
	 * @return A LinkedBlockingDeque containing the elements in array.
	 * @see LinkedBlockingDeque
	 * @since JDK-21
	 */
	public static LinkedBlockingDeque<Short> linkedBlockingDeque(short[] array) {
		if (array == null)
			return null;
		
		LinkedBlockingDeque<Short> ret = new LinkedBlockingDeque<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a LinkedHashSet.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static <E> LinkedHashSet<E> linkedHashSet(E[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<E> ret = new LinkedHashSet<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a LinkedHashSet.
	 * @param array The boolean array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Boolean> linkedHashSet(boolean[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Boolean> ret = new LinkedHashSet<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a LinkedHashSet.
	 * @param array The byte array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Byte> linkedHashSet(byte[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Byte> ret = new LinkedHashSet<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a LinkedHashSet.
	 * @param array The char array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Character> linkedHashSet(char[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Character> ret = new LinkedHashSet<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a LinkedHashSet.
	 * @param array The double array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Double> linkedHashSet(double[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Double> ret = new LinkedHashSet<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a LinkedHashSet.
	 * @param array The float array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Float> linkedHashSet(float[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Float> ret = new LinkedHashSet<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a LinkedHashSet.
	 * @param array The int array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Integer> linkedHashSet(int[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Integer> ret = new LinkedHashSet<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a LinkedHashSet.
	 * @param array The long array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Long> linkedHashSet(long[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Long> ret = new LinkedHashSet<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a LinkedHashSet.
	 * @param array The short array of elements to convert.
	 * @return A LinkedHashSet containing the elements in array.
	 * @see LinkedHashSet
	 * @since JDK-21
	 */
	public static LinkedHashSet<Short> linkedHashSet(short[] array) {
		if (array == null)
			return null;
		
		LinkedHashSet<Short> ret = new LinkedHashSet<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a LinkedList.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static <E> LinkedList<E> linkedList(E[] array) {
		if (array == null)
			return null;
		
		LinkedList<E> ret = new LinkedList<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a LinkedList.
	 * @param array The boolean array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Boolean> linkedList(boolean[] array) {
		if (array == null)
			return null;
		
		LinkedList<Boolean> ret = new LinkedList<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a LinkedList.
	 * @param array The byte array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Byte> linkedList(byte[] array) {
		if (array == null)
			return null;
		
		LinkedList<Byte> ret = new LinkedList<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a LinkedList.
	 * @param array The char array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Character> linkedList(char[] array) {
		if (array == null)
			return null;
		
		LinkedList<Character> ret = new LinkedList<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a LinkedList.
	 * @param array The double array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Double> linkedList(double[] array) {
		if (array == null)
			return null;
		
		LinkedList<Double> ret = new LinkedList<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a LinkedList.
	 * @param array The float array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Float> linkedList(float[] array) {
		if (array == null)
			return null;
		
		LinkedList<Float> ret = new LinkedList<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a LinkedList.
	 * @param array The int array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Integer> linkedList(int[] array) {
		if (array == null)
			return null;
		
		LinkedList<Integer> ret = new LinkedList<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a LinkedList.
	 * @param array The long array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Long> linkedList(long[] array) {
		if (array == null)
			return null;
		
		LinkedList<Long> ret = new LinkedList<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a LinkedList.
	 * @param array The short array of elements to convert.
	 * @return A LinkedList containing the elements in array.
	 * @see LinkedList
	 * @since JDK-21
	 */
	public static LinkedList<Short> linkedList(short[] array) {
		if (array == null)
			return null;
		
		LinkedList<Short> ret = new LinkedList<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a LinkedTransferQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static <E> LinkedTransferQueue<E> linkedTransferQueue(E[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<E> ret = new LinkedTransferQueue<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a LinkedTransferQueue.
	 * @param array The boolean array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Boolean> linkedTransferQueue(boolean[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Boolean> ret = new LinkedTransferQueue<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a LinkedTransferQueue.
	 * @param array The byte array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Byte> linkedTransferQueue(byte[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Byte> ret = new LinkedTransferQueue<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a LinkedTransferQueue.
	 * @param array The char array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Character> linkedTransferQueue(char[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Character> ret = new LinkedTransferQueue<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a LinkedTransferQueue.
	 * @param array The double array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Double> linkedTransferQueue(double[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Double> ret = new LinkedTransferQueue<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a LinkedTransferQueue.
	 * @param array The float array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Float> linkedTransferQueue(float[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Float> ret = new LinkedTransferQueue<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a LinkedTransferQueue.
	 * @param array The int array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Integer> linkedTransferQueue(int[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Integer> ret = new LinkedTransferQueue<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a LinkedTransferQueue.
	 * @param array The long array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Long> linkedTransferQueue(long[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Long> ret = new LinkedTransferQueue<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a LinkedTransferQueue.
	 * @param array The short array of elements to convert.
	 * @return A LinkedTransferQueue containing the elements in array.
	 * @see LinkedTransferQueue
	 * @since JDK-21
	 */
	public static LinkedTransferQueue<Short> linkedTransferQueue(short[] array) {
		if (array == null)
			return null;
		
		LinkedTransferQueue<Short> ret = new LinkedTransferQueue<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a List.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static <E> List<E> list(E[] array) {
		if (array == null)
			return null;
		
		List<E> ret = new ArrayList<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a List.
	 * @param array The boolean array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Boolean> list(boolean[] array) {
		if (array == null)
			return null;
		
		List<Boolean> ret = new ArrayList<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a List.
	 * @param array The byte array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Byte> list(byte[] array) {
		if (array == null)
			return null;
		
		List<Byte> ret = new ArrayList<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a List.
	 * @param array The char array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Character> list(char[] array) {
		if (array == null)
			return null;
		
		List<Character> ret = new ArrayList<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a List.
	 * @param array The double array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Double> list(double[] array) {
		if (array == null)
			return null;
		
		List<Double> ret = new ArrayList<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a List.
	 * @param array The float array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Float> list(float[] array) {
		if (array == null)
			return null;
		
		List<Float> ret = new ArrayList<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a List.
	 * @param array The int array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Integer> list(int[] array) {
		if (array == null)
			return null;
		
		List<Integer> ret = new ArrayList<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a List.
	 * @param array The long array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Long> list(long[] array) {
		if (array == null)
			return null;
		
		List<Long> ret = new ArrayList<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a List.
	 * @param array The short array of elements to convert.
	 * @return A List containing the elements in array.
	 * @see List
	 * @since JDK-21
	 */
	public static List<Short> list(short[] array) {
		if (array == null)
			return null;
		
		List<Short> ret = new ArrayList<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a PriorityBlockingQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static <E> PriorityBlockingQueue<E> priorityBlockingQueue(E[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<E> ret = new PriorityBlockingQueue<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a PriorityBlockingQueue.
	 * @param array The boolean array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Boolean> priorityBlockingQueue(boolean[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Boolean> ret = new PriorityBlockingQueue<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a PriorityBlockingQueue.
	 * @param array The byte array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Byte> priorityBlockingQueue(byte[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Byte> ret = new PriorityBlockingQueue<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a PriorityBlockingQueue.
	 * @param array The char array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Character> priorityBlockingQueue(char[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Character> ret = new PriorityBlockingQueue<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a PriorityBlockingQueue.
	 * @param array The double array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Double> priorityBlockingQueue(double[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Double> ret = new PriorityBlockingQueue<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a PriorityBlockingQueue.
	 * @param array The float array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Float> priorityBlockingQueue(float[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Float> ret = new PriorityBlockingQueue<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a PriorityBlockingQueue.
	 * @param array The int array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Integer> priorityBlockingQueue(int[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Integer> ret = new PriorityBlockingQueue<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a PriorityBlockingQueue.
	 * @param array The long array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Long> priorityBlockingQueue(long[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Long> ret = new PriorityBlockingQueue<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a PriorityBlockingQueue.
	 * @param array The short array of elements to convert.
	 * @return A PriorityBlockingQueue containing the elements in array.
	 * @see PriorityBlockingQueue
	 * @since JDK-21
	 */
	public static PriorityBlockingQueue<Short> priorityBlockingQueue(short[] array) {
		if (array == null)
			return null;
		
		PriorityBlockingQueue<Short> ret = new PriorityBlockingQueue<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a PriorityQueue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static <E> PriorityQueue<E> priorityQueue(E[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<E> ret = new PriorityQueue<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a PriorityQueue.
	 * @param array The boolean array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Boolean> priorityQueue(boolean[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Boolean> ret = new PriorityQueue<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a PriorityQueue.
	 * @param array The byte array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Byte> priorityQueue(byte[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Byte> ret = new PriorityQueue<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a PriorityQueue.
	 * @param array The char array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Character> priorityQueue(char[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Character> ret = new PriorityQueue<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a PriorityQueue.
	 * @param array The double array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Double> priorityQueue(double[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Double> ret = new PriorityQueue<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a PriorityQueue.
	 * @param array The float array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Float> priorityQueue(float[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Float> ret = new PriorityQueue<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a PriorityQueue.
	 * @param array The int array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Integer> priorityQueue(int[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Integer> ret = new PriorityQueue<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a PriorityQueue.
	 * @param array The long array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Long> priorityQueue(long[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Long> ret = new PriorityQueue<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a PriorityQueue.
	 * @param array The short array of elements to convert.
	 * @return A PriorityQueue containing the elements in array.
	 * @see PriorityQueue
	 * @since JDK-21
	 */
	public static PriorityQueue<Short> priorityQueue(short[] array) {
		if (array == null)
			return null;
		
		PriorityQueue<Short> ret = new PriorityQueue<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a Queue.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static <E> Queue<E> queue(E[] array) {
		if (array == null)
			return null;
		
		Queue<E> ret = new ArrayDeque<E>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a Queue.
	 * @param array The boolean array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Boolean> queue(boolean[] array) {
		if (array == null)
			return null;
		
		Queue<Boolean> ret = new ArrayDeque<Boolean>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a Queue.
	 * @param array The byte array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Byte> queue(byte[] array) {
		if (array == null)
			return null;
		
		Queue<Byte> ret = new ArrayDeque<Byte>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a Queue.
	 * @param array The char array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Character> queue(char[] array) {
		if (array == null)
			return null;
		
		Queue<Character> ret = new ArrayDeque<Character>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a Queue.
	 * @param array The double array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Double> queue(double[] array) {
		if (array == null)
			return null;
		
		Queue<Double> ret = new ArrayDeque<Double>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a Queue.
	 * @param array The float array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Float> queue(float[] array) {
		if (array == null)
			return null;
		
		Queue<Float> ret = new ArrayDeque<Float>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a Queue.
	 * @param array The int array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Integer> queue(int[] array) {
		if (array == null)
			return null;
		
		Queue<Integer> ret = new ArrayDeque<Integer>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a Queue.
	 * @param array The long array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Long> queue(long[] array) {
		if (array == null)
			return null;
		
		Queue<Long> ret = new ArrayDeque<Long>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a Queue.
	 * @param array The short array of elements to convert.
	 * @return A Queue containing the elements in array.
	 * @see Queue
	 * @since JDK-21
	 */
	public static Queue<Short> queue(short[] array) {
		if (array == null)
			return null;
		
		Queue<Short> ret = new ArrayDeque<Short>(array.length);
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a Set.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static <E> Set<E> set(E[] array) {
		if (array == null)
			return null;
		
		Set<E> ret = new HashSet<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a Set.
	 * @param array The boolean array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Boolean> set(boolean[] array) {
		if (array == null)
			return null;
		
		Set<Boolean> ret = new HashSet<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a Set.
	 * @param array The byte array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Byte> set(byte[] array) {
		if (array == null)
			return null;
		
		Set<Byte> ret = new HashSet<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a Set.
	 * @param array The char array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Character> set(char[] array) {
		if (array == null)
			return null;
		
		Set<Character> ret = new HashSet<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a Set.
	 * @param array The double array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Double> set(double[] array) {
		if (array == null)
			return null;
		
		Set<Double> ret = new HashSet<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a Set.
	 * @param array The float array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Float> set(float[] array) {
		if (array == null)
			return null;
		
		Set<Float> ret = new HashSet<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a Set.
	 * @param array The int array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Integer> set(int[] array) {
		if (array == null)
			return null;
		
		Set<Integer> ret = new HashSet<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a Set.
	 * @param array The long array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Long> set(long[] array) {
		if (array == null)
			return null;
		
		Set<Long> ret = new HashSet<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a Set.
	 * @param array The short array of elements to convert.
	 * @return A Set containing the elements in array.
	 * @see Set
	 * @since JDK-21
	 */
	public static Set<Short> set(short[] array) {
		if (array == null)
			return null;
		
		Set<Short> ret = new HashSet<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified array into a TreeSet.
	 * @param <E> The element type.
	 * @param array The array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static <E> TreeSet<E> treeSet(E[] array) {
		if (array == null)
			return null;
		
		TreeSet<E> ret = new TreeSet<E>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified boolean array into a TreeSet.
	 * @param array The boolean array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Boolean> treeSet(boolean[] array) {
		if (array == null)
			return null;
		
		TreeSet<Boolean> ret = new TreeSet<Boolean>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified byte array into a TreeSet.
	 * @param array The byte array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Byte> treeSet(byte[] array) {
		if (array == null)
			return null;
		
		TreeSet<Byte> ret = new TreeSet<Byte>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified char array into a TreeSet.
	 * @param array The char array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Character> treeSet(char[] array) {
		if (array == null)
			return null;
		
		TreeSet<Character> ret = new TreeSet<Character>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified double array into a TreeSet.
	 * @param array The double array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Double> treeSet(double[] array) {
		if (array == null)
			return null;
		
		TreeSet<Double> ret = new TreeSet<Double>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified float array into a TreeSet.
	 * @param array The float array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Float> treeSet(float[] array) {
		if (array == null)
			return null;
		
		TreeSet<Float> ret = new TreeSet<Float>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified int array into a TreeSet.
	 * @param array The int array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Integer> treeSet(int[] array) {
		if (array == null)
			return null;
		
		TreeSet<Integer> ret = new TreeSet<Integer>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified long array into a TreeSet.
	 * @param array The long array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Long> treeSet(long[] array) {
		if (array == null)
			return null;
		
		TreeSet<Long> ret = new TreeSet<Long>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
	/**
	 * Converts the specified short array into a TreeSet.
	 * @param array The short array of elements to convert.
	 * @return A TreeSet containing the elements in array.
	 * @see TreeSet
	 * @since JDK-21
	 */
	public static TreeSet<Short> treeSet(short[] array) {
		if (array == null)
			return null;
		
		TreeSet<Short> ret = new TreeSet<Short>();
		
		for (int i = 0; i < array.length; ++i)
			ret.add(array[i]);
		
		return ret;
	}
	
}
