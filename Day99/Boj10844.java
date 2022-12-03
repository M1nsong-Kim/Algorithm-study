package codingtestAndAlgorithm;

import java.io.*;

public class Boj10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[101]; // 1 ~ 100
		dp[1] = 9;
		
		for(int i = 2; i < n+1; i++) {
			if(i % 2 == 0) {	// 짝수라면
				dp[i] = (dp[i-1]*2)-1;
			}else {	// 홀수라면
				dp[i] = (dp[i-1]*2)+1;
			}
		}
		
		System.out.println(dp[n]);
		
	}

}
