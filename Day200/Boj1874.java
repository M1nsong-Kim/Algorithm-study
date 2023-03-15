package codingtestAndAlgorithm.Day200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	// ★
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int start = 0;	// ★
		
		for(int i = 1; i < n+1; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > start) {	// ★ start와 비교
				for(int j = start+1; j < num+1; j++) {	// ★ for문 위치
				stack.push(j);
				sb.append("+\n");
				}
				start = num;
			}
			// ★ else if문 전체
			else if(stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/394