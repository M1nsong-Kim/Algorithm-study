package codingtestAndAlgorithm.Day168;

import java.io.*;
import java.util.*;

public class Boj2146 {

	static int n;
	static int bridge = Integer.MAX_VALUE;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Point> edge = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visited = new boolean[n][n];
		
		// 지도 완성
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구분
		int islandNum = 2;	// 섬 구분용 번호
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 1) {	// 섬이라면
					islandBFS(i, j, islandNum++);
				}
			}
		}
		
		// 가장자리에서의 거리 구하기
		for(Point p : edge) {
			visited = new boolean[n][n];
			BFS(p.x, p.y);
		}
		
		System.out.println(bridge);
	}

	// 섬 구분하기
	static void islandBFS(int x, int y, int islandNum) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			matrix[now.x][now.y] = islandNum;
			
			boolean flag = false;
			for(int i = 0; i < 4; i++) {
				int X = now.x + dx[i];
				int Y = now.y + dy[i];
				
				if(X < 0 || X > n-1 || Y < 0 || Y > n-1) continue;
				
				if(!flag && matrix[X][Y] == 0) {	// 다음이 바다 == 섬의 가장자리
					edge.add(now);
					flag = true;
				}
				
				// 섬이라면
				if(!visited[X][Y] && matrix[X][Y] == 1) {
					visited[X][Y] = true;
					q.add(new Point(X, Y, 0));
				}
			}
		}
	}
	
	// 최단 거리 구하기
	static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));
		visited[x][y] = true;	// 방문 처리
		int islandNum = matrix[x][y];
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// ★ 시간과 메모리 단축에 있어 가장 핵심 ★
			if(now.count >= bridge) {	// 현재까지 구한 최단 거리와 같거나 더 크다면			
				return;					// 더 이상 구할 필요 없다
			} 
			
			for(int i = 0; i < 4; i++) {
				int X = now.x + dx[i];
				int Y = now.y + dy[i];
				
				if(X < 0 || X > n-1 || Y < 0 || Y > n-1) continue;
				if(visited[X][Y] || matrix[X][Y] == islandNum) continue;

				visited[X][Y] = true;	// 방문 처리
				
				if(matrix[X][Y] == 0) {	// 바다						
					q.add(new Point(X, Y, now.count+1));
				}else {	// 다른 섬 도착
					bridge = Math.min(bridge, now.count);							
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		int count;
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}
// 과정 https://gimbalja.tistory.com/353