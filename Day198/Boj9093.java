package codingtestAndAlgorithm.Day198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String str = br.readLine() + "\n";	// ★: +"\n"
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ' ' || str.charAt(j) == '\n') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
//					sb.append(str.charAt(j));	//  ★: 이 줄 추가하면 24, 30 필요없음
				}else {
					stack.push(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
// 복습 과정 https://gimbalja.tistory.com/392