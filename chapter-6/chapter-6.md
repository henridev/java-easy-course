# Hoofdstuk 6: methods next level

Table of Contents

1. Inleiding.
2. Static en non-static methodes.
   - 3.1. non-static.
   - 3.2. static.
   - 3.3. argumenten van een methode.
   - 3.4. uitgewerkt voorbeeld.
     - 3.4.1. zonder methodes.
     - 3.4.2. met een static methode.
     - 3.4.3. met een static methode in een hulpklasse.
     - 3.4.4. met een non-static methode in een hulpklasse.
     - 3.4.5. met een non-static methode (zonder hulpklasse).
     - 3.4.6. vanuit de ene non-static methode een andere methode aanroepen. 104.
3. Gebruik van methodes uit een bibliotheekklasse (klasse Math).
4. Parameters doorgeven in een methode.
   - 5.1. Pass by value.
   - 5.2. Pass by reference.
5. Exceptions gebruiken in de setters.
6. Arrays en methodes.
   - 7.1. Inleiding.
   - 7.2. Voorbeeld 1-dimensionale array.
   - 7.3. Voorbeeld 2-dimensionale array.
   - 7.4. Programmaparameters.
7. Recursie.
   - 8.1. Wat is recursie?.
   - 8.2. Voorbeeld 1: faculteitsberekening.
   - 8.3. Voorbeeld 2: de Fibonacci reeks.
8. Een aantal extra’s.
   - 9.1. Promotie en casting.
   - 9.2. Random getallen genereren.
     - 9.2.1. Klasse Math.
     - 9.2.2. Klasse Random.
     - 9.2.3. Klasse SecureRandom.
     - 9.2.4. Voorbeeld 1: 20 dobbelsteenworpen.
     - 9.2.5. Voorbeeld 2: 6 miljoen dobbelsteenworpen.
     - 9.2.6. Voorbeeld 3: het Craps-spel.
   - 9.3. Enumeration.
   - 9.4. Scope van variabelen.
   - 9.5. final attribuut
   - 9.6. BigDecimal voor nauwkeurige berekeningen
   - 9.7. static klassevariabelen

## 1. inleiding

karakteristieken methodes:

- De methodes zijn "klein", waarbij "klein" betekent dat ze weinig regels code bevatten
- Elke methode heeft één specifieke taak
- De naam van de methode benoemt die ene taak
- Methodes zijn goed herbruikbaar

## 2. Static en non-static methodes

**non-static methode** = eerst een object construeren om deze methodes aan te moeten roepen.
**static methodes** = voeren een taak uit, onafhankelijk van de inhoud van om het even welk object van de klasse. Een dergelijke methode noemen we dan ook vaak een **klassemethode**.

Een voorbeeld van een static methode dat we al kennen, is de **main-methode**. Deze moet wel static zijn aangezien die bij de start van het programma, wanneer er nog geen objecten zijn, wordt aangeroepen. Door main static te declareren, kan de JVM deze methode activeren zonder dat er al een object van de klasse moet bestaan.
In de console start je je Java-programma op met `java Klassenaam [argument1 argument2]`. De JVM laadt dan de klasse, gespecifieerd door Klassenaam en gebruikt deze naam om de main-methode aan te roepen.

to call a main method of a class

```
java App arg_1 arg_2 ... arg_n
```

to call a static method

```java
ClassName.methodName()
```

the final keyword

```java
// final class cannot be subclassed
public final class MyFinalClass {...}

public class ThisIsWrong extends MyFinalClass {...} // forbidden

public class Base
{
    public       void m1() {...}
    public final void m2() {...}

    public static       void m3() {...}
    public static final void m4() {...}
}

// final method cannot be overridden or hidden by subclasses
public class Derived extends Base
{
    public void m1() {...}  // OK, overriding Base#m1()
    public void m2() {...}  // forbidden

    public static void m3() {...}  // OK, hiding Base#m3()
    public static void m4() {...}  // forbidden
}

/*
A final variable can only be initialized once, either via an initializer or an assignment statement. It does not need to be initialized at the point of declaration: this is called a "blank final" variable. A blank final instance variable of a class must be definitely assigned in every constructor of the class in which it is declared; similarly, a blank final static variable must be definitely assigned in a static initializer of the class in which it is declared; otherwise, a compile-time error occurs in both cases.[6] (Note: If the variable is a reference, this means that the variable cannot be re-bound to reference another object. But the object that it references is still mutable, if it was originally mutable.)
*/
public class Sphere {

    // pi is a universal constant, about as constant as anything can be.
    public static final double PI = 3.141592653589793;

    public final double radius;
    public final double xPos;
    public final double yPos;
    public final double zPos;

    Sphere(double x, double y, double z, double r) {
         radius = r;
         xPos = x;
         yPos = y;
         zPos = z;
    }

    [...]
}
```

## 3. Math class

## 4. Parameters doorgeven in een methode.

### 4.1 pass by value

primitieve datatypes => pass by value. Dit wil zeggen dat de waarde van de variabele doorgegeven wordt aan de methode die aangeroepen wordt en deze dus niet gewijzigd kan worden.

```java
package cui;
public class PassByValue
{
    public static void main(String[] args)
    {
        int a = 30;
        int b = 45;
        System.out.println("in main before swap : a = " + a + " en b = " + b);
        // methode wissel aanroepen
        wissel(a, b);
        System.out.println();
        System.out.println("in main after swap no swap occured");
        System.out.println("a = " + a + " en b is " + b);
    }
    // er worden verschillende geheugenplaatsen gebruikt om a en b variabelen bij te houden
    private static void swap(int a, int b)
    {
        System.out.println("in method before swap : a = " + a + " en b = " + b);
        // Wissel de 2 waarden
        int c = a;
        a = b;
        b = c;
        System.out.println("in method before after swap : a = " + a + " en b = " + b);
    }
}
```

### 4.2 pass by reference

Ook voor objecten gebruikt Java eigenlijk pass by value. De referentie wordt dus gekopieerd en
kan door de aangeroepen methode worden gebruikt. Aangezien je met een kopie van de referentie
werkt, zal het oorspronkelijk object dus wel gewijzigd kunnen worden.

Het enige wat niet lukt en waarvoor je dus een echte pass by reference zou nodig hebben, is om een nieuw object te maken dat dan toegekend wordt aan de referentie.

```java
package domein;
public class MijnGetal
{
    private int getal;
    public MijnGetal(int getal)
    {
        this.getal = getal;
    }
    public int getGetal()
    {
        return getal;
    }
    public final void setGetal(int getal)
    {
        this.getal = getal;
    }
}


package cui;
import domein.MijnGetal;
public class PassByReference
{
    public static void main(String[] args)
    {
        MijnGetal a = new MijnGetal(30);
        MijnGetal b = new MijnGetal(45);
        System.out.println("Voor de wissel, in main: a bevat " + a.getGetal() + " en b bevat " + b.getGetal());
        // methode wissel aanroepen
        wissel(a, b);
        System.out.println();
        System.out.println("En deze keer zijn ze echt omgewisseld...:");
        System.out.println("Na de wissel, in main: a bevat " + a.getGetal() + " en b bevat " + b.getGetal());
        // methode kenNieuwObjectToe aanroepen
        System.out.println();
        System.out.println("Voor de toekenning, in main: het object bevat " + a.getGetal());
        // Het enige wat niet lukt en waarvoor je dus een echte pass by reference zou nodig hebben, is om een nieuw object te maken dat dan toegekend wordt aan de referentie.
        kenNieuwObjectToe(a);
        System.out.println();
        System.out.println("Maar de toekenning van een nieuw object lukt niet!");
        System.out.println("Na de toekenning, in main: het object bevat " + a.
        getGetal());
    }
private static void wissel(MijnGetal a, MijnGetal b)
{
    System.out.println("Voor de wissel, in methode: a bevat " + a.getGetal() + " en
    b bevat " + b.getGetal());
    // Wissel de 2 waarden
    MijnGetal c = new MijnGetal(a.getGetal());
    a.setGetal(b.getGetal());
    b.setGetal(c.getGetal());
    System.out.println("Na de wissel, in methode: a bevat " + a.getGetal() + " en b bevat " + b.getGetal());
}
private static void kenNieuwObjectToe(MijnGetal eenGetal)
{
    // wanneer we een nieuw object aanmaken, dan krijgen we
    // een nieuwe referentie terug die niet meer zal overeenstemmen met de referentie in de a uit de main.
    // Bij de terugkeer naar de main, is deze nieuwe referentie dan ook uit het geheugen verdwenen en zal
    // dus niet de nieuwe waarde, waar eenGetal naar verweest, maar de oorspronkelijke waarde van a
    // gebruikt worden om verder mee te werken.
    System.out.println("Voor de toekenning, in methode: het object bevat " + eenGetal.getGetal());
    eenGetal = new MijnGetal(60);
    System.out.println("Na de toekenning, in methode: het object bevat " + eenGetal.getGetal());
}
}
```

## 5. exceptions in setters

```java
private void setLengte(double lengte)
{
    if (lengte < 1) throw new IllegalArgumentException("Lengte voldoet niet");
    this.lengte = lengte;
}
private void setBreedte(double breedte)
{
    if (breedte < 1) throw new IllegalArgumentException("Breedte voldoet niet");
    this.breedte = breedte;
}
```

## 6. arrays and methods

arrays like objects are "passed by reference", you get a copy to the right memoryadress inside of the method.

- changes to the array in the method will be permanent.
- performantie is higher then if it were only "pass by value" zou gaan, because data does not need to be copied

```java
int temperatuurPerUur[] = new int[24];

public void wijzigArray( int[] eenTemperatuurArray)
{
    …
}

wijzigArray(temperatuurPerUur);
```

### 6.1 1-d arrays

```java
package cui;
public class PassArray
{
    // main creëert “array” and roept de methoden modifyArray en modifyElement op
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5}; ①
        System.out.printf("Effects of passing reference to entire array\nThe values of the original array are:");
        // de oorspronkelijke elementen van de array weergeven
        for (int value : array) System.out.printf("%5d", value);
        modifyArray(array);
        System.out.printf("\n\nThe values of the modified array are:");
        // de gewijzigde elementen van de array worden weergegeven
        for (int value : array) System.out.printf("%5d", value);

        System.out.printf("\n\nEffects of passing array element value:\narray[3] before modifyElement: %d%n" array[3]);
        modifyElement(array[3]); // een poging om array[3] te wijzigen
        System.out.printf("array[3] after modifyElement: %d%n", array[3]);
    } // end main
    // elk element van de array vermenigvuldigen met 2
    public static void modifyArray(int[] array2)
    {
        for (int counter = 0; counter < array2.length; counter++) array2[counter] *= 2;
    }
    // het argument met 2 vermenigvuldigen (is primitive type zon't work)
    public static void modifyElement(int element)
    {
        element *= 2;
    }
}
```

### 6.2 2-d arrays

```java
package twodArrayExample;

public class Application {

	public static void main(String[] args) {
		int[][] gradesArray = {{87, 96, 70}, {68, 87, 90}, {94, 100, 90},
							   {100, 81, 82}, {83, 65, 85}, {78, 87, 65},
				               {85, 75, 83}, {91, 94, 100}, {76, 72, 84}, {87, 93, 73}};

		GradeBook gradeBook =  new GradeBook("java programming", gradesArray);
		System.out.printf(String.format("welcome to the course \n%s! \n\n", gradeBook.getTitle()));
		gradeBook.printGrades();
		gradeBook.printLowestAndHighest();
		gradeBook.printDistribution();
	}

}


package twodArrayExample;


public class GradeBook {
	String title;
	int[][] grades;

	public GradeBook(String title, int[][] grades) {
		super();
		this.setGrades(grades);
		this.setTitle(title);
	}

	public String buildOutput() {
		return title;
	}

	public void printGrades() {
		int index = 1;
		System.out.format("%15s %15s %15s %15s %15s \n", "","Test 1", "Test 2", "Test 3", "Average");
		for (final int[] scoreArray : this.grades) {
			System.out.format("%15s %15d %15d %15d %15d\n",
								"Student " + index,
								scoreArray[0],  scoreArray[1], scoreArray[2],
								this.calculateAverage(scoreArray));
			index++;
		}

	}

	public void printLowestAndHighest() {
		int[] lowHigh = this.calculateLowestHighest();
		System.out.format("\n%s %d \n %s %d\n\n",
				"The lowest grade is ",  lowHigh[0],
				"The highest grade is ",  lowHigh[1]);
	}

	public void printDistribution() {
		int[] distribution = this.calculateDistribution();
		int index = 0;
		System.out.format("overall grade distribution: \n");
		for (final int i : distribution) {
			if(index == 100) {
				System.out.format("%01d: %s \n", index, "*".repeat(i));
				break;
			}
			System.out.format("%01d-%01d: %s \n", index, index+9, "*".repeat(i));
			index+=10;
		};

	}

	public int calculateAverage(int[] scoreArray) {
		int sum = 0;
		for (final int i : scoreArray) sum+=i;
		return sum / scoreArray.length;
	}

	public int[] calculateLowestHighest() {
		int[] lowAndHigh = {100, 0};
		for (final int[] sArr : this.grades) {
			int low = Math.min(sArr[0], Math.min(sArr[1], sArr[2]));
			int high = Math.max(sArr[0], Math.max(sArr[1], sArr[2]));
			if(low < lowAndHigh[0]) lowAndHigh[0] = low;
			if(high < lowAndHigh[1]) lowAndHigh[1] = high;
		}
		return lowAndHigh;
	}

	public int[] calculateDistribution() {
		int[] distribution = new int[11];
		for (final int[] sArr : this.grades) {
			for (final int grade : sArr) {
				++distribution[grade/10];
			}
		}
		return distribution;
	}
```

### 6.2 program parameters

`public static void main(String[] args)`

- Stel: je wil dit programma runnen en de array {"3","4","5"} doorgeven als parameter aan de methode main.
- In het menu "Run (As) – Run Configurations…" vind je het tabblad Arguments. Hier kan je de programmaparameters doorgeven. Vervolgens klik je op "Run".

## 7. recursion

Een recursieve methode

- roept zichzelf op (direct of indirect via een andere methode)
- kan enkel de basis case(s) oplossen, m.a.w. roepen we de methode aan met de basis case(s), dan geeft deze een resultaat terug.
- verdeelt een probleem in een basis case en een eenvoudiger probleem indien de methode wordt aangeroepen met een complexer probleem en gaat door met het eenvoudiger probleem verder te verdelen totdat het opgelost is.

Een recursieve methode bevat dus een recursieve oproep (call). Het nieuwe, eenvoudiger probleem lijkt op het originele probleem, dus roept de methode zichzelf terug aan om het eenvoudiger probleem op te lossen. Dit is een recursieve doorloop (step). De recursieve stap bevat normaal ook het keyword return, vermits het resultaat van deze aanroep moet gecombineerd worden met het resultaat van het gedeelte dat de methode wel kan oplossen
om uiteindelijk een eindresultaat aan de originele caller te kunnen teruggeven!

```java
package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int result = calculate(number);
		System.out.format("result %d", result);
	}

	public static int calculate(int n) {
		return n * (n == 1 || n == 0 ? n : (calculate(n-1) + calculate(n-2)));
	}
}

public class Factorial {
	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int result = calculate(number);
		System.out.format("result %d", result);
	}

	public static int calculate(int number) {
		return number * (number == 1 ? 1 : calculate(number-1));
	}
}
```

## 8. extras

### 8.1 Typeconversion (coercion)

means you modify the arguments type

```java
System.out.println(Math.sqrt(4));
// is interpreted as
System.out.println(Math.sqrt(4.));
// this results into
System.out.println(2.);
```

**promotion** = specifies how certain types can be converted without losing data, the rule is that conversion to a type recuiring more bits usually works

| Type    | Toegelaten promoties                              |
| ------- | ------------------------------------------------- |
| double  | geen                                              |
| float   | double                                            |
| long    | float of double                                   |
| int     | long, float of double                             |
| char    | int, long, float of double                        |
| short   | int, long, float of double                        |
| byte    | short, int, long, float of double                 |
| boolean | geen (boolean waarden zijn geen getallen in Java) |

```java
int a = 10; double b = 0; b += a;
double res = square((int)x)
```

### 8.2 random numbers

#### 8.2.1 math

```java
//  [0.0,6.0[
(int) (Math.random() * 6)
//  0, 1, 2, 3, 4 of 5.
(int) (Math.random() * 6)
//[1,7[
(int) (Math.random() * 6) + 1;
// 6 shaalwaarde en 1 shiftfactor
```

#### 8.2.2 random and securerandom

klasse Random uit de package java.util en klasse SecureRandom uit de package java.security.

Het grote verschil tussen de twee is dat de getallen die de klasse SecureRandom genereert minder voorspelbaar zijn doordat er een andere random generator gebruikt wordt. Voor "huis, tuin en keukengebruik" kan je echter nog steeds perfect Random gebruiken, dat minder geheugen gebruikt. Gebruik echter zeker SecureRandom wanneer je niet wilt dat je random waardes makkelijk te kraken zijn, zoals bijvoorbeeld bij willekeurig gegenereerde wachtwoorden. De methodes van de klasse Random worden overgeërfd door de klasse SecureRandom en zijn dus
dezelfde

```java
SecureRandom randomNumbers = new SecureRandom ();
// geheel getal tussen 1 en 6 (beide inbegrepen)
int randomValue = 1 + randomNumbers.nextInt(6);
// int n = a + randomNumbers.nextInt(b);

// Om een willekeurig getal uit de reeks 2, 5, 8, 11 en 14 te genereren, gebruiken we het volgende
int randomValue = 2 + 3 * randomNumbers.nextInt(5);
// int n = shiftvalue + step * randomNumbers.nextInt(b);
```
