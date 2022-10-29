package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day63_B_11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('a' <= ch && ch <= 'z') {	//소문자라면
				ch += 13;	//13을 민다
				if(ch > 'z') {			//알파벳 범위를 넘어간다면
					ch -= 26;		//26(알파벳 총 개수)를 빼준다 (순환 위함)
				}
			} else if('A' <= ch && ch <= 'Z') {	//대문자라면
				ch += 13;
				if(ch > 'Z') {			//알파벳 범위를 넘어간다면
					ch -= 26;		//26을 뺴준다
				}
			}
			
			sb.append(ch);	//문자열의 문자 하나하나씩 붙이기
		}
		
		System.out.println(sb);
	}

}
// 과정 https://gimbalja.tistory.com/170