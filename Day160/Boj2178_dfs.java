package codingtestAndAlgorithm.Day160;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2178_dfs {
	
	static int[][] map;
	static int n;
	static int m;
	static int minVal;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		minVal = Integer.MAX_VALUE;
		dfs(0, 0, 1);
		System.out.println(minVal);
	}
	
	public static void dfs(int x, int y, int count) {
		if(x == n-1 && y == m-1) {
			minVal = Math.min(minVal, count);
			return;
		}
		
		if(count > minVal) return; //가지치기 - 이미 count가 minVal보다 커졌다면 return;
		
        	//방향배열 사용하지 않고 조건문으로 4가지를 나누어 보았다.
		if(x > 0 && !visited[x-1][y] && map[x-1][y] == 1) { //상
			visited[x-1][y] = true;
			dfs(x-1, y, count + 1);
			visited[x-1][y] = false;
		}
		if(x < n-1 && !visited[x+1][y] && map[x+1][y] == 1) { //하
			visited[x+1][y] = true;
			dfs(x+1, y, count + 1);
			visited[x+1][y] = false;
		}
		if(y > 0 && !visited[x][y-1] && map[x][y-1] == 1) { //좌
			visited[x][y-1] = true;
			dfs(x, y-1, count + 1);
			visited[x][y-1] = false;
		}
		if(y < m-1 && !visited[x][y+1] && map[x][y+1] == 1) { //우
			visited[x][y+1] = true;
			dfs(x, y+1, count + 1);
			visited[x][y+1] = false;
		}
	}
}