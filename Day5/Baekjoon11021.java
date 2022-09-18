package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon11021 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for (int i = 1; i <= t; i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println("Case #" + i + ": " +(a+b));
		}
	}

}
