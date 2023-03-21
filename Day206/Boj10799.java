package codingtestAndAlgorithm.Day206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int stack = 0;
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack++;
			}else {	//) 라면
				if(str.charAt(i-1) == '(') {	// 레이저
					stack--;
					sum += stack;
				}else {	// 그냥 쇠막대기 끝남
					stack--;
					sum += 1;	// 조각 1개 추가
				}
			}
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/401