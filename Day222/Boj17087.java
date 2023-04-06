package codingtestAndAlgorithm.Day222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17087 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int s = Integer.parseInt(st1.nextToken());
		int[] siblings = new int[n];
		
		for(int i = 0; i < n; i++) {
			siblings[i] = Math.abs(Integer.parseInt(st2.nextToken())-s);
		}
		
		int result = siblings[0];	// ★
		for(int i = 1; i < n; i++) {
			result = gcd(result, siblings[i]);
		}
		
		System.out.println(result);
	}

	static int gcd(int x, int y) {
		if(x % y == 0) {
			return y;
		}
		return gcd(y, x%y);
	}
}
// 복습 과정 https://gimbalja.tistory.com/422