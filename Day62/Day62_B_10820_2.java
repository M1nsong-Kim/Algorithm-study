package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day62_B_10820_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		while((str = br.readLine()) != null){
			// 소문자 대문자 숫자 공백
			int lower = 0;
			int upper = 0;
			int number = 0;
			int blank = 0;
			
			for(int i = 0; i < str.length(); i++) {
				if('a'<=str.charAt(i) && str.charAt(i)<='z') {	//소문자
					lower++;
				} else if('A'<=str.charAt(i) && str.charAt(i)<='Z') { //대문자
					upper++;
				} else if('0'<=str.charAt(i) && str.charAt(i)<='9') {	//숫자
					number++;
				} else {	//공백
					blank++;
				}
			}
			System.out.println(lower+" "+upper+" "+number+" "+blank);
		}
		br.close();
	}
}

//과정 https://gimbalja.tistory.com/168