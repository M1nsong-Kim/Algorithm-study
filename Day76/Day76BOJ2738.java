package codingtestAndAlgorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day76BOJ2738 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[2][n*m];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n*m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 디버깅 System.out.println(Arrays.deepToString(arr));
		
		int[] result = new int[n*m];
		for(int i = 0; i < n*m; i++) {
			result[i] = arr[0][i] + arr[1][i];
			System.out.print(result[i] + " ");
			if((i+1) % m == 0) {	//m의 배수마다 줄 나누기
				System.out.println();
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/183