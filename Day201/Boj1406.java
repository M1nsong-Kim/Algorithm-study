package codingtestAndAlgorithm.Day201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stL = new Stack<>();	// ★
		Stack<Character> stR = new Stack<>();	// ★
		
		
		String str = br.readLine();
		int n = str.length();		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			stL.push(str.charAt(i));	// 주어진 문자열 왼쪽 스택에 넣기
		}
		for(int i = 0; i < m; i++) {
			String st = br.readLine();
			char ch = st.charAt(0);
			
			switch(ch) {
				case 'L':
					if(!stL.isEmpty()) {
						stR.push(stL.pop());
					}
					break;
				case 'D':
					if(!stR.isEmpty()) {
						stL.push(stR.pop());
					}
					break;
				case 'B':
					if(!stL.isEmpty()) {
						stL.pop();
					}
					break;
				case 'P':
					stL.push(st.charAt(2));
					break;
			}
		}
		
		while(!stL.isEmpty()) {
			stR.push(stL.pop());
		}
		while(!stR.isEmpty()) {	// ★ 왼쪽에서 오른쪽으로 넘긴 후 출력
			sb.append(stR.pop());
		}
		System.out.println(sb);
	}

}
// 복습 과정 https://gimbalja.tistory.com/396