package codingtestAndAlgorithm.Day232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1_001];
		dp[1] = 1;	// 문제 조건: n >= 1
		
		// 효율 별로
//		if(n > 1) {			
//			dp[2] = 2;
//			
//			if(n > 2) {				
//				for(int i = 3; i < n+1; i++) {
//					dp[i] = (dp[i-2]+dp[i-1])%10_007;
//				}
//			}
//		}
		
		dp[2] = 2;		
		for(int i = 3; i < n+1; i++) {
			dp[i] = (dp[i-2]+dp[i-1])%10_007;
		}
		
		System.out.println(dp[n]);
	}

}
// 복습 과정 https://gimbalja.tistory.com/433