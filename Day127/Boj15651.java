package codingtestAndAlgorithm.Day127;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15651 {
	
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		DFS(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) {
		if(depth == m) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i+1;
			DFS(depth+1);
		}
	}

}
// 과정 https://gimbalja.tistory.com/293