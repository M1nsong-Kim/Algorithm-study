package codingtestAndAlgorithm.Day174;

import java.io.*;
import java.util.*;

public class Boj13549_2 {

	static int n, k;
//	static int[] visited = new int[100_001];
	static boolean[] visited = new boolean[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
		

	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n, 0));
//		visited[n] = 1;
		visited[n] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			
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
