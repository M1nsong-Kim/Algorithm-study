package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day49_B_9012_2_Fail {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			
			try {
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					char ch = str.charAt(j);
					
					if(ch == '(') {
						st.push(ch);
					}else if (ch == ')'){
						st.pop();
					}
				}
				
				if(st.empty())
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
			catch(Exception e){
				System.out.println("NO");
			}
			
		}
	}
}	