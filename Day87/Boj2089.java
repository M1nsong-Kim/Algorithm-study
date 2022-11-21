package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2089 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
		}else {
			while(n != 1) {
				// 10진수 -> n진수 : n으로 계속 나눈다
				sb.append(Math.abs(n % -2));	//나머지는 양수여야 한다 -> 절대값
				n = (int)Math.ceil((double)n / -2);
				// -2.4가 있을 때, 올림해야 -2가 된다 (내림하면 -3으로 원하지 않는 결과가 나옴)
			}
			
			sb.append(n);
			System.out.println(sb.reverse());
		}
	}
	
}
// 과정 https://gimbalja.tistory.com/196