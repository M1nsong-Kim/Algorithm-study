package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Day60_B_1918_2 {
	//우선순위 부여
	public static int priority(char ch) {
		if(ch == '(')
			return 0;
		else if(ch == '+' || ch == '-')
			return 1;
		else 				// (ch == '*' || ch == '/')
			return 2;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> st = new Stack();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('A' <= ch && ch <= 'Z') { //알파벳(피연산자)이라면
				bw.write(ch);	//그대로 출력한다
			} else if(ch == '(') {	//괄호 시작이라면
				st.push(ch);	//스택에 ( 추가
			} else if(ch == ')') {	//괄호 끝이라면
				while(!st.empty()) {
					if(st.peek() == '(') {
						st.pop();		//스택에서 ( 만나면 버리고 멈추기
						break;
					}
					bw.write(st.pop());	//스택 빌 때까지 연산자 출력
				}
			} else {	//괄호 없는 사칙연산이라면
				//스택이 비어있지 않고, 스택에 있는 값의 우선순위가 높거나 같다면(즉, *나 /라면)
				while(!st.empty() && priority(st.peek())>=priority(ch)) {
					bw.write(st.pop());	//연산자 출력
				}
				st.push(ch);	//우선순위 작은 연산자면 다시 스택에 넣는다
			}
		}
		
		while(!st.empty()) {
			bw.write(st.pop());	//스택 빌 때까지 남은 연산자 차례대로 출력
		}
		bw.flush();
		bw.close();
	}
}
// 과정 https://gimbalja.tistory.com/166