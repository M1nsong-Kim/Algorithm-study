package codingtestAndAlgorithm;

import java.io.*;
import java.util.Arrays;

public class Boj2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 디버깅 System.out.println("배열 : "+Arrays.toString(arr));
		
		// n = 1부터이므로 아래는 무조건 성립
		dp[0] = arr[0];
		// 와인잔이 2개 이상일 때
		if(n > 1) {
			dp[1] = arr[0]+arr[1];			
		}
		// 와인잔이 3개 이상일 때
		if(n > 2) {
			dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));			
		}
		
		for(int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		System.out.println(dp[n-1]);
		
	}
}
// 과정 https://gimbalja.tistory.com/267