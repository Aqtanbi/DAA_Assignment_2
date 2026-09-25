# **Assignment 2**
### Course: Design and analysis of algorithms
### Group: SE-2539
### Full name: Aktanbi Kusman
# Implementation of Dynamic Array data structure:
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

# Implementation of Linked List data structure

In this part of Assignment 2, I implemented a Linked List data structure using Java.

The purpose of this implementation is to understand how a linked list stores elements using nodes and references, and how it performs basic operations.

The Linked List was implemented without using Java's built-in collection classes.

### Implemented Operations

`add(int x)` - Adds an element to the end of the list.

`add(int index, int x)` - Inserts an element at a chosen index.

`remove(int index)` - Removes an element at a specified index.

`get(int index)` - Returns the element at a specified index.

`contains(int x)` - Checks whether the list contains a given element.

`checkIndex(int index)` - Checks whether an index is valid.

`getSize()` - Returns the number of elements stored in the list.

### Internal Structure

LinkedList uses the following fields and components:

* `Node` - A private static class that represents an individual element in the linked list.
* `data` - An integer value stored inside each node.
* `next` - A reference to the next node in the list.
* `head` - A reference to the first node in the list.
* `size` - The number of elements currently stored in the list.

Each node stores an integer value and a reference to the next node. The last node points to `null`, which indicates the end of the list.

The `head` reference is `null` when the list is empty.

### Implementation Details

The Linked List uses a singly linked structure, where each node points to the next node.

To access or modify an element at a specific index, the implementation traverses the list starting from the head.

When inserting an element, the new node is connected to the appropriate position by updating references.

When removing an element, the reference of the previous node is updated to skip the removed node.

The `size` variable is updated after each insertion and removal operation.
