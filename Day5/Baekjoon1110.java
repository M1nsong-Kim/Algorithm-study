package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon1110 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int originN = n;
		int count = 0;
		
		while(true) {
			int left = originN / 10;
			int right = originN % 10;
			originN = right * 10 + (left + right) % 10;
			count++;
			if(originN == n) {
				break;
			}
		}System.out.println(count);
	}
}
