# List Interface

The List interface is a part of the collection interface that allows us to store an ordered collection of objects.

- **List**: An ordered collection of elements. A List can contain duplicate elements.
- **Set**: An unordered collection of elements that does not allow duplicates.
- **Map**: Stores elements in key-value pairs and does not allow duplicate keys.
- **Queue**: Stores elements in a FIFO (first in, first out) manner.

## ArrayList

ArrayList is an implementation of the List interface that allows duplicate elements and maintains the order of insertion.

- **Advantages**: Fast search operations.
- **Disadvantages**: When adding or removing elements, the entire list may need to be restructured.

## LinkedList

LinkedList is an implementation of the List interface that allows duplicate elements and maintains the order of insertion.

- **Advantages**: When adding, updating, or deleting elements, only the adjacent elements are affected.
- **Disadvantages**: Slower than ArrayList for search operations.
- **Use Case**: Suitable when frequent modifications to the list are required.

## Exercises

Each class should implement a program with the following functionalities: ADD, EDIT, DELETE.