package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day59_B_1935 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] arr = new double[n];	
		String postfix = br.readLine();
		int length = postfix.length();
		
		Stack<Double> st = new Stack();

		for(int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(br.readLine());	//숫자 배열 생성
		}

		double result = 0;
		for(int i = 0; i < length; i++) {
			char ch = postfix.charAt(i);
			if('A'<=ch && ch <='Z') {	//요소가 알파벳이라면 스택에 넣는다
				st.push(arr[ch-'A']);
				//알파벳은 순서대로 주어지므로 'A'를 빼면 해당하는 숫자에 맞는 인덱스값이 나온다
				//arr[idx]에 저장된 숫자가 해당 알파벳 대신 스택에 들어간다
				
			}else {	//요소가 연산자라면
					double right = st.pop(); //식 기준 오른쪽에 있는 숫자 먼저 꺼내짐
					double left = st.pop();
					
					switch(ch) {	//연산자가
						case '+' :	// +라면
							result = left + right;
							st.push(result);
							break;
						case '-' :	// -라면
							result = left - right;
							st.push(result);
							break;
						case '*' :	// *라면
							result = left * right;
							st.push(result);
							break;
						case '/' :	// /라면
							result = left / right;
							st.push(result);
							break;
					}
			}
			
		}
			System.out.printf("%.2f",st.pop());

	}

}
// 과정 https://gimbalja.tistory.com/165