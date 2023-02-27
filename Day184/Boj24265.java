package codingtestAndAlgorithm.Day184;

import java.io.*;

public class Boj24265 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Integer.parseInt(br.readLine()); 
		// 최댓값 500,000의 제곱은 int의 범위 이상 -> long으로 커버
		long sum = 0;
		
		for(int i = 1; i < n; i++) {
			sum += i;
		}
		
		bw.write(sum+"\n");
		bw.write(2+"");
		bw.flush();
		bw.close();
	}
}