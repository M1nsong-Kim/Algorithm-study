package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[];
		int c = sc.nextInt();
		
		for(int i = 0; i < c; i++) {
			int n = sc.nextInt();
			arr = new int[n];
			
			double sum = 0;
			for(int j = 0; j < n;j++) {
				int val=sc.nextInt();
				arr[j] = val;
				sum+=val;
			}
			
			double avg = sum / n;
			double count = 0;
			
			for (int j=0; j<n; j++) {
				if(arr[j]>avg) {
					count++;
				}
			}
			System.out.printf("%.3f%%\n",(count/n)*100);
		}

	}

}
