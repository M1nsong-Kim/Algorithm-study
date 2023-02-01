package codingtestAndAlgorithm.Day159;

import java.io.*;
import java.util.*;

public class Boj4963_list {

	static int w, h, count;
	static ArrayList<Integer>[] list;
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};	// x좌표(대각선 포함)
	static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};	// y좌표(대각선 포함)
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {	// 0 0 입력되면 테스트 케이스 종료
				break;
			}
			list = new ArrayList[h];
			visited = new boolean[h][w];
			count = 0;	// 테스트 케이스마다 카운트 초기화
			
			// 지도
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new ArrayList<Integer>();
				for(int j = 0; j < w; j++) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			// DFS
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && list[i].get(j) == 1) {						
						DFS(i, j);
						count++;
					}
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();

	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;	// 방문 처리
		
		for(int i = 0; i < 8; i++) {	// 상하좌우+대각선
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X < 0 || X > h-1 || Y < 0 || Y > w-1) { // 범위 벗어나면
				continue;
			}
			if(list[X].get(Y) == 0 || visited[X][Y]) {	//칠해지지 않았거나 이미 센 섬이라면
				continue;
			}
			DFS(X, Y);
		}
	}

}
// 과정 https://gimbalja.tistory.com/337