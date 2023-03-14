package codingtestAndAlgorithm.Day199;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int count = 0;
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					count++;
				}else {
					count--;
					// )이 더 많은 순간이 있다면 바로 종료
					if(count < 0) {
						break;
					}
				}
			}
			if(count != 0) {	// 짝이 맞지 않으면 VPS 아님
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/393