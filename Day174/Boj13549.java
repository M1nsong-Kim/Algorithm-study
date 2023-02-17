package codingtestAndAlgorithm.Day174;

import java.io.*;
import java.util.*;

public class Boj13549 {

	static int n, k;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(min);

	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n, 0));
		visited[n] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			visited[now.location] = true;	// 각 경우에서 바로 방문 처리하면 거리 바뀔 수 있음
			
			if(now.location == k) {
//				System.out.println(now.time);	// 오답
//				return;
				min = Math.min(min, now.time);
			}
			
			// *2
			if(now.location*2 < 100_001 && !visited[now.location*2]) {				
				q.add(new Point(now.location*2, now.time));
//				visited[now.location*2] = true;	// 오답
			}
			
			// +1
			if(now.location+1 < 100_001 && !visited[now.location+1]) {				
				q.add(new Point(now.location+1, now.time+1));
//				visited[now.location+1] = true;	// 오답
			}
			
			// -1
			if(now.location-1 > -1 && !visited[now.location-1]) {
				q.add(new Point(now.location-1, now.time+1));
//				visited[now.location-1] = true;	// 오답
			}
			
		}
	}

	static class Point{
		int location;
		int time;
		
		public Point(int location, int time) {
			this.location = location;
			this.time = time;
		}
	}
}
// 과정 https://gimbalja.tistory.com/363