package codingtestAndAlgorithm.Day211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10820 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = null;	// ★
		
		while((str = br.readLine()) != null) {	// ★
			int lower = 0;
			int upper = 0;
			int num = 0;
			int space = 0;
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch >= 'a' && ch <= 'z') {	// 소문자
					lower++;
				}else if(ch >= 'A' && ch <= 'Z') {	// 대문자
					upper++;
				}else if(ch == ' ') {	// 공백 (조건 짧음)
					space++;
				}else {
					num++;
				}
			}
			
			// 출력
			sb.append(lower).append(' ').append(upper).append(' ').append(num).append(' ').append(space).append('\n');
		}
		
		br.close();
		System.out.println(sb);

	}

}
// 복습 과정 https://gimbalja.tistory.com/407