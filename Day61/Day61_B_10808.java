package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day61_B_10808 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int arr[] = new int[26];	//알파벳 개수 26개
		
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)-'a']++;	
			// 각 숫자에서 'a'를 빼면 0~25 = 각 알파벳의 인덱스값
			// 'a'의 아스키코드 값인 97을 빼도 된다
		}
		
		for(int n : arr) {
			bw.write(n + " ");
		}
		bw.flush();
		bw.close();
	}

}
// 과정 https://gimbalja.tistory.com/167
