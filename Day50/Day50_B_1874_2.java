package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day50_B_1874_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack();
		
		int n = Integer.parseInt(br.readLine());
		int start = 0;
		
		while(n -- > 0) {	//n번 반복
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				for(int i = start+1; i <= value; i++) {	//start+1부터 입력받은 수까지 스택에 push
					st.push(i);
					sb.append('+').append('\n');
				}
				start = value;	//오름차순으로 push해야. 어디까지 입력받았는지 알려고 value로 초기화
			}
			
			else if(st.peek() != value) {	//입력받은 값이 스택 끝값과 다르다면
				System.out.println("NO");
				return;	//프로그램 종료
			}
			
			st.pop();
			sb.append('-').append('\n');
		}
		
		System.out.println(sb);
	}

}