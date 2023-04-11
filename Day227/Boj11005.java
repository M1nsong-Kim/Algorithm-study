package codingtestAndAlgorithm.Day227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		while(n > 0) {
			if(n%b < 10) {
                sb.append(n%b);
            }else {  
                sb.append((char)((n%b)+55));
            }
			// sb.append(n%b < 10? n%b :(char)((n%b)+55)); 안됨!
			n /= b;
		}
		
		sb.reverse();
		System.out.println(sb);
	}
}
// 복습 과정 https://gimbalja.tistory.com/428