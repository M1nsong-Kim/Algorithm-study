package codingtestAndAlgorithm;

import java.util.*;

public class Day19_B_1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			boolean isPrime = true; //소수면 true 아니면 false
		
			int num = sc.nextInt();
			
			if(num == 1) {
				continue;
			}
			
			for(int j = 2; j <= Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				count++;
			}
		}	System.out.println(count);
	}
}
