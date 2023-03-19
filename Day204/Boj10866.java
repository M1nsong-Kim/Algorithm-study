package codingtestAndAlgorithm.Day204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10866 {
	
	static int[] deque = new int[10_000];
	static int start = 0;
	static int end = 0;
	static int size = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
				case "push_front":
					push_front(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					push_back(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					bw.write(pop_front()+"\n");
					break;
				case "pop_back":
					bw.write(pop_back()+"\n");
					break;
				case "size":
					bw.write(size+"\n");
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

	static void push_front(int x) {
		deque[start] = x;
		start = (start - 1 + 10_000) % 10_000;
		size++;
	}
	
	static void push_back(int x) {	// queue와 유사
		end = (end + 1) % 10_000;
		deque[end] = x;
		size++;
	}
	
	static int pop_front() {
		if(size == 0) {
			return -1;
		}else {
			start = (start + 1) % 10_000;
			size--;
			return deque[start];
		}
	}
	
	static int pop_back() {
		if(size == 0) {
			return -1;
		}else {
			int back = deque[end];
			end = (end - 1 + 10_000) % 10_000;
			size--;
			return back;
		}
	}
	
	static int empty() {
		if(size == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static int front() {
		if(size == 0) {
			return -1;
		}else {
			return deque[(start + 1) % 10_000];
		}
	}
	
	static int back() {
		if(size == 0) {
			return -1;
		}else {
			return deque[end];
		}
	}
}
// 복습 과정 https://gimbalja.tistory.com/399