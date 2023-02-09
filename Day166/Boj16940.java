package codingtestAndAlgorithm.Day166;

import java.io.*;
import java.util.*;

public class Boj16940 {

	static int n;
	static int idx = 1;	// 두번째부터 비교.확인
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] store;
	static int result = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		store = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			// 양방향
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			store[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		if(store[0] != 0) {	// 시작점이 달라지면 프로그램 종료
			System.out.println(0);
			return;
		}
		
		bfs(0);
		System.out.println(result);
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);	// 탐색 시작
		visited[x] = true;	// 방문 처리
		
		while(!q.isEmpty()) {
			HashSet<Integer> set = new HashSet<>();
			
			int val = q.poll();
			
			// 가능한 경로 확인
			for(int next : list.get(val)) {
				if(!visited[next]) {
					set.add(next);
					visited[next] = true;
				}
			}
			
			int size = set.size();
			if(size == 0) {
				return;
			}

			for(int i = idx; i < idx+size; i++) { // 다음 자리부터 가능한 자리까지
				if(set.contains(store[i])) {	// set에 들어가있다 == 자식 노드다
					q.add(store[i]);			// 큐에 넣기
				}else {
					result = 0;
					return;
				}
			}
			idx += size;
		}
	}
}
// 과정 https://gimbalja.tistory.com/350