package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj9465 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			// 2행이므로 2차원배열 중 한쪽의 크기는 2
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n+1];
			
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					// 주어진 스티커 점수 2차원 배열에 넣기
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 디버깅 System.out.println(Arrays.deepToString(arr));
			
			// 맨왼쪽 값으로 초기화
			dp[0][1] = arr[0][0];
			dp[1][1] = arr[1][0];
			
			for(int j = 2; j < n+1; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j-1];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j-1];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
// 과정 https://gimbalja.tistory.com/266