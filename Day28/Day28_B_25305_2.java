package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day28_B_25305_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x[] = new int[n];
		int count[] = new int[10001];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			count[x[i]]++;
		}
		
		for(int i = 10000; i >= 0; i--) {
			while(count[i] > 0) {
				count[i]--;
				k--;
				
				if(k==0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}