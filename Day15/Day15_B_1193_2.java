package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day15_B_1193_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = 0; //n번째 행
		int last = 0;
		
		int top = 0;
		int bottom = 0;
		
		while(last < x) {
			n++;
			last = n * (n + 1) / 2;
		}
		
		if(n % 2 != 0) {
			top = last - x + 1;
			bottom = n - last + x;
		}else {
			top = n - last + x;
			bottom = last - x + 1;
		}
		System.out.println(top + "/" + bottom);
	}
}
