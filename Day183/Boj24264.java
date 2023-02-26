package codingtestAndAlgorithm.Day183;

import java.io.*;

public class Boj24264 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Integer.parseInt(br.readLine()); 
		// 최댓값 500,000의 제곱은 int의 범위 이상 -> long으로 커버
		
		bw.write(n*n+"\n");
		bw.write(2+"");
		bw.flush();
		bw.close();
	}
}
// 과정 https://gimbalja.tistory.com/375