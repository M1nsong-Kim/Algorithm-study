package codingtestAndAlgorithm;

import java.util.Scanner;

public class B_2908_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int first = a / 100;
		int second = (a % 100) / 10;
		int third = a % 10;
		
		int first2 = b / 100;
		int second2 = (b % 100) / 10;
		int third2 = b % 10;
		
		int a2 = third * 100 + second * 10 + first ;
		int b2 = third2 * 100 + second2 * 10 + first2 ;
		
		if(a2 > b2) {
			System.out.println(a2);
		}else {System.out.println(b2);}
	}
}