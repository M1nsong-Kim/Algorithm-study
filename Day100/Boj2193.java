package codingtestAndAlgorithm;

import java.io.*;

public class Boj2193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[91];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i < n+1; i++) { // 인덱스 n까지
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[n]);

	}

}
// 과정 https://gimbalja.tistory.com/248