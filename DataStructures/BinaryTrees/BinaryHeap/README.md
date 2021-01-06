# Binary Heap Tree


## Types

**Max** every parent is greater than or equal to its children

**Min** every parent is less than or equal to its children

## Reqs

must satisfy heap property (max | min)

must be complete tree

## Info


the max or min will always be at the root of the tree

no required order of siblings - sibling nodes can be out of order

children are added left to right

last child if not full is as far left as possible

heapify - converting binary tree to heap after insert or delete of node

-> compare new item against parent, if item > parent we swap it, and repeat

usually implemented as arrays

## Array Heap

[22, 19, 18, 15, 3, 14]

root = 22
leftChild = 19
rightChild = 18

2nd level

left child of 19 = 15
right child of 19 = 3

left child of 18 = 14



for node at array[i]

left child = 2i + 1
right child = 2i + 2
parent = floor((i - 1) / 2)


add new items to end of tree and then heapify


## Wikipedia copy/paste

**Heapsort**: One of the best sorting methods being in-place and with no quadratic worst-case scenarios.
**Selection algorithms**: A heap allows access to the min or max element in constant time, and other selections (such as median or kth-element) can be done in sub-linear time on data that is in a heap.
**Graph algorithms**: By using heaps as internal traversal data structures, run time will be reduced by polynomial order. Examples of such problems are Prim's minimal-spanning-tree algorithm and Dijkstra's shortest-path algorithm.
**Priority Queue**: A priority queue is an abstract concept like "a list" or "a map"; just as a list can be implemented with a linked list or an array, a priority queue can be implemented with a heap or a variety of other methods.
**K-way merge**: A heap data structure is useful to merge many already-sorted input streams into a single sorted output stream. Examples of the need for merging include external sorting and streaming results from distributed data such as a log structured merge tree. The inner loop is obtaining the min element, replacing with the next element for the corresponding input stream, then doing a sift-down heap operation. (Alternatively the replace function.) (Using extract-max and insert functions of a priority queue are much less efficient.)
**Order statistics**: The Heap data structure can be used to efficiently find the kth smallest (or largest) element in an array.