package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11727 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i < n+1; i++) {	// 1, 2로 구할 수 있는 3부터
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);

	}

}
// 과정 https://gimbalja.tistory.com/240