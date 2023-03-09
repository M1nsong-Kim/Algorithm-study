package codingtestAndAlgorithm.Day194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9663_2dArr_fail {

	static int n, cnt;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited = new boolean[n][n]; 	// 초기화
				dfs(0, i, j);
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth, int x, int y) {
		if(depth == n) {	// 끝까지 다 돌다 == 경우의 수 중 하나
			cnt++;
			return;
		}

		board[x][y] = 1;	// 퀸 표시
		
		// 같은 가로줄, 세로줄 방문 불가
		for(int i = 0; i < n; i++) {
			visited[x][i] = true;
			visited[i][y] = true;
		}
		
		// 대각선 방문 불가
		for(int i = 0; i < 4; i++) {
			int X = x+dx[i];
			int Y = y+dy[i];
			
			if(X < 0 || X > n-1 || Y < 0 || Y > n-1) {
				continue;
			}
			
			visited[X][Y] = true;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				int X = x+i;
				int Y = y+j;
				
				// 범위 밖
				if(X < 0 || X > n-1 || Y < 0 || Y > n-1) {
					continue;
				}
				
				
				if(!visited[X][Y]) {
					board[X][Y] = 1;	// 퀸 표시
					dfs(depth+1, X, Y);
				}
			}
		}
	}
}
