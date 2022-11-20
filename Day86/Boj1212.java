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
		
		switch(octal.charAt(0)-'0') {	// 첫자리엔 0이 붙어선 안 된다
		case 7 :
			sb.append(111);
			break;
		case 6 :
			sb.append(110);
			break;
		case 5 :
			sb.append(101);
			break;
		case 4 :
			sb.append(100);
			break;
		case 3 :
			sb.append(11);
			break;
		case 2 :
			sb.append(10);
			break;
		case 1 :
			sb.append(1);
			break;
		case 0 :
			sb.append(0);	//000을 입력해도 오류가 나지 않도록
			break;
		}
		
		for(int i = 1; i < len; i++) {
			switch(octal.charAt(i)-'0') {
			case 7 :
				sb.append(111);
				break;
			case 6 :
				sb.append(110);
				break;
			case 5 :
				sb.append(101);
				break;
			case 4 :
				sb.append(100);
				break;
			case 3 :
				sb.append("011");	// 문자열이 아닌 숫자로 입력하면 앞에 붙은 0이 생략된다
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
		System.out.println(sb);
	}

}
