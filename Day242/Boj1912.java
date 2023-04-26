package codingtestAndAlgorithm.Day242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			int now = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i-1]+now, now);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < n+1; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/443