package codingtestAndAlgorithm.Day249;

public class Boj9465 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		
		int t = read();
		for(int i = 0; i < t; i++) {
			int n = read();
			
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for(int j = 0; j < 2; j++) {
				for(int k = 1; k < n+1; k++) {
					arr[j][k] = read();
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int j = 2; j < n+1; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		
		System.out.println(sb);
	}

	// 읽기 메서드
	static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/450
