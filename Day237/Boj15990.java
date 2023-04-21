package codingtestAndAlgorithm.Day237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15990 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int REMAINDER = 1_000_000_009;
		
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[100_001][4];
		dp[1][1] = 1;
		//dp[2][1] = 1;	 1+1이므로 1이 더 붙을 수 없다(같은 숫자는 2개까지 가능)
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i < dp.length; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % REMAINDER;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % REMAINDER;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % REMAINDER;
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append((((dp[n][1] + dp[n][2]) % REMAINDER ) + dp[n][3]) % REMAINDER).append("\n");
		}

		System.out.println(sb);
	}

}
// 복습 과정 https://gimbalja.tistory.com/438