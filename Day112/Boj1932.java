package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 디버깅 System.out.println("arr["+i+"]"+"["+j+"] : "+arr[i][j]);
			}
		}
		
		dp[1][1] = arr[1][1];	// 1줄이면 자기 자신이 최대값
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < i+1; j++) {
				if(j == 1) { // 가장 앞자리 → 그전 줄의 가장 앞자리에서만 받을 수 있음
					dp[i][j] = dp[i-1][j] + arr[i][j];
				}else if(j == i) {	// 가장 끝자리 → 그전 줄의 가장 끝자리에서만 받을 수 있음
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				}
				// 디버깅 System.out.println("dp["+i+"]["+j+"] : "+dp[i][j]);
			}
		}
		
		int max = 0;
		for(int i = 0; i < n+1; i++) {
			if(dp[n][i] > max) {
				max = dp[n][i];
			}
		}
		System.out.println(max);
	}

}
// 과정 https://gimbalja.tistory.com/270