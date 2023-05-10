package codingtestAndAlgorithm.Day256;

public class Boj17404 {

	public static void main(String[] args) throws Exception{
		int n = read();
		int[][] house = new int[n][3];
		int[][] dp = new int[n][3];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				house[i][j] = read();
			}
		}
		
		for(int first = 0; first < 3; first++) {
			for(int i = 0; i < 3; i++) {
				if(i != first) {
					dp[0][i] = 1_001;
				}else {
					dp[0][i] = house[0][i];
				}
			}
			
			for(int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
			}
			
			for(int i = 0; i < 3; i++) {
				if(i != first) {
					min = Math.min(min, dp[n-1][i]);
				}
			}
		}
		
		System.out.println(min);
	}

	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/457