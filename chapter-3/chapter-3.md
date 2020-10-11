<style>
img {
    zoom: 0.7;
    margin: 0 auto
}
</style>

# Hoofdstuk 3: klasses and objects

## 1. key concepts 

- object = a representation of real world objects the y can be **distinguished** / have their own **characteristics** and **behaviour**
  - behaviour can change depending on situation
- abstraction = hiding implementation details behind an interface
- class = blueprint for objects it has the description of **characteristics and behaviour**

> class abstract description vs object or instance  concrete implementation **instance**

 
### 2. characteristics of objects 

- **state** 
  - characteristics are represented by **attributes** which are created via  **name** | **type** 
  - all attributes combined wioth their actual value attached represent the state  
  - attribute values can change over time and can change from object to object
  - **property in UML** auto use getters and setters for attribute
- behaviour
  - behaviour is implemented via **methods**
  - method **signature** determines how object beviour is implemented it includes
    - **name**
    - **parameters**
    - **return** type
  - **getters** and **setters** 
    - getters let us get a value from a specific attribute
    - setters let us set a value from a specific attribute
  - **overloading** = equaly named methods but taking different parameters 
- identity = unique identifier assigned to each object upon creation
  - **constructors** = method which instantiates an object 
    - has a signature with name | parameters | NO return type 
    - mostly used by using new operator 
    - object attributes can be defined during construction 

```java

// public - visible for other classes in jvm
// class - reserved keyword
public class StarDestroyer {
  private int turretCount, height, width;
  private String name;
  private boolean isRebel; 

  public StarDestroyer(int turretCount) {
    setTurretCount(turretCount)
  }

  public int StarDestroyer(int turretCount) {
    setTurretCount(turretCount)
  }

  public int callConstructorInternaly(int turretCount) {
    this(10)
  }

  public int getTurretCount() {
    return this.turretCount
  }

  public int setTurretCount(int count) {
    if(count >= 1){
      this.turretCoun = count
    }
  }
}

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

<img src="https://facingissuesonitcom.files.wordpress.com/2019/06/java-primitive-type-keywords-.png">

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
