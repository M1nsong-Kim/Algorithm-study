package codingtestAndAlgorithm.Day160;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

	static int n, m;
	static int[][] matrix;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				matrix[i][j] = str.charAt(j)-'0';
			}
		}
		
		BFS(0, 0);

		bw.write(matrix[n-1][m-1]+"");
		bw.flush();
		bw.close();
	}
	
	static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node next = q.poll();
			
			for(int i = 0; i < 4; i++) {	// 상하좌우
				int X = next.x + dx[i];
				int Y = next.y + dy[i];
				
				if(X > -1 && X < n && Y > -1 && Y < m) {	// 범위 안
					if(matrix[X][Y] == 1) {	// 1이 아니다 == 0이거나 아직 더해지지 않았다 == 방문하지 않음
						q.add(new Node(X, Y));
						matrix[X][Y] = matrix[next.x][next.y]+1;
	                }
	            }
			}
		}
	}
	
	static class Node{
		int x, y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
// 과정 https://gimbalja.tistory.com/339