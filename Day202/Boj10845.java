package codingtestAndAlgorithm.Day202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10845 {

	static int[] queue = new int[10_001];
	static int start = 0;
	static int end = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					bw.write(pop()+"\n");
					break;
				case "size":
					bw.write((end-start)+"\n");
					break;
				case "empty":
					bw.write(empty()+"\n");
					break;
				case "front":
					bw.write(front()+"\n");
					break;
				case "back":
					bw.write(back()+"\n");
					break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void push(int x) {
		queue[end] = x;
		end++;
	}
	
	static int pop() {
		if(start == end) {
			return -1;
		}else {
			return queue[start++];
		}
	}
	
	static int empty() {
		if(start == end) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static int front() {
		if(start == end) {
			return -1;
		}else {
			return queue[start];
		}
	}
	
	static int back() {
		if(start == end) {
			return -1;
		}else {
			return queue[end-1];
		}
	}
}
// 복습 과정 https://gimbalja.tistory.com/397