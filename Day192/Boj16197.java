package codingtestAndAlgorithm.Day192;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16197 {

	static int n, m, x1, y1, x2, y2;
	static int min = Integer.MAX_VALUE;
	static char[][] board;
	static boolean[][][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		visited = new boolean[n][m][n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'o' && x1 == 0) {
					x1 = i;
					y1 = j;
				}else if(str.charAt(j) == 'o' && x1 != 0) {
					x2 = i;
					y2 = j;
				}
				board[i][j] = str.charAt(j);
			}
		}
		
		bfs();
		bw.write(min+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x1, y1, x2, y2, 0));
		visited[x1][y1][x2][y2] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
//			if(now.cnt > 10) {
//				min = -1;
//				return;
//			}

			for(int i = 0; i < 4; i++) {
				int count = 0;
				
				int X1 = now.x1 + dx[i];
				int Y1 = now.y1 + dy[i];
				int X2 = now.x2 + dx[i];
				int Y2 = now.y2 + dy[i];
				
				if(X1 < 0 || X1 > n-1 || Y1 < 0 || Y1 > m-1) {	// 보드 밖으로
					count++;
				}
				if(X2 < 0 || X2 > n-1 || Y2 < 0 || Y2 > m-1) {	// 보드 밖으로
					count++;
				}
				
				if(count == 1) {	// 동전 두 개 중 하나만 보드 밖으로
					min = Math.min(min, now.cnt+1);
					return;
				}else if(count == 2) {
					continue;
				}
				
				if(board[X1][Y1] == '#') {	// 벽
					X1 = now.x1;
					Y1 = now.y1;
				}
				
				if(board[X2][Y2] == '#') {
					X2 = now.x2;
					Y2 = now.y2;
				}
				
				if(!visited[X1][Y1][X2][Y2]) {
					visited[X1][Y1][X2][Y2] = true;
					q.add(new Node(X1, Y1, X2, Y2, now.cnt+1));
				}
			}
		}
		min = -1;
	}
	
	static class Node{
		int x1;
		int y1;
		int x2;
		int y2;
		int cnt;
		Node(int x1, int y1, int x2, int y2, int cnt){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.cnt = cnt;
		}
	}
}
// 과정 https://gimbalja.tistory.com/385