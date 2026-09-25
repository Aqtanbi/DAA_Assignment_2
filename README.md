# **Assignment 2**
### Course: Design and analysis of algorithms
### Group: SE-2539
### Full name: Aktanbi Kusman
## Implementation of Dynamic Array data structure:
In this part of Assignment 2, I implemented a Dynamic Array data structure using Java.

The purpose of this implementation is to understand how a dynamic array stores elements, manages its size and capacity, and performs basic operations.

The Dynamic Array was implemented without using Java's built-in collection classes.

`add(int x)` - Adds an elements to the end of array.

`add(int index, int x)` - Inserts an elements at a chosed index.

`remove(int index)` - removes an element at a chosed index.

`get(int index)` - returns the lement at a specified index.

`contains(int x)` - Checks whether the array contains a given element.

`resize()` - increases the capacity of the array when it becomes full.

`checkIndex(int index)` - checks whether an index is valid.

## Internal structure:

DynamicArray uses the following fields:
* `data` -an integer array that stores the elements.
* `size` - the number of elements stored in internal array
* `capacity` - the total number of elements that the internal array can hold

## Current Progress

The basic Dynamic Array implementation and a simple test in the `Main` class have been completed.

Further work will include testing boundary cases, analyzing the time and space complexity of each operation, and implementing the Linked List and Min-Heap data structures.