package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj17404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n][3];
		int[][] dp = new int[n][3];		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 디버깅 System.out.println(Arrays.deepToString(rgb));
		
		int min = Integer.MAX_VALUE;
		for(int first = 0; first < 3; first++) {
		// 0: 빨강, 1: 초록, 2: 파랑
		// 첫번째 선택된 색에 따라 나누기
			
			for(int i = 0; i < 3; i++) {
				// 내가 선택하려는 색이 아니면
				if(i != first) {
					// 첫번째 집으로 선택되지 않도록 최고값으로 설정
					dp[0][i] = 1_001;
				}else {
					// 내가 선택하려는 색의 값은 문제에 주어진 값 그대로
					dp[0][i] = rgb[0][i];
				}
			}
			
			for(int i = 1; i < n; i++) {
				// 빨강일 땐 그전 색깔이 초록/파랑 중 작은 값에 더함
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
				// 초록일 땐 그전 색깔이 빨강/파랑 중 작은 값에 더함
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
				// 파랑일 땐 그전 색깔이 빨강/초록 중 작은 값에 더함
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
			}
			
			for(int i = 0; i < 3; i++) {
				if(i != first) {	// 마지막집의 색깔이 첫번째 색깔과 겹치지 않도록 조건 설정
					min = Math.min(min, dp[n-1][i]);
				}
			}
		}
		
		System.out.println(min);
		
	}

}
// 과정 https://gimbalja.tistory.com/280