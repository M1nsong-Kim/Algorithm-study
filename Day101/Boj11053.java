package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj11053 {

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
		}
		
		// n만큼의 수열크기 배열 구하기
		for(int i = 0; i < n; i++) {
			LIS(i);
		}
		
		long max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	public static int LIS(int n) {
		
		// 확인한 적 없으면
		if(dp[n] == 0) {
			dp[n] = 1;	// 1로 초기화(자기 자신만 갖는 수열)
			
			for(int i = n-1; i >= 0; i--) {
				if(arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], LIS(i)+1);
				}
			}
		}
		
		return dp[n];
	}

}
