package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj14002 {

	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			LIS(i);
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);

		int sequence = max;
		for(int i = n-1; i >= 0; i--) {	// 앞서 구한 수열의 최대 크기서부터 1이 될 때까지 
			if(dp[i] == sequence) {	// 수열 크기 값이 같으면
				stack.push(arr[i]);	// 스택에 저장
				sequence--;	// 크기가 같은 수열이 2개 이상 출력되지 않도록 바로 -1을 해준다
			}
		}
		
		// 수열의 개수 = 앞서 구한 수열의 최대크기
		for(int i = 0; i < max; i++) {
			// 수열의 최대 크기부터 거꾸로 넣었으므로 스택으로 꺼내는 것이 적절하다
			System.out.print(stack.pop()+" ");
		}
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
// 과정 https://gimbalja.tistory.com/250