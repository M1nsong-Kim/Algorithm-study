package codingtestAndAlgorithm;

import java.io.*;

public class Boj10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[101][10];
		int mod = 1_000_000_000;
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;	//1자리수에는 각각의 수가 들어가는 경우만 가능
		}
		
		for(int i = 2; i < n+1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					// i번째 수가 0이라면 i-1번째에는 1만 올 수 있다
					dp[i][0] = dp[i-1][1] % mod;
				}else if(j == 9) {
					// i번째 수가 9라면 i-1번째에는 8만 올 수 있다
					dp[i][9] = dp[i-1][8] % mod;
				}else {
					// i번째 수가 1~8이라면 i-1번째에는 [0,2]~[7,9]가 올 수 있다
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			// 오버플로우를 막기 위한 % 연산
			answer += dp[n][i] % mod;
			answer %= mod;
		}
		
		System.out.println(answer);
		
	}

}
// 과정 https://gimbalja.tistory.com/247