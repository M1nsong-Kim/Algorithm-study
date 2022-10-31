package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Day65_B_11656 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String arr[] = new String[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = "";
			for(int j = i; j < str.length(); j++) {
				arr[i] += str.charAt(j);	//2중for문으로 한 글자씩 빼면서 배열에 담기
			}
		}
		// System.out.println(Arrays.toString(arr)); 디버깅코드
		
		Arrays.sort(arr, new Comparator <String>(){
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);	//compareTo는 사전순 배열
			}
		});
		
		for(String s : arr) {
			System.out.println(s);
		}

	}

}
// 과정 https://gimbalja.tistory.com/172