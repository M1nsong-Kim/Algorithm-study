package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Day48_B_9093_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> st = new Stack();
		
		int t = Integer.parseInt(br.readLine());
		

		for(int i = 0; i < t; i++) {
			String str = br.readLine() + "\n";
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ' ' || str.charAt(j) == '\n') {
					while(!st.empty()) {
						bw.write(st.pop());
					}
					bw.write(str.charAt(j));
				}else {
					st.push(str.charAt(j));
				}
			}
		}
		bw.flush();
		bw.close();
	}

}