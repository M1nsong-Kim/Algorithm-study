package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[11];	// 인덱스 10이 있어야 하므로 11크기의 배열
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 11; i++) {	// 구해진 1~3 이후부터 배열 채우기
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

}
// 과정 https://gimbalja.tistory.com/205