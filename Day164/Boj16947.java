package codingtestAndAlgorithm.Day164;

import java.io.*;
import java.util.*;

public class Boj16947 {

	static int n;
	static ArrayList<Integer>[] metro;
	static boolean[] visited, isCycle;
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		metro = new ArrayList[n];
		visited = new boolean[n];
		isCycle = new boolean[n];
		distance = new int[n];
		
		for(int i = 0; i < n; i++) {
			metro[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;	// 인덱스에 맞추기 위해 -1
			int y = Integer.parseInt(st.nextToken()) - 1;
			// 양방향
			metro[x].add(y);
			metro[y].add(x);
		}
		
		// 순환선
		for(int i = 0; i < n; i++) {
			if(!isCycle[i]) {
				visited = new boolean[n];
				DFS(i, i, 0);
			}
		}
//		System.out.println(Arrays.toString(isCycle));
		// 초기화
		Arrays.fill(visited, false);
		// 거리
		needDistance();
		for(int i = 0; i < n; i++) {
			bw.write(distance[i]+" ");
		}
		bw.flush();
		bw.close();
	}

	// 순환선
	static boolean DFS(int start, int i, int cnt) {
		for(int next : metro[i]) {
			if(next == start) {
				if(cnt > 1) {	// 바로 돌아오지 않도록
					return isCycle[i] = true;
				}else {
					continue;
				}
			}
			if(isCycle[next] || isCycle[i] || visited[next]) {
			// 사이클(현재)x->사이클(다음) == 사이클x || 지금 사이클 || 사이클 여부 확인
				continue;
			}
			visited[next] = true;
			isCycle[i] = DFS(start, next, cnt+1);
		}
		return isCycle[i];
	}
	
	// 역과 순환선 사이의 거리
	static void needDistance() {
		for(int i = 0; i < n; i++) {
			if(isCycle[i]) {	// 순환선과 순환선이 아닌 역 사이의 거리를 구하기 위해
				getDistance(i);
			}
		}
	}
	static void getDistance(int i) {
		for(int next : metro[i]) {
			if(isCycle[next] || distance[next] > 0) {	// 순환선이어서 구할 필요 없거나 이미 거리를 구했다면
				continue;
			}
			distance[next] = distance[i]+1;
			getDistance(next);
		}
	}
}
// 과정 https://gimbalja.tistory.com/344