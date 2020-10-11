<style>
img {
    zoom: 0.7;
    margin: 0 auto
}
</style>

# Hoofdstuk 5: ArrayList && arrays

> datastructures discussed here always contain objects of same type

## 1. ArrayList

- Dynamic List (can change size)
- Duplication possible
- `ArrayList<E> - implementation of -> List<E> - subinterface of -> Collection<E> --> Iterable `
- elements inside of arrayList cannot be primitives they always have to be Classes Double instead of Double

Methods :
* add
* set
* get
* remove
* contains
* size
* indexOf

Enchanced for loop -- to iterate through elements in collection 
> when using Integer in this loop it gets auto converted to int via **autoboxing**
> this will only allow for reading the elements 

```java
for (param : name collection)
  statement
```

## 2. Array

- is **static** so it cannot change in size dynamicly 
- objects which can be used and passed like other objects 

Methods : 
* length instead of size() (because it does not need to be calculated)
  * **final** attribute makes it so we cannot adjust it 
* [] to get element at index 

```java
// each element gets auto initialized 
// to zero at creation if they are int type
// to false at creation if they are boolean type
// to null at creation if they are object type
int c[] = new int[ 12 ];
int[] a, b, c;
// or 
int a[], b[], c[];
// new not necessary jsut as length is not 
int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37}; 
```

Enchanced for loop -- to iterate through elements in collection (out of bounds exception is avoided)
Regular for loop -- to change elements during iteration


## 3. NestedArray

```java
int[][] b = new int[ 3 ][ 4 ];
```