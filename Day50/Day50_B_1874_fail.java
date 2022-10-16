package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day50_B_1874_fail {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack();
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int stack[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			stack[i] = i+1;
		}
		
		try {
		// try문 안
		int idx = 0;
		st.push(stack[0]);
		for(int i = 0; i < n; i++) {
			while(arr[i] != st.peek()) {
				st.push(stack[idx]);
				idx++;
				System.out.println("+");
			}
			
			if(arr[i] == st.peek()) {
				st.pop();
				System.out.println("-");
			}
			
		} // try문 안
		}
		catch(Exception e) {
			System.out.println("NO");
		}
	


	}

}