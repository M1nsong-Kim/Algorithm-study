package codingtestAndAlgorithm;

import java.util.Scanner;

public class Boj11576 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 2~30 진법
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int m = sc.nextInt();
		
		// 10진수로 바꾸기
		int sum = 0;
		int idx = m - 1;
		for(int i = 0; i < m; i++) {
			int n = sc.nextInt();
			sum += n*Math.pow(a, idx);
			idx--;
		}
		// 디버깅
//		System.out.println(sum);

		// 10진수를 b진수로 바꾸기
		while(sum != 0) {
			sb.append(sum%b+" ");
			sum /= b;
		}
		sb.reverse();
		sb.deleteCharAt(0);	//공백 삭제
		System.out.println(sb);
	}

}
