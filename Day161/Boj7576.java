package codingtestAndAlgorithm.Day161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {

	static int m, n;
	static int max = Integer.MIN_VALUE;
	static int[][] matrix;
	static int[] dx = {-1, 1, 0, 0};	// 가로
	static int[] dy = {0, 0, -1, 1};	// 세로
	static Queue<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 1) {	// 익은 토마토는
					q.add(new Node(i, j));	// 큐에 넣기
				}
			}
		}

		System.out.println(BFS());
		
	}
	
	static int BFS() {
		while(!q.isEmpty()) {
			Node next = q.poll();
			
			for(int i = 0; i < 4; i++) { // 상하좌우
				int X = next.x + dx[i];
				int Y = next.y + dy[i];
				
				if(X > -1 && X < n && Y > -1 && Y < m) {	// 범위 안
					if(matrix[X][Y] == 0) { // 안 익은 토마토라면
						q.add(new Node(X, Y));
						matrix[X][Y] = matrix[next.x][next.y]+1; // 일수 누적
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[i][j] == 0) {	// 익지 못하는 토마토가 있으면
					return -1;	// -1 반환
				}
				max = Math.max(max, matrix[i][j]);	// 최댓값 찾기
			}
		}
		if(max == 1) {	// 원래 모든 토마토가 익은 경우
			return 0;
		}
		return max-1;
	}
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
// 과정 https://gimbalja.tistory.com/340