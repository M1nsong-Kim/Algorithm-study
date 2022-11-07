package codingtestAndAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day72BOJ11437Fail2 {
	static int n;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] depth;
	static int[] parent;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 트리 생성
		tree = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		StringTokenizer st = null;
		for(int i = 0; i < n - 1; i++) { //주어진 숫자로 노드 연결
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		depth = new int[n+1];
		parent = new int[n+1];
		// 2. 대상이 되는 두 노드 구하기
		dfs(1,1);
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(solve(a,b));
		}
	}
	
	// 1. 모든 노드의 깊이 계산 (dfs 이용)
	public static void dfs(int node, int currentDepth) {
		depth[node] = currentDepth;
		
		for(int child: tree.get(node)) {
			if(depth[child] == 0) {	//깊이 계산이 안 됐다면(자식 노드라면)
				dfs(child, currentDepth++);	// 깊이+1
				parent[child]=node;
			}
		}
	}
	
	public static int solve(int a, int b) {
		// 2-1. 두 노드의 깊이가 같아지도록
		while(depth[a] > depth[b]) {	// 노드 a가 더 밑에 있다면
			a = parent[a];
		}
		while(depth[a] < depth[b]) {	// 노드 b가 더 밑에 있다면
			b = parent[b];
		}
		
		
		// 2-2. 부모가 같아질 때까지 부모 방향으로 거슬러 올라가기
		while(a!=b) {	// 같은 층이지만 부모가 다르다면
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}

}
// 과정 https://gimbalja.tistory.com/179