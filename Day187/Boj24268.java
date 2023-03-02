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

		if((a1 * n0 + a0 > c * n0) || (c < a1)) {
			answer = 0;
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
// 과정 https://gimbalja.tistory.com/380