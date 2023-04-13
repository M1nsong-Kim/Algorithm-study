package codingtestAndAlgorithm.Day229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		
		int sum = 0;
		int idx = m-1;
		for(int i = 0; i < m; i++) {
			int n = Integer.parseInt(st2.nextToken());
			sum += n * Math.pow(a, idx);
			idx--;
		}

		while(sum != 0) {
			sb.insert(0, sum % b+" ");	// 앞에 넣으면 reverse() 필요 없음
			sum /= b;
		}
		
		System.out.println(sb);
		br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/430