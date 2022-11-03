package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day68_B_6588_2 {

	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringBuilder sb = new StringBuilder();
	boolean[] prime = new boolean[1_000_001];
	
	//에라토스테네스의 체
	prime[0] = true;
	prime[1] = true;
	
	for(int i = 2; i <= Math.sqrt(prime.length); i++) {
		if(prime[i] == true) {
			continue;
		}
		for(int j = i*i; j < prime.length; j+=i) {
			prime[j] = true;
		}
	}
	
	int n = 0;
	boolean isTrue = false;	//골드바흐의 추측이 맞다면 true
	while((n = Integer.parseInt(br.readLine())) != 0) {	//0이 입력되면 끝
		// 홀수 소수끼리의 합 -> 첫 홀수 소수인 3부터 +2씩 / 대칭성때문에 n/2까지
		for(int i = 3; i <= n/2 + 1; i+=2) {	
			if( !prime[i] && !prime[n-i]) {	//둘다 소수라면
				sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");			
				isTrue = true;	//이 수에 관한 골드바흐의 추측은 맞다
				break;
			}
		}
		if(!isTrue) {	//골드바흐의 추측이 틀렸다면
			sb.append("Goldbach's conjecture is wrong.").append("\n");			
			break;
		}
		
	}
	bw.write(sb.toString());
	bw.flush();
	bw.close();
	}
}
// 과정 https://gimbalja.tistory.com/175