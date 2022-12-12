package codingtestAndAlgorithm;

import java.io.*;

public class Boj1309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		final int MOD = 9901;
		
		int[] dp = new int[n+1];

		dp[0] = 1;	//아무것도 없는 경우 - 1개
		dp[1] = 3;	// 00 / 10 / 01 - 3개
		
		for(int i = 2; i < n+1; i++) {
			// 오버플로우를 막기 위한 나머지 연산
			dp[i] = (dp[i-1]*2 + dp[i-2]) % MOD;
		}
		
		System.out.println(dp[n]);

	}

}
// 과정 https://gimbalja.tistory.com/262