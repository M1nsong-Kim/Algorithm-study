package codingtestAndAlgorithm.Day247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 9901;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 3;
		
		for(int i = 2; i < n+1; i++) {
			dp[i] = (2*dp[i-1] + dp[i-2]) % MOD;
		}
		
		System.out.println(dp[n]);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/448