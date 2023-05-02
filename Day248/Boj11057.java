package codingtestAndAlgorithm.Day248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		final int MOD = 10_007;
		
		int[][] dp = new int[n+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < n+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {					
					dp[i][j] += dp[i-1][k] % MOD;
				}  
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[n][i];
			sum %= MOD;
		}
		
		System.out.println(sum);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/449