package codingtestAndAlgorithm.Day145;

import java.io.*;
import java.util.*;

public class Boj14889 {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] s;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(s));
		DFS(0, 0);
		System.out.println(min);
	}

	static void DFS(int start, int depth) {
		if(depth == n/2) {	// 한 팀까지만 구하기
			getMin();
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	static void getMin() {
		int startSum = 0;
		int linkSum = 0;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {	// [i][i]는 0이라 확인해볼 필요 없다
				if(visited[i] && visited[j]) {	// 앞서 방문했던 자리
					startSum += s[i][j];
					startSum += s[j][i];
				}else if(!visited[i] && !visited[j]) {
					linkSum += s[i][j];
					linkSum += s[j][i];
				}
			}
		}
		
		int gap = Math.abs(startSum - linkSum);
		
		if(gap == 0) {	// 차이가 0 == 가장 최소값 => 0 출력하고 종료
			System.out.println(gap);
			System.exit(0);
		}
		
		min = Math.min(gap, min);
	}
	
}
// 과정 https://gimbalja.tistory.com/317