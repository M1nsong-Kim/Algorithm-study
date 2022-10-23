package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day57_B_17298_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack();
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	//입력된 숫자대로 배열 채우기
		}
		
		for(int i = 0; i < n; i++) {
			
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {	//스택이 비어있지 않고 스택[맨윗값]이 스택[현재순서]값이 작다면
				arr[stack.pop()] = arr[i];	//arr[스택맨윗값]의 오큰수는 arr[현재순서]
			}
			
			stack.push(i);	//스택이 비어있거나 arr[스택맨윗값]이 더 크다면 push / push하면 비교값은 arr[push한 수+1]로 넘어간다
		}
		
		while(!stack.empty()) {
			arr[stack.pop()] = -1;	//스택에 남아 있는 수 = 오큰수가 없는 수의 값을 -1로
			
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');	//arr[0] ~ arr[n-1] 차례대로 나열
		}
		
		System.out.println(sb);
	}
	//https://gimbalja.tistory.com/163
}
