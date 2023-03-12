package codingtestAndAlgorithm.Day197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10828 {
	
	static int[] stack = new int[10_001];
	static int size;	// ★

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					bw.write(pop()+"\n");
					break;
				case "size":
					bw.write(size+"\n");
					break;
				case "empty":
					bw.write(empty()+"\n");
					break;
				case "top":
					bw.write(top()+"\n");
					break;
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void push(int n) {
		stack[size] = n;
		size++;
	}
	
	static int pop() {
		if(size == 0) {
			return -1;
		}else{
			int val = stack[size-1];
	//			stack[size-1] = 0;	★ 있어도 되긴 하지만 의미 없음
			size--;
			return val;
		}
	}
	
	static int empty() {
		if(size == 0) {
			return 1;
		}else{
			return 0;
		}
	}
	
	static int top() {
		if(size == 0) {
			return -1;
		}else{
			return stack[size-1];
		}
	}
}
// 복습 과정 https://gimbalja.tistory.com/391