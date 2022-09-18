package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 개수는 9개로 고정
		int arr[] = new int[9];

		int max = arr[0];
		int maxIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		System.out.println(max);
		System.out.println(maxIndex+1);
	}
}