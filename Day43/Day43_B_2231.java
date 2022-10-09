package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day43_B_2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num % 10; //자리수마다 더하기
				num /= 10;		//10씩 나누면 자리수마다 구할 수 있다 
			}
			
			if(sum + i == n) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
}