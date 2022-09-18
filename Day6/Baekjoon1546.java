package codingtestAndAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double arr[] = new double[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}
		
		double sum = 0;
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			sum += ((arr[i] / arr[n-1]) * 100);
		}
		System.out.println(sum / n);
	}
}
