package codingtestAndAlgorithm.Day238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[101][10];	// 100자리까지
		final int MOD = 1_000_000_000;
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;	// 1~9
		}
		
		for(int i = 2; i < n+1; i++) {	// n자리까지
			for(int j = 0; j < 10; j++) {	// 각 자릿수 0~9
				if(j == 0) {
					dp[i][0] = dp[i-1][1] % MOD;
				}else if(j == 9) {
					dp[i][9] = dp[i-1][8] % MOD;
				}else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			answer += dp[n][i] % MOD;
			answer %= MOD;
		}
		
		System.out.println(answer);
	}

}
// 복습 과정 https://gimbalja.tistory.com/439