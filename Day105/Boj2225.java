package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj2225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n+1][k+1];
		final int MOD = 1_000_000_000;
		
		// k=1 -> [1][1] = 1, [2][1] = 2, ... 무조건 1개씩
		for(int i = 1; i < n+1; i++) {
			dp[i][1] = 1;
		}
		
		// n=1 -> [1][1] = 1, [1][2] = 0+1,1+0, [1][3] = 1+0+0, 0+1+0, 0+0+1, ... k개씩
		for(int i = 1; i < k+1; i++) {
			dp[1][i] = i;
		}
		
		for(int i = 2; i < n+1; i++) {
			for(int j = 2; j < k+1; j++) {
				// 오버 플로우 방지를 위해 MOD의 나머지로 구한다
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
			}
		}
		System.out.println(dp[n][k]);
	}

}
// 과정 https://gimbalja.tistory.com/258