package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1_000_001];
		
		dp[1] = 0;
		for(int i = 2; i < n+1; i++) {
			dp[i] = dp[i-1]	+ 1;	// 1은 -1하는 연산 더한 것
			if(i % 3 == 0) {	//3으로 나누어 떨어진다면(여기서 6의 배수도 같이 계산)
				dp[i] = Math.min(dp[i], dp[i/3]+1);	// 1은 /3하는 연산 더한 것
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);	// 1은 /2하는 연산 더한 것
			}
		}
		System.out.println(dp[n]);
				
	}

}
// 과정 https://gimbalja.tistory.com/206