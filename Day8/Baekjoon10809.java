package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		for(char c = 'a' ; c <= 'z'; c++) {
			System.out.print(s.indexOf(c)+ " ");
		}
	}

}
