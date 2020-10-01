<style>
img {
    zoom: 0.7;
    margin: 0 auto
}
</style>

# Hoofdstuk 2: control-structures and operators

## 1. control structures

- sequencestructur: one by one execution
- selectionstructur: of / ifelse / switch
- herhalingsstructuur: whiledo / while / for

### conditional operators (ternary)

```java
System.out.printf("%s", count > 1 ? "peoples" : "people")
```

### switch

only 5 possible types to check :

- int
- short
- byte
- char
- string

### logical opearators

- `&&` -> short circuit (possibly one expression evaluates) | good to place most likely false on left
- `||` -> short circuit (possibly one expression evaluates) | good to place most likely true on left
- `&` -> NOT short circuit (both expressions evaluate)
- `|` -> NOT short circuit (both expressions evaluate)
- `^` -> XOR operator
- `!`

### break continue

- break exits out of control sturctuur (while, dowhile, for)
- continue skip to next interation control sturctuur (while, dowhile, for)

## 2. datatypes

### primitive types

- java = strongly types
- primitives each have a wrapper class
  - number types contain min and max val in their classes

<img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.geeksforgeeks.org%2Fdata-types-in-java%2F&psig=AOvVaw3cdCWTQ6YPjVU4q8cTBpAX&ust=1601616222716000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMDe8cPTkuwCFQAAAAAdAAAAABAD">

**letters and symbols**

- char = one letter or symbol always in single quotes `''`

**Byte**

- 2^8 = 256 (options we have in byte too)

**non integer numbers**

- short : 16bits only whole numbers
- float : single precision - 6 to 7 decimals accurat
- double : double precision - 15 decimals accurat (write numbers as 1000.0 not 1000)
- string formating is with `%f` for both not `%d`
  - (ex. `%20.2f` precision of 2 decimals width of 20)
  - (ex. `%,20.2f`, will place . on every thousand 1.407,10)
