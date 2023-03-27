package codingtestAndAlgorithm.Day212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11655 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch >= 'a' && ch <= 'm') {
				ch += 13;
			}else if(ch >= 'n' && ch <= 'z') {
				ch -= 13;	// 소문자 넘어가면 -13 +26 -> -13
			}else if(ch >= 'A' && ch <= 'M') {
				ch += 13;
			}else if(ch >= 'N' && ch <= 'Z') {
				ch -= 13;	// 소문자 넘어가면 -13 +26 -> -13
			}
			
			sb.append(ch);
		}
		
		br.close();
		System.out.println(sb);

	}

}
// 복습 과정 https://gimbalja.tistory.com/408