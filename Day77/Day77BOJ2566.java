package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day77BOJ2566 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열에 넣을 필요 없이 처음부터 끝까지 크기 비교
		int max = 0;
		int row = 0;
		int col = 0;
		for(int i = 0; i < 9; i++) {	// 행
			for(int j = 0; j < 9; j++) {	//열
				int n = sc.nextInt();
				if(max < n) {
					max = n;
					
					row = i;
					col = j;
				}
			}
		}
		System.out.print(max + "\n" + (row+1) + " " + (col+1));
	}

}
// 과정 https://gimbalja.tistory.com/184