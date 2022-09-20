package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day24_B_9020 {
	
	public static boolean prime[] = new boolean[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a = n / 2;
			int b = n / 2; // (n/2) - (n/2) = 0 으로 두 수의 차이가 가장 작다
		
			get_prime();
			while(true) {
				if(prime[a] == false && prime[b] == false) { // n/2값이 소수라면
					break;									// while문 나가고 출력
				}else {			// n/2값이 소수가 아니라면
					a--;
					b++;		// n/2값에 1을 더하고 빼서 소수가 나올 때까지 반복한다
				}
			}
			System.out.println(a + " " + b);	//두 수는 공백으로 구분한다
		}

	}
	
	public static void get_prime() { //소수인지 판별하는 에라토스테네스의 체. false면 소수
		prime[0] = true;
		prime[1] = true;	//0과 1은 소수가 아니다
		
		for(int i = 2; i < Math.sqrt(prime.length); i++) {	//2부터 배열 끝의 제곱근까지 확인하면 소수
			for(int j = i * i; j < prime.length; j += i) {	//배수들을 지워나간다
				prime[j] = true;
			}
		}
	}
}

