package codingtestAndAlgorithm.Day231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(recursion(n, 0));
	}

	// 재귀
	static int recursion(int n, int count) {
		if(n < 2) {
			return count;
		}
		// n%2 혹은 n%3 -> -1하는 횟수와 같다
		return Math.min(recursion(n/2, count+1+n%2), recursion(n/3, count+1+n%3));
	}
}
// 복습 과정 https://gimbalja.tistory.com/432