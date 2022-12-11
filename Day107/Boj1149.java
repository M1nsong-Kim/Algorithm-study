package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];	// 0: R, 1: G, 2: B
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 디버깅 System.out.println(Arrays.deepToString(dp));
		
		for(int i = 1; i < n; i++) {
			// 빨강일 땐 그전 색깔이 초록/파랑 중 작은 값에 더함
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + dp[i][0];
			// 초록일 땐 그전 색깔이 빨강/파랑 중 작은 값에 더함
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + dp[i][1];
			// 파랑일 땐 그전 색깔이 빨강/초록 중 작은 값에 더함
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][2];
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}

}
// 과정 https://gimbalja.tistory.com/260