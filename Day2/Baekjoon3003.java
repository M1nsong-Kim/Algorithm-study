package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon3003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int arr[] = {1, 1, 2, 2, 2, 8};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]-scan.nextInt()+"");
		}
	}

}
