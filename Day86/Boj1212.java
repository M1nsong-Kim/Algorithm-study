package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1212 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String octal = br.readLine();
		int len = octal.length();
		
		for(int i = 0; i < len; i++) {
			switch(octal.charAt(i)-'0') {
			case 7 :
				sb.append("111");
				break;
			case 6 :
				sb.append("110");
				break;
			case 5 :
				sb.append("101");
				break;
			case 4 :
				sb.append("100");
				break;
			case 3 :
				sb.append("011");
				break;
			case 2 :
				sb.append("010");
				break;
			case 1 :
				sb.append("001");
				break;
			case 0 :
				sb.append("000");
				break;
			}
		}

		// 앞애 0이 붙는 최대 개수는 2개 -> 0은 최대 2번 삭제
		for(int i = 0; i < 2; i++) {
			if(sb.charAt(0) - '0' == 0) { //0으로 시작한다면
				sb.deleteCharAt(0);
			}
		}
		System.out.println(sb);
	}

}
// 과정 https://gimbalja.tistory.com/194