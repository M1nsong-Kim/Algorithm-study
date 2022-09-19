package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day23_B_4948 {

	public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	      boolean prime[];
	        
	      while(true) {
	        int n = Integer.parseInt(br.readLine());
	            
	        if(n == 0) {
	            break;
	        }
	            
	        prime = new boolean[2 * n + 1];
	            
	        prime[0] = true;
	        prime[1] = true;
	            
	        for(int i = 2; i <= Math.sqrt(2 * n + 1); i++) {
	                for(int j = i * i; j < 2 * n + 1; j += i) {
	                    prime[j] = true;
	                }
	        }
	        
	        int count = 0;
	        for(int i = n+1; i <= 2 * n; i++) {
	                if(prime[i] == false) //false는 소수
	                count++;
	        }
	        System.out.println(count);
	     }
	}
}
