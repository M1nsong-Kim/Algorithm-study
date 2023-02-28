package codingtestAndAlgorithm.Day185;

import java.io.*;

public class Boj24266 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
				
		bw.write(n*n*n+"\n");	// (long)Math.pow(n,3)은 오답
		bw.write(3+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
// 과정 https://gimbalja.tistory.com/378