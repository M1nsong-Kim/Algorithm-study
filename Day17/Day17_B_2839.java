package codingtestAndAlgorithm;

import java.util.*;

public class Day17_B_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		
		while(true) {
			if(n % 5 == 0) {
				answer += n / 5;
				System.out.println(answer);
				break;
			}else {
				n -= 3;
				answer++;
			}
			
			if(n<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
