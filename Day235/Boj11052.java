package codingtestAndAlgorithm.Day235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] pack = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < i+1; j++) {
				dp[i] = Math.max(dp[i], pack[j]+dp[i-j]);
			}
		}
		
		System.out.println(dp[n]);
		br.close();
	}

}
