package codingtestAndAlgorithm.Day144;

import java.io.*;
import java.util.*;

public class Boj14501 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n];
		int[] p = new int[n];
		int[] dp = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			if(i+t[i] < n+1) {	// 기간 안에 끝나는 상담이라면
				// 시작일+상담일수(상담 끝난 다음날)의 금액 = 상담 끝난 다음날 금액 혹은 상담 시작날의 금액이 들어온 것 중 큰 쪽
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			// 이 다음 금액은 전날 혹은 현재 금액 중 큰 쪽
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[n]);	// n일차 최댓값
	}

}
// 과정 https://gimbalja.tistory.com/316