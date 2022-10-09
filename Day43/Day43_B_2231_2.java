package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day43_B_2231_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0){
				sum += num % 10;
				num /= 10;
			}
			
			if(n == sum+i) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
}