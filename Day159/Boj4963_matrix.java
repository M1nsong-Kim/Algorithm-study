package codingtestAndAlgorithm.Day159;

import java.io.*;
import java.util.*;

public class Boj4963_matrix {

	static int w, h, count;
	static int[][] matrix;
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};	// x좌표(대각선 포함)
	static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};	// y좌표(대각선 포함)
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {	// 0 0 입력되면 테스트 케이스 종료
				break;
			}
			matrix = new int[h][w];
			visited = new boolean[h][w];
			count = 0;	// 테스트 케이스마다 카운트 초기화
			
			// 지도
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// DFS
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && matrix[i][j] == 1) {						
						DFS(i, j);
						count++;
					}
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;	// 방문 처리
		
		for(int i = 0; i < 8; i++) {	// 상하좌우+대각선
			int X = x + dx[i];
			int Y = y + dy[i];
			
			// continue 사용하지 않고
			if(X > -1 && X < h && Y > -1 && Y < w) {
				if(matrix[X][Y] == 1 && !visited[X][Y]) {					
					DFS(X, Y);				
				}
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/337