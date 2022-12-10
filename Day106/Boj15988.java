package codingtestAndAlgorithm;

import java.io.*;

public class Boj15988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		final int MOD = 1_000_000_009;
		// 오버플로우 방지를 위한 long 타입 선언
		long[] dp = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 1_000_001; i++) {
			// 오버플로우 방지를 위한 나머지 연산
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%MOD;			
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}

	}

}
// 과정 https://gimbalja.tistory.com/259