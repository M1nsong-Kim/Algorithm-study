package codingtestAndAlgorithm.Day187;

import java.io.*;
import java.util.*;

public class Boj24268 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 1;
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());

		for(int n = n0; n < 101; n++) {
			if(a1*n + a0 > c*n) {
				answer = 0;
				break;
			}
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
// 과정 https://gimbalja.tistory.com/380