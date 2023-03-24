package codingtestAndAlgorithm.Day209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1935 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		double[] nums = new double[n];
		String str = br.readLine();
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				stack.push(nums[ch-'A']);
			}else {
				double right = stack.pop();	// ★ right 먼저 꺼냄
				double left = stack.pop();
				
				switch(ch) {
					case '+':
						stack.push(left+right);
						break;
					case '-':
						stack.push(left-right);
						break;
					case '*':
						stack.push(left*right);
						break;
					case '/':
						stack.push(left/right);
						break;
				}
			}
		}

		System.out.printf("%.2f", stack.pop());	// ★ 소수점 뒤 두 글자
	}

}
// 복습 과정 https://gimbalja.tistory.com/404