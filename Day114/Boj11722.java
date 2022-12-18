package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj11722 {

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
			LDS(i);	// arr[i]값을 넣으면서 dp[i]값도 구한다
		}
		// 디버깅
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		
		int max = 0;	// dp[n]은 무조건 1 이상이므로
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	static int LDS(int n) {
		if(dp[n] == 0) {
			dp[n] = 1;
			
			for(int i = n-1; i >= 0; i--) {
				if(arr[i] > arr[n]) {	//이전에 자신보다 큰값이 있다면
					dp[n] = Math.max(dp[n], LDS(i)+1);
				}				
			}
		}
		return dp[n];
	}

}
// 과정 https://gimbalja.tistory.com/272