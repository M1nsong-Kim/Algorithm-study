package codingtestAndAlgorithm.Day214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a, b);
		
		sb.append(gcd).append("\n").append(a*b/gcd);	// ★
	
		System.out.println(sb);
		br.close();
	}

	// ★
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a%b);
	}
}
// 복습 과정 https://gimbalja.tistory.com/411