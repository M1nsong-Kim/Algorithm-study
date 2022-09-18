package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day15_B_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt(); //주어진 수
		int n = 0; //행 번호 //행 번호 + 1 = 분모 + 분자
		int last = 0; //n까지의 합(n행의 마지막 수)
		
		int top = 0; //분자
		int bottom = 0; //분모
		
		while(last < x) { //n행의 마지막 수보다 내가 더 크다면
			n++; //n행의 수를 키움
			last = n * (n + 1) / 2; //내가 속한 n행의 마지막 수
		}
		
		if(n % 2 != 0) { //n이 홀수라면
			top = last - x + 1;
			bottom = n - last + x;
		}else {
			top = n - last + x;
			bottom = last - x + 1;
		}
		System.out.println(top + "/" + bottom);
	}
}
