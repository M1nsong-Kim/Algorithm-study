package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj17103 {
	
	public static boolean prime[] = new boolean[1_000_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int count = 0;
			int n = Integer.parseInt(br.readLine());
			get_prime();	//에라토스테네스의 체 이용
			// 소수는 2부터 시작 / 문제에 두 소수의 순서만 다른 것은 같은 파티션 -> n/2까지만
			for(int j = 2; j <= n/2; j++) {	
				if(!prime[j] && !prime[n-j]) {	// j+(n-j)=n. 둘 다 소수라면
					count++;	// 개수+1
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
		

	}
	
	//에라토스테네스의 체: false->소수
	public static void get_prime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i < Math.sqrt(prime.length); i++) {
			for(int j = i*i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/198