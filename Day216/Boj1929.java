package codingtestAndAlgorithm.Day216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
	
	public static boolean prime[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		prime = new boolean[n+1];
		getPrime();
		
		for(int i = m; i < n+1; i++) {
			if(!prime[i]) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	}
	
	// 에라토스테네스의 체
	public static void getPrime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i*i; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
	}

}
// 복습 과정 https://gimbalja.tistory.com/414