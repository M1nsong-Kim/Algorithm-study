package codingtestAndAlgorithm.Day163;

import java.io.*;
import java.util.*;

public class Boj16929 {

	static int n, m, startX, startY;
	static char[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String result = "No";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				matrix[i][j] = ch;
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) {
					startX = i;
					startY = j;
					DFS(i, j, 1, matrix[i][j]);
				}
			}
		}
			
		System.out.println(result);
	}

	static void DFS(int x, int y, int depth, char color) {
		visited[x][y] = true;	// 방문 처리
		
		for(int i = 0; i < 4; i++) {	// 상하좌우
			int X = x + dx[i];
			int Y = y + dy[i];
			if(X < n && X > -1 && Y < m && Y > -1){	// 범위 안				
				if(depth >= 4 && X == startX && Y == startY) {	// 다음에서 4 이상인 사이클이 완성되면
					result = "Yes";
					return;
				}
				if(!visited[X][Y] && matrix[X][Y] == color) {
					DFS(X, Y, depth+1, color);
				}
			}
		}
		visited[x][y] = false;	// 다른 색깔의 초기화를 위함
	}
}
// 과정 https://gimbalja.tistory.com/342