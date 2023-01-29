package codingtestAndAlgorithm.Day156;

import java.io.*;
import java.util.*;

public class Boj11724 {
	
	static int n, m, component;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());	// 정점(노드) 개수
		list = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
		m = Integer.parseInt(st.nextToken());	// 간선 개수
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u-1].add(v-1);	// 1~n까지라서 인덱스인 0~n-1에 넣으려고 -1 해줌
			list[v-1].add(u-1);
		}
		
		for(int i = 0; i < n; i++) {	
			if(!visited[i]) {	// 이미 수행한 그래프 요소는 넘어가고, 다음 그래프가 있다면 수행됨	
				DFS(i);	// DFS 끝까지 수행하면 연결 요소 +1
				component++;
			}
		}
		bw.write(component+"");
		bw.flush();
		bw.close();
	}
	
	static void DFS(int a) {
		visited[a] = true;	// 방문 처리
		
		for(int val : list[a]) {
			if(!visited[val]) {
				DFS(val);
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/331