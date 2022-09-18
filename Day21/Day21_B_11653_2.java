package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day21_B_11653_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= n; i++) {
			while(true) {
				if(n % i == 0) {
					n /= i;
					System.out.println(i);
				}
				else break;
			}
		}
	}

}
