# Java-Utilities v0.1.2
A collection of Java utility classes developed to simplify common operations.
These utilities are part of our new Mindforge library.

# ArrayInto
ArrayInto provides static methods for converting from one Collection to another or from a primitive array to a Collection.

# Block
Block collections are contiguous blocks of memory that hold a specific Object type. Null elements in these Blocks represent empty elements in that Block. Block implements Collection and is thread-safe.
Implementing Classes: Array, SortedArray

# PrimitiveArray
PrimitiveArrays are wrapper classes for a primitive array type. All primitive types, except char since String handles char arrays, are supported. PrimitiveArray is thread-safe.
Implementing Classes: BooleanArray, ByteArray, DoubleArray, FloatArray, IntegerArray, LongArray, ShortArray

# Tuple
Tuple class represents a group of 1 or more Objects of any type. Tuples are read-only once created and are a heterogeneous collection of Objects. Tuples are thread-safe.
