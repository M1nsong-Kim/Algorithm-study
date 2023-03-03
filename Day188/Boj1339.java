package codingtestAndAlgorithm.Day188;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj1339 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] alphabet = new int[26];	// A~Z
	
		// 입력값 넣기
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				alphabet[str.charAt(j)-'A'] += (Math.pow(10, str.length()-j-1));
			}
		}
		
		Arrays.sort(alphabet);

		int num = 9;	// 0~9
		int sum = 0;
		for(int i = 25; i > 16; i--) {	// 수 최대 8자리
			sum += alphabet[i]*num;
			num--;
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
// 과정 https://gimbalja.tistory.com/381