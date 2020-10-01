package exercises;

import java.util.Scanner;

public class Exercices 
{ 
    public static void main(String[]args)
    {
      ex9();
     }
    
    public static void ex2() {
    	  int x=2;
          System.out.println("getal + 1 = " + (x+1));
          System.out.println("getal - 1 = " + (x-1));
	}
	
    public static void ex3() {
  	  int topay=45, toget=100;
        System.out.println("to pay " + (topay));
        System.out.println("to get " + (toget));
        System.out.println("return " + (toget-topay));
	}
    
    public static void ex4() {
          System.out.println("Open the \"folder\"!");
          System.out.println("D:\\temp\\OOPI");
          System.out.printf("%n%s %n%s %n%n%s", "mijn naam is Henri,", "toegepaste informatica is easy peasy", "85-95=10");
  	}
    
    public static void ex5() {
    	int length, width;
    	Scanner input = new Scanner(System.in);
        System.out.println("length ? ");
        length = input.nextInt();
        System.out.println("width ? ");
        width = input.nextInt();
        System.out.printf("%s%d%n%s%d", "circumference = ", ((length*2) + (width * 2)) , "surface = ", (length * width));
	}
    
    public static void ex6() {
    	int x;
    	String stringVal;
    	Scanner input = new Scanner(System.in);
    	do {
            System.out.print("give number >= 999 and <=9999 : ");
            x = input.nextInt();
    	} while((x < 999 || x > 99999));
    	
    	stringVal = String.valueOf(x);
    	
        System.out.printf("%n %s %s%n %s %s%n %s %s%n %s %s%n",
        		  			stringVal.charAt(0),
        		  			"thousands",
        		  			stringVal.charAt(1),
        		  			"hunderds",
        		  			stringVal.charAt(2),
        		  			"tenths",
        		  			stringVal.charAt(3),
        		  			"units"
        		  			);
        
        input.close();
	}
    
    public static void ex7() {
    	// in cm
    	double length = 1000,  width = 50, wWall, lWall;
    	Scanner input = new Scanner(System.in);
        System.out.print("length wall ? ");
        wWall = input.nextInt();
        System.out.print("width wall ? ");
        lWall = input.nextInt();
        
        System.out.printf("%n%s%d", "needed roles ",(int) Math.ceil(((wWall / width) * lWall) / length));
        
        input.close();
	}
    
    public static void ex8() {
    	int date, daysInYear = 360, days, monthDays;
    	String stringVal;
    	Scanner input = new Scanner(System.in);
        System.out.print("give in date in ddmmjjjj : ");
        date = input.nextInt();
        
        stringVal = String.valueOf(date);
        days=(stringVal.length() < 8 ? (Integer.valueOf(stringVal.substring(0,1))) : (Integer.valueOf(stringVal.substring(0,2)))) ;
        monthDays= days > 9 ? (Integer.valueOf(stringVal.substring(2,4))) : (Integer.valueOf(stringVal.substring(1,3)));
        monthDays= (monthDays-1)*30;
        daysInYear = daysInYear - days - monthDays;
        
        System.out.printf("%n it takes %d until new year",  daysInYear);
        
        input.close();
	}
    
    public static void ex9() {
    	int number;
    	Scanner input = new Scanner(System.in);
        System.out.print("give in number : ");
        number = input.nextInt();
        
        
        System.out.printf("%10d %10d %10d %10d %10d %n",  
		           1,
		           10,
		           100,
		           1000,
		           10000);
        System.out.printf("%10d %10d %10d %10d %10d",  
        		           number,
        		           number*10,
        		           number*100,
        		           number*1000,
        		           number*10000);
      
        
        input.close();
    }
    
    public static void ex9() {
    	int number;
    	Scanner input = new Scanner(System.in);
        System.out.print("give in number : ");
        number = input.nextInt();
        
        System.out.printf("%10d %10d %10d %10d %10d %n",  
		           1,
		           10,
		           100,
		           1000,
		           10000);
        System.out.printf("%10d %10d %10d %10d %10d",  
        		           number,
        		           number*10,
        		           number*100,
        		           number*1000,
        		           number*10000);
      
        
        input.close();
    }
    
    public static void ex10() {
    	int n1, n2, n3;
    	Scanner input = new Scanner(System.in);
        System.out.print("give in number 1 : ");
        n1 = input.nextInt();
        System.out.print("give in number 2 : ");
        n2 = input.nextInt();
        System.out.print("give in number 3 : ");
        n3 = input.nextInt();

        System.out.printf("of the given numbers %d, %d, %d%n", n1, n2, n3 );
        System.out.printf("sum is %d %n", n1 + n2 + n3);
        System.out.printf("average is %d %n", (n1 + n2 + n3) / 3);
        System.out.printf("remainder is %d %n", (n1 + n2 + n3) % 3);
        
        input.close();
	}
}