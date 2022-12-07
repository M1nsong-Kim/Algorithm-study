package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[-1]이 없으므로 dp[0]은 arr[0]값으로 초기화
		dp[0] = arr[0];
		for(int i = 1; i < n; i++) {
			// dp는 dp[i]를 구할 때 dp[i-1]을 이용하는 경우가 많다
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		// 오름차순 정렬
		Arrays.sort(dp);
		System.out.println(dp[n-1]);

	}

}
// 과정 https://gimbalja.tistory.com/251