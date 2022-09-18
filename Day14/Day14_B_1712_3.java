package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day14_B_1712_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int n = 0;
		if(b < c) {
			n = a / (c - b) + 1;
		}else {n = -1;}
		System.out.println(n);
	}
}
