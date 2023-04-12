package codingtestAndAlgorithm.Day228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2745 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int idx = n.length() - 1;
		int sum = 0;
		
		for(int i = 0; i < n.length(); i++) {
			int ch = n.charAt(i) - '0';

			if(ch > 16) {	// 'A' ~ 'Z'
				ch -= 7;	// 아스키코드로 '0'이 48이라서 총 55를 빼려면 -7 필요
			}

			sum += ch*Math.pow(b, idx);
			idx--;
		}

		System.out.println(sum);
	}

}
// 복습 과정 https://gimbalja.tistory.com/429