package codingtestAndAlgorithm.Day175;

import java.io.*;
import java.util.*;

public class Boj1261 {

	static int n, m;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				matrix[i][j] = str.charAt(j)-'0';
			}
		}
	
		bfs();
	}

	static void bfs() {
		Deque<Point> deque = new LinkedList<>();
		deque.addLast(new Point(0, 0, 0));	//	(1,1)자리에서 시작
		visited[0][0] = true;
		
		while(!deque.isEmpty()) {
			Point now = deque.pollLast();
//			visited[now.x][now.y] = true;	// 순서가 달라지는 등 필요할 때 아니면 쓰지 않기(메모리 주의)
			
			if(now.x == m-1 && now.y == n-1) {
				System.out.println(now.count);
				return;	// 덱으로 우선순위를 설정했으므로 min 변수를 설정할 것 없이 바로 끝내면 된다
			}
			
			for(int i = 0; i < 4; i++) {	// 상하좌우
				int X = now.x + dx[i];
				int Y = now.y + dy[i];
				
				if(X < 0 || X > m-1 || Y < 0 || Y > n-1) {
					continue;
				}
				
				if(!visited[X][Y] && matrix[X][Y] == 0) {	// 그냥 넘어갈 수 있음
					visited[X][Y] = true;
					deque.addLast(new Point(X, Y, now.count));
				}
				
				if(!visited[X][Y] && matrix[X][Y] == 1) {	// 벽 -> 뚫어야 함
					visited[X][Y] = true;
					deque.addFirst(new Point(X, Y, now.count+1));
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		int count;
		
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
// 과정 https://gimbalja.tistory.com/364