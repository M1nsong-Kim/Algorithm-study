package codingtestAndAlgorithm.Day215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			boolean prime = true;	// 소수면 true
			int num = Integer.parseInt(st.nextToken());
		
			if(num == 1) {
				continue;
			}
			
			for(int j = 2; j <= Math.sqrt(num); j++) {	// ★★등호
				if(num % j == 0) {	// ★ 나누어 떨어지는 수가 있다면
					prime = false;	// 소수 아님
					break;
				}
			}
			if(prime) {
				count++;
			}
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/413