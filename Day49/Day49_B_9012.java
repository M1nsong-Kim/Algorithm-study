package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day49_B_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String str = br.readLine()+"\n";
			
			for(int j = 0; j < str.length();j++) {
				char ch = str.charAt(j);
				
				if(ch == '(') {
					st.push(ch);
				}else if(ch == ')') {
					if(st.empty()) {
						st.push(ch);	//얘 없이 break하면 "YES"됨
						break;
					}else
						st.pop();
				}	
			}
			
			if(st.empty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
				
			st.clear();

		}

	}
}