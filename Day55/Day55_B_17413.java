package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day55_B_17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack();
		
		String str = br.readLine();
		boolean flag = false;	//true: < > 안, false: < > 밖
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				flag = true;
				while(!st.empty()) {
					sb.append(st.pop());	// '<' 전에 있는 것들 모두 거꾸로 출력
				}
				sb.append(str.charAt(i));	// '<' 출력
			}else if(str.charAt(i) == '>') {
				flag = false;	// > 으로 <> 밖으로 나가면 false로 변경
				sb.append(str.charAt(i));	// '>' 출력
			}else if(flag) {	// < > 안에 있다면
				sb.append(str.charAt(i));	//그대로 출력
			}
			else {								// <> 안에 있지 않고
				if(str.charAt(i) == ' ') {
					while(!st.empty()) {
						sb.append(st.pop());	//공백 전에 있는 것들 모두 거꾸로 출력
					}
					sb.append(str.charAt(i)); 	//공백 출력
				}else {
					st.push(str.charAt(i));	//스택 비어 있으면 푸시
				}
			}
		}
		while(!st.empty()) {    //스택 빌 때까지
			sb.append(st.pop());    //거꾸로 출력
		}
		System.out.println(sb);
		
	}

}
