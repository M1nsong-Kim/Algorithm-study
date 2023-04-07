package codingtestAndAlgorithm.Day223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1373 {

	static String binary;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		binary = br.readLine();
		int len = binary.length();
		
		if(len % 3 == 2) {
			getOctal(0, 2);
		}else if(len % 3 == 1) {
			getOctal(0, 1);
		}
		
		for(int i = len % 3; i < len; i+=3) {	// ★
			getOctal(i, 3);
		}
		
		System.out.println(sb);
		br.close();
	}

	static void getOctal(int start, int cnt) {
		int sum = 0;
		for(int i = 0; i < cnt; i++) {
			sum += (binary.charAt(start+i)-'0')*(int)Math.pow(2, cnt-i-1);
		}
		sb.append(sum);
	}
}
// 복습 과정 https://gimbalja.tistory.com/423