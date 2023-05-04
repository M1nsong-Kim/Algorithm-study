package codingtestAndAlgorithm.Day250;

public class Boj2156 {

	public static void main(String[] args) throws Exception{
		int n = read() + 2;	// + 2를 해서 if(n > 2) 절 등을 만들지 않게 한다
		
		int[] wine = new int[n+3];
		int[] dp = new int[n+3];
		
		for(int i = 3; i < n+3; i++) {
			wine[i] = read();
		}

		dp[3] = wine[3];
		dp[4] = wine[3] + wine[4];
		for(int i = 5; i < n+3; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]));
		}
		
		System.out.println(dp[n]);
	}

	// 읽기 메서드
	static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32) {	    	
	    	n = (n << 3) + (n << 1) + (c & 15);
	    }
	    return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/451