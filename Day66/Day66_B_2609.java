package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day66_B_2609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		//유클리드 호제법
		int gcd = gcd(first, second);
		int lcm = first * second / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

	public static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	
}
//과정 https://gimbalja.tistory.com/173