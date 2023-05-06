package codingtestAndAlgorithm.Day252;

public class Boj11055 {

	public static void main(String[] args) throws Exception{
		int n = read();
		
		int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;
        
        for(int i = 0; i < n; i++) {
        	dp[i] = arr[i] = read();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
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
// 복습 과정 https://gimbalja.tistory.com/453