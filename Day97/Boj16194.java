package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16194 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] pack = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++){
			pack[i] = dp[i] = Integer.parseInt(st.nextToken());	
		}
		//System.out.println(Arrays.toString(pack));
		
		dp[1] = pack[1];
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < i+1; j++) {
				dp[i] = Math.min(dp[i], pack[j]+dp[i-j]);
				//System.out.println("dp["+i+"]: "+dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
// 과정 https://gimbalja.tistory.com/244