package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day47_B_10828_2 {
	static int[] stack = new int[10001];
	static int size;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch (str) {
			case "push" :
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				sb.append(pop()).append("\n");
				break;
			case "size" :
				sb.append(size()).append("\n");
				break;
			case "empty" :
				sb.append(empty()).append("\n");
				break;
			case "top" :
				sb.append(top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
	static void push(int x) {
		stack[size] = x;
		size++;
	}
	
	static int pop() {
		if(size == 0)
			return -1;
		else {
			int Pop = stack[size-1];
			size--;
			return Pop;
		}
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size == 0)
			return 1;
		else
			return 0;
	}

	static int top() {
		if(size == 0)
			return -1;
		else {
			int Top = stack[size-1];
			return Top;
		}
	}
}
