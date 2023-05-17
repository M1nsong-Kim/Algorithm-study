package codingtestAndAlgorithm.Day263;

public class Boj14500 {
	
	static int n, m, max, single;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		n = read();
		m = read();
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = read();
				single = Math.max(single, map[i][j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				DFS(1, i, j, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	static void DFS(int depth, int x, int y, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		if (max >= sum + (single*(4-depth))) {		
			return;
		} 
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
	
			if(!checkScope(nextX, nextY)) {				
				continue;
			}
			if(visited[nextX][nextY]) {
				continue;
			}
			
			if(depth == 2) {
				visited[nextX][nextY] = true;
				DFS(depth + 1, x, y, sum + map[nextX][nextY]);
			}
			
			visited[nextX][nextY] = true;
			DFS(depth + 1, nextX, nextY, sum + map[nextX][nextY]);
			visited[nextX][nextY] = false;
		}
	}
	
	static boolean checkScope(int x, int y) {
		return x > -1 && y > -1 && x < n && y < m;
	}
	
	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		if(c == 13) {
			System.in.read();
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/462