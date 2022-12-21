package codingtestAndAlgorithm;

import java.io.*;

public class Boj2133 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 1;	// dp[2] = dp[0]*3 = 3 -> dp[0] = 1(아무것도 채우지 않는 경우를 1로 보자고 친다)
		
		for(int i = 2; i < n+1; i+=2) {
			dp[i] = dp[i-2] * 3;
			for(int j = i-4; j >= 0; j-=2) {
				dp[i] = dp[i] + (dp[j]*2);
				// 점화식 : dp[i] = dp[i-2]*3 + (dp[i-4]*2) + (dp[i-6]*2) + (dp[i-8]*2) + ... (dp[0]*2) 
				// == dp[i] = dp[i] + (dp[i-4]*2) + (dp[i-6]*2) + (dp[i-8]*2) + ... (dp[0]*2)
			}
		}

		System.out.println(dp[n]);
	}

}
// 과정 https://gimbalja.tistory.com/278