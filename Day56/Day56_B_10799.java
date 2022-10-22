package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day56_B_10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack();
		
		String str = br.readLine();
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {	//열리는 괄호 ( 라면
				st.push('(');			//스택에 쇠막대기 추가
			}else {			// 닫히는 괄호 ) 라면
				if(str.charAt(i-1) == '(') {	//이전이 '('라면 = 레이저라면
					st.pop();	//레이저몫 ( 하나 빼고
					sum += st.size();	//레이저라면 지금까지 스택 크기만큼 더한다
				}else {			//쇠막대가 끝난 거라면
					st.pop();	//쇠막대 개수 1개 줄이고
					sum += 1;	//1을 더한다
				}
				
			}
		}
		System.out.println(sum);
	}

}
