package codingtestAndAlgorithm.Day126;

import java.io.*;
import java.util.*;

public class Boj15650 {

	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n];
		DFS(0);
		System.out.println(sb);

	}
	
	static void DFS(int depth) {
		if(depth == m) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				DFS(depth+1);
				for(int j = i+1; j < n; j++) {
					// visited는 작은 수부터 시작 -> visited[i+1], visited[i+2], ... 에는 무조건 앞보다 큰 숫자들이 들어으므로 자동으로 오름차순
					visited[j] = false;
				}
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/291