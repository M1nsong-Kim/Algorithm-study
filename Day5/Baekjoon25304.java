package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon25304 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();
		int N = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			X = X - (a*b);
		}
		if(X == 0) {
			System.out.println("Yes");
		}else {System.out.println("No");}
	}

}
