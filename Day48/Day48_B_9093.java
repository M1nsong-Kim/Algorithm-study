package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Day48_B_9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> st = new Stack();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String str = br.readLine() + "\n";	//줄바꿈
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ' ' || str.charAt(j) == '\n') {	//공백이거나 줄바꿈 만나면
					while(!st.empty()) {	//스택이 빌 때까지
						bw.write(st.pop());	//출력
					}
					bw.write(str.charAt(j)); //공백 그대로 출력
				}else {
					st.push(str.charAt(j));	//공백 아니라면 스택에 추가
			}
			}
		}
		bw.flush();
		bw.close();
	}

}