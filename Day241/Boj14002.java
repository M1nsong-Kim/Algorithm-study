package codingtestAndAlgorithm.Day241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj14002 {
	
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			LIS(i);
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		sb.append(max).append("\n");

		int idx = max;
		for(int i = n-1; i >= 0; i--) {
			if(dp[i] == idx) {
				stack.push(arr[i]);
				idx--;
			}
		}
		
		for(int i = 0; i < max; i++) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static int LIS(int n) {
		if(dp[n] == 0) {
			dp[n] = 1;
			
			for(int i = n-1; i >= 0; i--) {
				if(arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], LIS(i)+1);					
				}
			}
		}
		return dp[n];
	}
}
// 복습 과정 https://gimbalja.tistory.com/442