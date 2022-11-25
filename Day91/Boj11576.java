package codingtestAndAlgorithm;

import java.util.Scanner;
import java.util.Stack;

public class Boj11576 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		// 10진수로 바꾸기
        int sum = 0;
        int idx = m - 1;
        for(int i = 0; i < m; i++) {
            int n = sc.nextInt();
            sum += n*Math.pow(a, idx);
            idx--;
        }
        // 디버깅
//        System.out.println(sum);

        // 10진수를 b진수로 바꾸기
        while(sum != 0) {
            st.push(sum%b);
            sum /= b;
        }

        // 스택은 선입후출
        while(!st.empty()) {
        	System.out.print(st.pop() + " ");
        }
    }

}
// 과정 https://gimbalja.tistory.com/204