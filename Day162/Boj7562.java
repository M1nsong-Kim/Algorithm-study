package codingtestAndAlgorithm.Day162;

import java.io.*;
import java.util.*;

public class Boj7562 {

	static int testCase, l, startX, startY, goalX, goalY;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, 2, -2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			l = Integer.parseInt(br.readLine());
			matrix = new int[l][l];
			visited = new boolean[l][l];
			// 시작
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			// 목적지
			st = new StringTokenizer(br.readLine());
			goalX = Integer.parseInt(st.nextToken());
			goalY = Integer.parseInt(st.nextToken());
			
			BFS(startX, startY);
			System.out.println(matrix[goalX][goalY]);
		}
	}

	static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;	// 방문처리
		
		while(!q.isEmpty()) {	
			Node next = q.poll();
			if(next.x == goalX && next.y == goalY) {
				return;	// 목적지에 도착했다면
			}
			for(int i = 0; i < 8; i++) {	// 나이트가 이동할 수 있는 8방향
				int X = next.x + dx[i];
				int Y = next.y + dy[i];
				
				if(X > -1 && X < l && Y > -1 && Y < l) {	// 범위 
					if(!visited[X][Y]) {
						q.add(new Node(X, Y));
						visited[X][Y] = true;
						matrix[X][Y] = matrix[next.x][next.y] + 1;
					}
				}
			}
		}
	}

	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
// 과정 https://gimbalja.tistory.com/341