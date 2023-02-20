package codingtestAndAlgorithm.Day177;

import java.io.*;
import java.util.*;

public class Boj11725 {

	static int n;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		parent = new int[n];
		
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < n-1; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;	// n개만 만들기 위해 -1
			int y = Integer.parseInt(st.nextToken())-1;
			tree.get(x).add(y);
			tree.get(y).add(x);
		}
		bfs();
		for(int i = 1; i < n; i++) {	// 2부터 부모 구함
			bw.write(parent[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
	// 부모 찾기
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);	// 1부터 시작(하지만 인덱스 떄문에 0부터)
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : tree.get(now)) {	// 현재 노드와 연결된 모든 수
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
					parent[i] = now+1;	// 부모 저장할 땐 앞서 빼준 +1
				}
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/367