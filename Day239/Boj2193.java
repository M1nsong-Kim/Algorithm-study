package codingtestAndAlgorithm.Day239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[91];

		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i < n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}

}
// 복습 과정 https://gimbalja.tistory.com/440