package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2745 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());


		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int idx = n.length() - 1;	//제곱은 왼쪽이 가장 큰 수
		for(int i = 0; i < n.length(); i++) {
			char ch = n.charAt(i);
			if('0' <= ch && ch <= '9') {
				sum += (ch-'0')*Math.pow(b, idx);	// b의 idx 제곱
			}else { // // 아스키코드: A~Z : 65~90 / '10' 이상 -> 55 빼줘서 각 숫자에 맞추기(A->10, B->11, ... Z->35)
				sum += (ch-55)*Math.pow(b, idx);
			}
			idx--;
		}
		bw.write(sum+"");

		bw.flush();
		bw.close();
	}
}
// 과정 https://gimbalja.tistory.com/202