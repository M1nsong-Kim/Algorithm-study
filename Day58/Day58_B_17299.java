package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day58_B_17299 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		int count[] = new int[1_000_001];
		
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stn.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i < n; i++) {
			
			//스택이 비어있지 않고 현재 위치가 스택에 들어있는 이전 숫자보다 빈도수가 높다면
			while(!st.empty() && count[arr[i]] > count[arr[st.peek()]]) {	
				arr[st.pop()] = arr[i];	//현재 숫자를 넣는다
			}
			
			st.push(i);
		}
		
		while(!st.empty()) {
			arr[st.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);

	}

}
// https://gimbalja.tistory.com/164 과정