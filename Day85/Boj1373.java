package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1373 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String binary = br.readLine();
		int len = binary.length();
		
		// 정수char - '0' = 정수
		if(len%3 == 2) { // 3개씩 끊고 2개 남음
			sb.append((binary.charAt(0)-'0')*2 + (binary.charAt(1)-'0'));
		} else if(len%3 == 1) { // 3개씩 끊고 1개 남음
			sb.append(binary.charAt(0)-'0');
		}
		
		//3개씩 끊기는 수
		for(int i = len%3; i < len; i+=3) {
			sb.append((binary.charAt(i)-'0')*4+(binary.charAt(i+1)-'0')*2+(binary.charAt(i+2)-'0')*1);
		}
		
		System.out.println(sb);
	}

}
// 과정 https://gimbalja.tistory.com/193