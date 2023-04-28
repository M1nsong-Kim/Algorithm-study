package codingtestAndAlgorithm.Day245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		final int MOD = 1_000_000_009;
		long[] dp = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 1_000_001; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%MOD;			
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
	}

}
// 복습 과정 https://gimbalja.tistory.com/446