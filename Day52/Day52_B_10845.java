package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day52_B_10845 {
	static Queue q = new LinkedList();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int last = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
				case "push":
					last = Integer.parseInt(st.nextToken());
					q.offer(last);
					break;
				case "pop":
					sb.append(pop()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					sb.append(empty()).append("\n");
					break;
				case "front":
					sb.append(front()).append("\n");
					break;
				case "back":
					if(q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(last).append("\n");
					break;
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int pop() {
		if(q.isEmpty())
			return -1;
		else {
			return (int)q.poll();	//첫번째 요소 반환 후 제거
		}
	}
	
	static int empty() {
		if(q.isEmpty())
			return 1;
		else
			return 0;
	}
	
	static int front() {
		if(q.isEmpty())
			return -1;
		else
			return (int)q.peek();	//첫번째 요소 반환
	}
	
	

}
