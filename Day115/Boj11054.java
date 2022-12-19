package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj11054 {

	static int[] arr;
	static int[] lis;
	static int[] lds;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		lis = new int[n];
		lds = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 디버깅 System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			dp[i] = Math.max(dp[i], LIS(i)+LDS(i)-1);
		}
		
		int max = 0;	// dp[]는 자기 자신을 갖는 수열 때문에 무조건 1 이상
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 각 수열의 끝수가 겹치기 때문에 1을 빼준다
		System.out.println(max);
		
		

	}

	// 증가 수열
	static int LIS(int n) {
		if(lis[n] == 0) {
			lis[n] = 1;
					
			for(int i = n-1; i >= 0; i--) {
				if(arr[i] < arr[n]) {
					lis[n] = Math.max(lis[n], LIS(i)+1);
				}
			}
		}
		return lis[n];
	}
	
	// 감소 수열
	static int LDS(int n) {
		if(lds[n] == 0) {
			lds[n] = 1;
					
			for(int i = lds.length-1; i >= n+1; i--) {
				if(arr[i] < arr[n]) {
					lds[n] = Math.max(lds[n], LDS(i)+1);
				}
			}
		}
		return lds[n];
	}
	

}
// 과정 https://gimbalja.tistory.com/274