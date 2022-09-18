package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day22_B_1929 {
	
	public static boolean prime[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		prime = new boolean[n + 1];
		get_prime();
		
		for(int i = m; i <= n; i++) {
			if(prime[i] == false) { //false = 소수
				System.out.println(i);
			}
		}

	}
	
	public static void get_prime() {
		prime[0] = true; 
		prime[1] = true; //0과 1은 소수가 아니다
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j < prime.length; j = j + i) { //i 배수들 거르기
				prime[j] = true;
			}
		}
	}

}
