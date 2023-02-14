package codingtestAndAlgorithm.Day171;

import java.io.*;
import java.util.*;

public class Boj12851 {
	
	static int n, k, count;
	static int result = Integer.MAX_VALUE;
	static int[] visited = new int[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		bfs();
		System.out.println(result);
		System.out.println(count);
	}

	static void bfs() {
		if(n == k) {
			result = 0;
			count = 1;
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(n);	// 수빈이 위치부터 시작
		visited[n] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(result < visited[now]) {	// 현재 결과보다 더 많은 횟수 -> 최단 거리 아님
				return;
			}
			
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
					result = visited[now];
					count++;
				}

				if(next < 0 || next > 100_000) {	// 범위 안
					continue;
				}
				
				if(visited[next] == 0 || visited[next] == visited[now]+1) {	// 아직 방문 전 && 동시에 움직이는 세 경우 중 하나
					q.add(next);
					visited[next] = visited[now]+1;
				}
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/358