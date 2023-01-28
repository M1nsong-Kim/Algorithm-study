package codingtestAndAlgorithm.Day155;

import java.io.*;
import java.util.*;

public class Boj13023 {

	static int n, m, check;
	static boolean[] visited;
	static ArrayList<Integer>[] list;	// 연결리스트
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 양방향 (x가 y랑 친구면 y도 x랑 친구)
			list[x].add(y);
			list[y].add(x);
		}
		
		for(int i = 0; i < n; i++) {
			DFS(i, 0);
			
			if(check == 1) {	// 이미 노드끼리 연결된 거 확인했으면
				break;			// 반복문 종료
			}
		}
		bw.write(check+"");
		bw.flush();
		bw.close();
	}
	
	static void DFS(int a, int depth){
		if(depth == 4) {	// 연결되어 있으면
			check = 1;
			return;
		}
		visited[a] = true;	// 방문 처리
		
		for(int val : list[a]) {
			if(!visited[val]) {
				DFS(val, depth+1);
			}
		}
		visited[a] = false;	// 다른 list에서 a와 연결되어있을 수 있으므로 초기화
	}

}
// 과정 https://gimbalja.tistory.com/329