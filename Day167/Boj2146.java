package codingtestAndAlgorithm.Day167;

import java.io.*;
import java.util.*;

public class Boj2146 {
	
	static int n;
	static int bridge = Integer.MAX_VALUE;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		matrix = new int [n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int islandNum = 2;	// 섬 구분용 번호
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 1) {	// 섬이라면
					islandDFS(i, j, islandNum);
					islandNum++;	// 섬 하나 탐색 끝나면 다른 번호로 섬 구분
				}
			}
		}
		// 방문 초기화
		visited = new boolean[n][n];
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(matrix[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] != 0) {	// 섬이라면 다음 섬으로 연결 시작	
					visited = new boolean[n][n];
					BFS(i, j);
				}
			}
		}
		System.out.println(bridge);
	}
	
	// 섬 구분하기
	static void islandDFS(int x, int y, int islandNum) {
		matrix[x][y] = islandNum;
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X > -1 && X < n && Y > -1 && Y < n) {	// 범위 안
				if(!visited[X][Y] && matrix[X][Y] == 1) {	// 섬이라면
					matrix[X][Y] = islandNum;
					islandDFS(X, Y, islandNum);
				}
			}
		}
	}
	
	// 최단거리 찾기
	static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));
		visited[x][y] = true;	// 방문 처리
		int islandNum = matrix[x][y];
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int X = now.x + dx[i];
				int Y = now.y + dy[i];
				
				if(X > -1 && X < n && Y > -1 && Y < n) {	// 범위 안
					if(!visited[X][Y] && matrix[X][Y] != islandNum) {	// 방문 전 && 같은 섬 안 아님
						visited[X][Y] = true;	// 방문 처리
						
						if(matrix[X][Y] == 0) {	// 바다						
							q.add(new Point(X, Y, now.count+1));
						}else {	// 다른 섬 도착
							bridge = Math.min(bridge, now.count);							
						}
					}
				}
			}
		}
	}
	
	static class Point{
		int x, y, count;
		public Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
// 과정 https://gimbalja.tistory.com/353