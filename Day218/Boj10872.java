package codingtestAndAlgorithm.Day218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj10872 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(factorial(Integer.parseInt(br.readLine()))+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);	// ★
	}
}
// 복습 과정 https://gimbalja.tistory.com/416