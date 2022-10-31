package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Day65_B_11656_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String arr[] = new String[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, str.length());
		}
		
		Arrays.sort(arr);
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
//과정 https://gimbalja.tistory.com/172