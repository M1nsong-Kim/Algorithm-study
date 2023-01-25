package codingtestAndAlgorithm.Day152;

import java.io.*;
import java.util.*;

public class Boj14391 {

	static int n, m;
	static int max = Integer.MIN_VALUE;
	static int[][] paper;
	static boolean[][] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = str.charAt(j)-'0';
			}
		}

//		System.out.println(Arrays.deepToString(paper));
		DFS(0, 0);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

	static void DFS(int depth, int width){
//		System.out.println(Arrays.deepToString(visited));
		
		if(depth == n) {	// 모든 깊이(세로) 탐색 완료->최댓값 출력
			getMax();
			return;
		}
		
		if(width == m) {	// 한 줄 다 확인했으면
			DFS(depth+1, 0);	// 다음행 1열로
			return;
		}
		
		// 가로
		visited[depth][width] = false;	// 0 표시
		DFS(depth, width+1);
		// 세로
		visited[depth][width] = true;	// 1 표시
		DFS(depth, width+1);
	}
	
	static void getMax() {
		int num = 0;
		int temp = 0;
		
		// 가로
		for(int i = 0; i < n; i++) {
			temp = 0;
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) {	// 0 -> 가로
					temp *= 10;	// 더해질 때마다 자릿수 늘려주기
					temp += paper[i][j];
				}else {
					num += temp;
					temp = 0;	// 세로니까 초기화
				}
			}
			num += temp;
		}
		// 세로
		for(int i = 0; i < m; i++) {
			temp = 0;
			for(int j = 0; j < n; j++) {
				if(visited[j][i]) {	// 1 -> 세로
					temp *= 10;	// 더해질 때마다 자릿수 늘려주기
					temp += paper[j][i];
				}else {
					num += temp;
					temp = 0;	// 가로니까 초기화
				}
			}
			num += temp;
		}
		
		max = Math.max(num, max);
//		System.out.println("max : "+max);
	}
}
