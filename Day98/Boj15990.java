package codingtestAndAlgorithm;

import java.io.*;

public class Boj15990 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		final int N = 1_000_000_009;
		
		long[][] dp = new long[100_001][4];
		dp[1][1] = 1;	//1일 때 1로 끝나는 개수 (1)
		dp[2][2] = 1;	//2일 때 2로 끝나는 개수 (1)
		dp[3][1] = 1;	//3일 때 1로 끝나는 개수 (2+1)
		dp[3][2] = 1;	//3일 때 2로 끝나는 개수 (1+2)
		dp[3][3] = 1;	//3일 때 3로 끝나는 개수 (3)
		
		for(int i = 4; i < 100_001; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3])%N;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3])%N;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2])%N;
		}
		
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%N);
		}

	}

}
// 과정 https://gimbalja.tistory.com/246