package codingtestAndAlgorithm.Day165;

import java.io.*;
import java.util.*;

public class Boj16964 {

	static int n;
	static int idx= 1; // 루트 다음 숫자부터 -> 2번째부터
	static int result = 1;
	static ArrayList<Integer>[] list;
	static int[] store;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		store = new int[n];
		visited = new boolean[n];

		for(int i = 0; i < n; i++) {			
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;	// 인덱스 맞추기 위함
			int y = Integer.parseInt(st.nextToken())-1;
			// 양방향
			list[x].add(y);
			list[y].add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			store[i] = Integer.parseInt(st.nextToken())-1;
		}	
		
		dfs(0);
		System.out.println(result);
	}

	static void dfs(int x) {
		visited[x] = true;
		HashSet<Integer> set = new HashSet<>();	// 중복이 없는 set
		for(int next : list[x]) {
			if(!visited[next]) {
				set.add(next);	// x의 자식 노드들 저장
			}
		}
		// 자식이 없는 노드라면 끝내기
		if(set.size() == 0) {
			return;
		}
		if(set.contains(store[idx])) {	// 노드의 다음에 올 수 있는 후보 중 하나(즉, 자식 노드 중 하나)라면
			dfs(store[idx++]);			// 계속 진행
		}else {
			result = 0;
			return;
		}
	}
}
// 과정 https://gimbalja.tistory.com/345