package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day68_B_6588_failTimeOver {
	// 6 <= n <= 1,000,000
	public static boolean prime[] = new boolean[1_000_000];

	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringBuilder sb = new StringBuilder();
	
	int n = 0;
	
	while((n = Integer.parseInt(br.readLine())) != 0) {
		int a = 3;
		int b = n - a;
		
		getPrime();
		while(a <= n) {	//a가 n보다 커지면 안됨
			if(prime[a] == false && prime[b] == false) {
				break;
			}else {
				a += 2;	//a는 홀수
				b -= 2;
			}
		}
		if(a < n) {
			sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");			
		}else {
			sb.append("Goldbach's conjecture is wrong.").append("\n");
		}
	}
	
	bw.write(sb.toString());
	bw.flush();
	bw.close();
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
// 시간초과
// 과정 https://gimbalja.tistory.com/175