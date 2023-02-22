package codingtestAndAlgorithm.Day179;

import java.io.*;
import java.util.*;

public class Boj1967 {
	
	static int n, diameterNode;
	static int max = Integer.MIN_VALUE;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		
		for(int i = 0; i < n+1; i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());

			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 양방향
			tree.get(parent).add(new Node(child, weight));
			tree.get(child).add(new Node(parent, weight));
		}
		
		dfs(1, 0);	// 루트 노드 = 1(지만 어느 노드에서 시작하건 상관 없음)
		visited = new boolean[n+1];	// 방문 기록 초기화
		dfs(diameterNode, 0);	// 지름 중 하나인 노드에서 출발
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int node, int weight) {
		visited[node] = true;	// 방문 처리
		
		if(weight > max) {	// 최장거리, 최장거리에 해당하는 노드 저장
			diameterNode = node;
			max = weight;
		}
	
		for(Node n : tree.get(node)) {
			if(!visited[n.x]) {
				dfs(n.x, n.weight + weight);
			}
		}
	}

	static class Node{
		int x;
		int weight;
		Node(int x, int weight){
			this.x = x;
			this.weight = weight;
		}
	}
}
// 과정 https://gimbalja.tistory.com/369