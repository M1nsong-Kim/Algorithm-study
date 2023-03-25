package codingtestAndAlgorithm.Day210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1918 {
	
	// ★ 연산자에 우선순위 두기
	static int priority(char ch) {
		if(ch == '(') {
			return 0;
		}else if(ch == '+' || ch == '-') {
			return 1;
		}else {
			return 2;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		// ★ 연산자를 스택에 넣기
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {	// 1. 피연산자
				sb.append(ch);
			}else {	// 2. 연산자				
				if(stack.isEmpty()){	// 비었으면 넘어가기
					stack.push(ch);
					continue;
				}else if(ch == '('){	// 2-1. 괄호
					stack.push(ch);
				}else if(ch == ')') {
					char pop = stack.pop();
					while(pop != '(') {	// 괄호면 그대로 버리기
						sb.append(pop);
						pop = stack.pop();
					}
				}else {	// 3. 연산자
					while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
						sb.append(stack.pop());
					}
					stack.push(ch);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}

}
// 복습 과정 https://gimbalja.tistory.com/405