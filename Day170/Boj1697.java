package codingtestAndAlgorithm.Day170;

import java.io.*;
import java.util.*;

public class Boj1697 {

	static int n, k;
	static int[] visited = new int[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		bfs();
	}

	static void bfs() {
		if(n == k) {
			System.out.println(0);
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(n);	// 수빈이 위치부터 시작
		visited[n] = 1;
		
		
		while(!q.isEmpty()) {
			int now = q.poll();

			for(int i = 0; i < 3; i++) {	// 경우의 수 3개
				int next = 0;
				
				if(i == 0) {
					next = now-1;
				}else if(i == 1) {
					next = now+1;
				}else {
					next = now*2;
				}
				
				if(next == k) {
					System.out.println(visited[now]);
					return;
				}
				
				if(next > -1 && next < 100_001 && visited[next] == 0) {	// 범위 안 && 아직 방문 전
					q.add(next);
					visited[next] = visited[now]+1;
				}
			}
			
		}
	}
}
// 과정 https://gimbalja.tistory.com/356