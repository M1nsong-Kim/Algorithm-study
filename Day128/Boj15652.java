package codingtestAndAlgorithm.Day128;

import java.io.*;
import java.util.*;

public class Boj15652 {
	
	static int n, m;
	static int[] arr;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		DFS(0, 0);
		
		bw.flush();
		bw.close();

	}

	static void DFS(int start, int depth) throws IOException{
		if(depth == m) {
			for(int num : arr) {
				bw.write(num+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i < n; i++) {	// i를 매개변수 start부터
			arr[depth] = i+1;
			DFS(i, depth+1);	// 중복을 허용하도록
		}
	}
}
// 과정 https://gimbalja.tistory.com/294