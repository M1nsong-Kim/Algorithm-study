package codingtestAndAlgorithm.Day123;

import java.io.*;
import java.util.*;

public class Boj14500 {

	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};	// x좌표
	static int[] dy = {0, -1, 0, 1};	// y좌표
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		max = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				DFS(i, j, 0, 0);
				theOther(i, j);
			}
		}
		System.out.println(max);
	}
	
	// 'ㅜ'를 제외한 4가지 모양(의 회전, 반전까지 모두 포함)
	public static void DFS(int x, int y, int depth, int sum) {
		if(depth == 4) {	// DFS 깊이 4까지만
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) { //배열의 범위를 벗어나지 않도록
				continue;	// 건너뛰기
			}
			if(visited[nextX][nextY]) {
				continue;
			}
			visited[nextX][nextY] = true;
			DFS(nextX, nextY, depth+1, sum+arr[nextX][nextY]);	// 탐색 완료 후 다시 돌아옴(같은 점에서 출발하는 여러 모양 때문에)
			visited[nextX][nextY] = false;	// 다시 false로 돌려서 다시 검사할 수 있도록 함 
			}
	}
	
	// 'ㅜ' : +에서 하나 뺌
	public static void theOther(int x, int y) {
		int wing = 4;	// +에 붙은 4개
		int min = Integer.MAX_VALUE;
		int sum = arr[x][y];
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(wing <= 2) {	// 2개보다 작다 -> 'ㅜ' 모양을 만들 수 없다
				return;
			}
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {	// 주어진 밤위 안에 있도록
				wing--;
				continue;
			}
			
			min = Math.min(min, arr[nextX][nextY]);
			sum = sum + arr[nextX][nextY];
		}

		if(wing == 4) {	// 가장 값이 작은 걸 뺀다
			sum -= min;
		}
		max = Math.max(max, sum);
	}
	
}
// 과정 https://gimbalja.tistory.com/287