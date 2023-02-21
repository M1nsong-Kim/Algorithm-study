package codingtestAndAlgorithm.Day178;

import java.io.*;
import java.util.*;

public class Boj1167 {
	
	static int v, node;
	static int max = Integer.MIN_VALUE;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		v = Integer.parseInt(br.readLine());
		visited = new boolean[v+1];
		
		for(int i = 0; i < v+1; i++) {	// 숫자 그대로 쓰려고
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int point = Integer.parseInt(st.nextToken());
			
			while(true) {
				int linkedP = Integer.parseInt(st.nextToken());
				if(linkedP == -1) {
					break;
				}
				int distance = Integer.parseInt(st.nextToken());
				tree.get(point).add(new Node(linkedP, distance));
			}
		}
		
		dfs(1, 0);
		visited = new boolean[v+1];	// 한 번 더 돌려야하므로 방문 기록 초기화
		dfs(node, 0);
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int distance) {
		visited[x] = true;	// 방문 처리

		for(Node n : tree.get(x)) {	// 연결된 노드들 전부 탐색
			if(!visited[n.x]) {
				if(n.distance+distance > max) {
					node = n.x;		// 최장길이 노드 저장
					max = n.distance+distance;	// 최장길이 저장
				}
				dfs(n.x, n.distance+distance);
			}
		}
	}

	static class Node{
		int x;
		int distance;
		Node(int x, int distance){
			this.x = x;
			this.distance = distance;
		}
	}
}
// 과정 https://gimbalja.tistory.com/368