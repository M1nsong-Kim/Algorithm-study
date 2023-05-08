package codingtestAndAlgorithm.Day254;

public class Boj11054 {
	
	static int[] arr, lis, lds, dp;

	public static void main(String[] args) throws Exception{
		int n = read();
		arr = new int[n];
        lis = new int[n];
        lds = new int[n];
        dp = new int[n];
        int max = 0; 

        for(int i = 0; i < n; i++) {
            arr[i] = read();
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            dp[i] = Math.max(dp[i], LIS(i)+LDS(i));
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max-1);
	}
	
	static int LIS(int n) {
        if(lis[n] == 0) {
            lis[n] = 1;
                    
            for(int i = n-1; i >= 0; i--) {
                if(arr[i] < arr[n]) {
                    lis[n] = Math.max(lis[n], LIS(i)+1);
                }
            }
        }
        return lis[n];
    }
    
    static int LDS(int n) {
        if(lds[n] == 0) {
            lds[n] = 1;
                    
            for(int i = lds.length-1; i >= n+1; i--) {
                if(arr[i] < arr[n]) {
                    lds[n] = Math.max(lds[n], LDS(i)+1);
                }
            }
        }
        return lds[n];
    }

	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/455