<style>
img {
    zoom: 0.7;
    margin: 0 auto
}
</style>

# Hoofdstuk 1: Introductie Java-applicaties

content:

- java history
- 5 phases Java-app.

Leermaterialen:

We behandelen in dit hoofdstuk paragrafen uit H1 en H2 in het handboek “Java how to program”: H1: $1, $4, $8, $9; H2: $1 tem $7 en Appendix I, Formatted Output (zie online omgeving van het boek! met code aan binnenkant van de kaft inloggen)

Om de oefeningen te maken moet je eerst de juiste software installeren.

Zie “handleidingen” in het leerpad.

## 1. history

- 1991 door Sun Microsystems to program electronics
- 1993 MOSAIC the first graficbrowser is when designers rewrote the compiler (C→Java) so they build a Java based browser,Webrunner to position it as an internet language.
- Java programs are platformindependant: because Java was made to progam electronices. electronics have chips which can.
  - memorize data
  - execute instructions = **program**

programs are executed by a special chip the **processor**

- it undestands only it's **machinecode** (non understandable binary)
- we write in a higher language and compile down to machinecode via a **compiler**
- translation makes the code platformindependent (**platform** = combination type of processor with type of OS).

Solution in Java :

1. compiler translates Java programs into **java-bytecode** (intermediary) which resembles machinecode
2. **JVM** will make the bytecode understandable for a specific machine. a JVM is around (256 Kb), because translation is no big task given the small amount of keywords in Java.

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1601352687/Screenshot_2020-09-29_061052_nr5vlc.png"/>

## 2. java-apps

### example

```java
package cui;
//projects are split in packages
import java.lang.*;
// can be left out  auto import
public class Som extends Object
// can be left out each class inherits from object
{
    public static void main(String [] args)
    {
    int x=2, y=3, som;
    som=x*x+y*y;
    System.out.println("Som = " + som);
    }
}
```

### 5 phases

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1601353087/Screenshot_2020-09-29_061753_zfuchn.png"/>

1. type and save program with extension .java → Som.java
2. `javac` to compile the program → extension becomes .class (= bytecode)→ javac Som.java = Som.class3
3. Program (.class-file) loads to memory.
4. bytecode is virified (importants for net classes, viruses).
5. JVM to execute program `java` → java Som

Java-app -> JVM -> bytecode voor de JVM.

- first approach bytecode via **interpretation**.
- later **JIT-compilatie** (Just in Time) compilation during the execution of the program.
  - JIT-compilatie takes places in an **interpreter**(aka VM). source code usually first get compiled to bytecode by a compiler.
  - if the interpreter executes this bytecode and finds a piece code (function or method) meeting certain criteria, the interpreter will stop execution.
  - the interpreter compiles the code to machinecode which the cpu executes -> once the cpu finishes the interpreter continous.
  - the resulting machinecode is saved so that on the next execution compilation is not necessary anymore -> machinecode is given to the the CPU directly to be executed.

### Het Java platform

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1601356260/Screenshot_2020-09-29_071052_c8trib.png"/>

to exec a class-file you just need a **Java Runtime Environment** (=JRE) staat. which is a combinatie of the **JVM** and **Java API**
=> it is the program om to your own machinecode band the library of Java with all classes which can eb linked to your own

**JDK** = compiler + JVM

## 3. execution statements - printing

```java
package cui;

public class Easy
{
    // start the the app
    public static void main(String [] args)
    {
    // - 1
    System.out.println("hello world"); // ln means insert new line after
    System.out.print("Welcome to "); // do not insert new line
    }
    /*
    - 1. System.out as a output stream object => **stream** = way to describe information transport in a computer
    - 2. `;` means end of **statement**
    - 3. steps: test.java --> `javac` test.class --> java test
    */
}
```

**escape characters `\`**

- \n : newline = harde return
- \t : horizontale tab
- \r : carriage return
- \\ : levert 1 backslash op
- \ : levert de dubbele quote op

**`printf(format-string, arg1, arg2, ...)` (formatted printing)**

```java
package cui;


public class Easy
{
    // start the the app
    public static void main(String [] args)
    {
    System.out.printf("%s%n%s%n","Welcome to","Java Programming!");
    System.out.printf("%X", 42);
    // %s is first arg then %n is new line

     System.out.printf("%4d%n",123);
     System.out.printf("%4d%n",1234);
     System.out.printf("%4d%n%n",12345);
    }
}
```

**conversion characters**

- s = arg is string give string
- S = '' but in capitals
- d = int in decimal notation
- o = int in octal notation
- X or x = int in hexadecimal

**field width**

- between % and conversion character
- the converted string will be printed over this entire width
- non covered space gets white put on left

## 3. in and out statements

```java
package cui;

import java.util.Scanner; // 1 & 2 & 3

public class Add
{
    // start the the app
    public static void main(String [] args)
    {
    // 4
    Scanner input = new Scanner(System.in);
    int n1;
    int n2;
    int sum;



     System.out.print("first int -> ");
     n1 = input.nextInt();
     System.out.print("second int -> ");
     n2 = input.nextInt();

     sum = n1+n2;
     System.out.printf("Sum is 10%d%n", sum);
    }

    /*
    - 1. import gives compiler task to give access to class of package
    - 2. package -> collection predefined classes
    - 3. packages in JAVA api
        * Core java.x.x
        * Extensions javax.x.x
    - 4. System.in -> standard in stream object
    */
}
```

[link to docs JAVA api](https://docs.oracle.com/en/java/javase/14/docs/api/index.html)
