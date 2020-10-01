package werkcollege1;

import java.util.Scanner;

public class Exercices {
	public static void main(String[]args){
	    ex3();
	}
	
	public static void ex1() {
		int n1 = 10;
		int n2 = 20;
		
		System.out.printf("%30s\t", "getal1 + getal2");
		System.out.printf("%4d%n", n1 + n2);
		System.out.printf("%d\t%3S%n", n1 + n2, "end");
		System.out.printf("%1d%n", 100 - n2 * 10);
	}
	
	public static void ex2() {
		int n1;
		int n2;
		int n3;
		int product;
		
		Scanner input = new Scanner(System.in);
		System.out.print("n1 -> ");
		n1 = input.nextInt();
		System.out.print("n2 -> ");
		n2 = input.nextInt();
		System.out.print("n3 -> ");
		n3 = input.nextInt();
		
		product = n1 * n2 * n3;
		
		System.out.printf("%s %5d %n", "the resulting product is " ,product);
	}
	
	public static void ex3() {
		int salary;
		int yearSalary;
		double vacationRate = 0.08;
		float vacationMoney;
		
		Scanner input = new Scanner(System.in);
		System.out.print("maandsalaris euro -> ");
		salary = input.nextInt();
		yearSalary = salary * 12;
		vacationMoney = (float) (salary * vacationRate);
		System.out.printf("%s %5d %n", "year salary is " ,yearSalary);
		System.out.printf("%s %5f %n", "vacation money is " ,vacationMoney);
	}
}