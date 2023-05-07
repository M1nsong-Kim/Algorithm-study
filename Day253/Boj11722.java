package codingtestAndAlgorithm.Day253;

public class Boj11722 {
	
	static int[] arr, dp;
	
	public static void main(String[] args) throws Exception{
		int n = read();
		arr = new int[n];
        dp = new int[n];
        int max = 0;
        
        for(int i = 0; i < n; i++) {
        	arr[i] = read();
        	LDS(i);
        	max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
	}

	static int LDS(int n) {
	    if(dp[n] == 0) {
	        dp[n] = 1;
	            
	        for(int i = n-1; i >= 0; i--) {
	            if(arr[i] > arr[n]) {
	                dp[n] = Math.max(dp[n], LDS(i)+1);
	            }                
	        }
	    }
	    return dp[n];
	}

	
	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);	
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/454