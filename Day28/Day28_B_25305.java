package codingtestAndAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day28_B_25305 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		
		Arrays.sort(x);
		
		System.out.println(x[n-k]);
	}
}