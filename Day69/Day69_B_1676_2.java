package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day69_B_1676_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(n >= 5) {
			count += n/5;
			n /= 5;
		}
		// n이 5보다 작을 경우 0, 즉 count의 초기값을 그대로 가져가므로 따로 계산할 필요 없다

		System.out.println(count);
	}
	

}
//과정 https://gimbalja.tistory.com/176