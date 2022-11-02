package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day67_B_1934 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a*b/gcd(a, b));
		}
	}

	public static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x%y);
	}
}
// 과정 https://gimbalja.tistory.com/174