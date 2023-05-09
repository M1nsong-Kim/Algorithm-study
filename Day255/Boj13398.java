package codingtestAndAlgorithm.Day255;

public class Boj13398 {

	public static void main(String[] args) throws Exception{
		int n = read();
		int[] arr = new int[n];
        int[] dpR = new int[n];
        int[] dpL = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = read();
            dpR[i] = dpL[i] = arr[i];
        }

        int max = dpR[0];
        for(int i = 1; i < n; i++) {
            dpR[i] = Math.max(dpR[i], dpR[i-1]+arr[i]);
            max = Math.max(max, dpR[i]); 
        }
        for(int i = n-2; i >= 0; i--) {
            dpL[i] = Math.max(dpL[i], dpL[i+1]+arr[i]);
        }
        
        for(int i = 1; i < n-1; i++) {
            int exceptI = dpR[i-1]+dpL[i+1]; 
            max = Math.max(max, exceptI);
        }
        System.out.println(max);		
	}

	static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {        	
        	n = (n << 3) + (n << 1) + (c & 15);
        } 
        return isNegative ? ~n + 1 : n;
    }
}
// 복습 과정 https://gimbalja.tistory.com/456