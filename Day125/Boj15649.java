package codingtestAndAlgorithm.Day125;

import java.io.*;
import java.util.*;

public class Boj15649 {

	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n];
		DFS(n, m, 0);
		System.out.println(sb);
	}
	
	public static void DFS(int n, int m, int depth) {
		// 입력된 숫자의 깊이까지의 배열 출력
		if(depth == m) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;		// 멈추기
		}
		
		for(int i = 0; i < n; i++) {
			// 방문하지 않은 노드라면
			if(!visited[i]) {
				visited[i] = true;	// 방문상태로 변경 후 	
				arr[depth] = i+1; 	// 그 깊이의 노드에 값 넣기
				DFS(n, m, depth+1);	// 다음 노드 : 깊이+1
				visited[i] = false;	// 다시 false로 돌려서 검사할 수 있도록
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/290