package codingtestAndAlgorithm.Day251;

public class Boj1932 {

	public static void main(String[] args) throws Exception{
		int n = read();
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < i+1; j++) {
                dp[i][j] = read();
            }
        }
        
        int max = dp[1][1];    // 1줄이면 자기 자신이 최대값        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < i+1; j++) {
                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
	}

	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/452