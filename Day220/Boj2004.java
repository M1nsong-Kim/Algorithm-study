package codingtestAndAlgorithm.Day220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2004 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// ★ n-m
		int twoCnt = getCnt(n, 2) - getCnt(n-m, 2) - getCnt(m, 2);
		int fiveCnt = getCnt(n, 5) - getCnt(n-m, 5) - getCnt(m, 5);
		
		System.out.println(Math.min(twoCnt, fiveCnt));
		br.close();
	}
	
	// ★
	static int getCnt(int num, int divisor) {
		int count = 0;
		while(num >= divisor) {
			count += num/divisor;
			num /= divisor;
		}
		return count;
	}
}
// 복습 과정 https://gimbalja.tistory.com/420