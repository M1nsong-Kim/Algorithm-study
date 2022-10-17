package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day51_B_1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack stL = new Stack();
		Stack stR = new Stack();
		
		String str = br.readLine();
		int n = str.length();
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			stL.push(str.charAt(i));
		}
		
		for(int i = 0; i < m; i++) {
			String Command = br.readLine();
			char ch = Command.charAt(0);
			
			switch(ch) {
				case 'L' :
					if(!stL.empty()) {
						stR.push(stL.pop());
					}
					break;
				case 'D' :
					if(!stR.empty()) {
						stL.push(stR.pop());
					}
					break;
				case 'B' :
					if(!stL.empty()) {
						stL.pop();
					}
					break;
				case 'P' :
					stL.push(Command.charAt(2));
					break;
			}
			
		}
		
		while(!stL.empty()) {
			stR.push(stL.pop());
		}
		while(!stR.empty()) {
			sb.append(stR.pop());
		}
		System.out.println(sb);
	}

}