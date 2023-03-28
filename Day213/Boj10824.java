package codingtestAndAlgorithm.Day213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10824 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken()+st.nextToken());
		long b = Long.parseLong(st.nextToken()+st.nextToken());

		System.out.println(a+b);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/409