package codingtestAndAlgorithm;

import java.io.*;

public class Boj1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		for(int i = 1; i < n+1; i++) {
			dp[i] = i;
			for(int j = 1; j*j < i+1; j++) {
				dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
// 과정 https://gimbalja.tistory.com/256