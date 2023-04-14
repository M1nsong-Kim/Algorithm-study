package codingtestAndAlgorithm.Day230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11653 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 2; i*i <= N; i++) {
			while(N % i == 0) {
				sb.append(i).append("\n");
				N /= i;
			}
		}
		if(N > 1) {	// 2 이상으로 남았을 때
			sb.append(N);
		}
		
		System.out.println(sb);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/431