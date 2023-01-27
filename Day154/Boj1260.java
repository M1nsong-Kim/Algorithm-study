package codingtestAndAlgorithm.Day154;

import java.io.*;
import java.util.*;

public class Boj1260 {

	static int n,m,v;
	static int[][] matrix;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static Queue<Integer> queue = new LinkedList<>();	// BFS
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{	// DFS와 BFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());	// 정점 개수
		m = Integer.parseInt(st.nextToken());	// 간선 개수
		v = Integer.parseInt(st.nextToken());	// 탐색 시작할 정점 번호
		matrix = new int[1001][1001];
		visited = new boolean[1001];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 양방향 간선
			matrix[x][y] = matrix[y][x] = 1;
		}
		DFS(v);
		Arrays.fill(visited, false); 	// 방문 여부 초기화
		bw.newLine();
		BFS();
		bw.flush();
		bw.close();
	}

	static void DFS(int a) throws IOException{
		visited[a] = true;	// 방문처리
		bw.write(a+" ");
		
		for(int i = 1; i < n+1; i++) {
			if(matrix[a][i] == 1 && !visited[i]) {	// 인접했지만 방문한 적 없는 노드
				DFS(i);	// DFS 호출
			}
		}
	}
	
	static void BFS() throws IOException{
		queue.add(v);	// 탐색 시작할 정점 번호
		visited[v] = true;	// 방문 처리
		
		while(!queue.isEmpty()) {	// 큐가 빌 때까지
			v = queue.poll();	// 큐에서 꺼내기
			bw.write(v+" ");
			
			for(int i = 1; i < n+1; i++) {
				if(matrix[v][i] == 1 && !visited[i]) {	// 인접했지만 방문한 적 없는 노드
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
}
// 과정 https://gimbalja.tistory.com/328