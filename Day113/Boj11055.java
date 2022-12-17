package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj11055 {
	
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		// 디버깅 System.out.println(Arrays.toString(arr));
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					// 디버깅 System.out.println("dp["+i+"] : "+dp[i]+", dp["+j+"] : "+dp[j]+", arr["+i+"] : "+arr[i]);
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
					// 디버깅 System.out.println(dp[i]);
				}
			}
		}
		
		int max = 0;	// 수열은 1부터 시작하므로
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}
}
// 과정 https://gimbalja.tistory.com/271