package codingtestAndAlgorithm.Day127;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15651 {
	
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n];
		
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
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				visited[i] = false;	// 재귀를 호출하기 전에 false로 바꾸면 중복 숫자도 들어간다
				DFS(depth+1);
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/293