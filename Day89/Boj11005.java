package codingtestAndAlgorithm;

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
			}else {	// 나머지가 10 ~ 35 -> 11~36진법
				// 아스키코드: A~Z : 65~90 --> 나머지가 35 -> 36진법 -> 35-10+65 = 90(Z)
				sb.append((char)((n%b)-10+'A'));
				//sb.append((char)((n%b)+55));	위와 같음
			}
			n /= b;
		}
		sb.reverse();
		System.out.println(sb);
	}

}
// 과정 https://gimbalja.tistory.com/200