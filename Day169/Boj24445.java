package codingtestAndAlgorithm.Day169;

import java.io.*;
import java.util.*;

public class Boj24445 {

	static int n, m, r;
	static int count = 1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new int[n+1];
		
		for(int i = 0; i < n+1; i++) {	// 정점마다 연결
			graph.add(new ArrayList<Integer>());
		}
		
		// 그래프 그리기
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			//양방향
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		// 내림차순 정렬
		for(int i = 1; i < n+1; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		// 시작 정점
		bfs(r);
		for(int i = 1; i < n+1; i++) {
			System.out.println(visited[i]);
		}
		br.close();
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = count++;	// 방문 및 방문 순서 저장
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph.get(now)) {
				if(visited[next] == 0) {	// 아직 방문 전
					visited[next] = count++;	// 방문 순서 저장
					q.add(next);
				}
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/354