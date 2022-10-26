package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day60_B_1918_Fail {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); 
		Stack<String> st = new Stack();
		
		//알파벳 스택에 넣기
		for(int i = 0; i < str.length(); i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				st.push((str.charAt(i))+"");		//알파벳이라면 스택에 넣는다
			}
			
		}
		
		//우선순위 : 괄호 > * / > + -
		// 1. 괄호가 있다면
		String first;
		String right;
		String left;
		if(!st.empty() && str.contains("(")) {
			first = str.charAt(str.indexOf("(")+2)+"";	//괄호 안 연산자는 ( 인덱스값부터 +2 (+1은 피연산자1)
			right = st.pop();
			left = st.pop();	//생각해보니까 늘 괄호가 오른쪽에 있는 게 아님
			st.push(left+right+first);
		}
		
		//괄호 안에 있는 연산자 어떻게 제외시키지?
		
	}

}
