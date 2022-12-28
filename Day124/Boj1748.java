package codingtestAndAlgorithm.Day124;

import java.io.*;

public class Boj1748 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		int cipher = 1;	// 자릿수 ( 1~10: 1, 11~100: 2, ...
		int standard = 10;
		for(int i = 1; i <= n; i++) {
			if(i % standard == 0) {
				cipher++;	// 기준으로 나누어 떨어진다 -> 자릿수가 바뀌었다 -> 자릿수 +1
				standard *= 10; // 10, 100, 1000 ... 으로 기준을 늘린다(자릿수 바뀌는 수가 기준)
			}
			count += cipher;
		}
		
		System.out.println(count);

	}

}
// 과정 https://gimbalja.tistory.com/289