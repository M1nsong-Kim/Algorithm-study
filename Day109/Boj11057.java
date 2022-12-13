package codingtestAndAlgorithm;

import java.io.*;

public class Boj11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		final int MOD = 10_007;
		int[][] dp = new int[n+1][10];
		
		for(int i = 0; i < 10; i++) {
			// 1자리일 때 0~9로 끝나는 숫자는 모두 1개씩
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < n+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					// 오버플로우를 막기 위한 나머지 연산
					dp[i][j] += (dp[i-1][k]) % MOD;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		
		// 오버플로우를 막기 위한 나머지 연산
		System.out.println(sum%MOD);

	}

}
// 과정 https://gimbalja.tistory.com/264