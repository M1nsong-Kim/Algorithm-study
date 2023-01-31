package codingtestAndAlgorithm.Day158;

import java.io.*;
import java.util.*;

public class Boj2667 {

	static int n, complexCnt;
	static int count = 1;
	static int[][] matrix;
	static boolean[][] visited;
	static ArrayList<Integer> complex = new ArrayList<>();	// 단지별 세대수
	static int[] dx = {-1, 0, 1, 0};    // x좌표
    static int[] dy = {0, -1, 0, 1};    // y좌표
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				matrix[i][j] = str.charAt(j)-'0';	// 행렬로 넣기
			}
		}
		
		// 탐색 끝 -> 배열에 개수 넣기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {				
				if(!visited[i][j] && matrix[i][j] == 1) {	// 방문하지 않았고 칠해진 단지라면 == 새로운 단지 시작
					DFS(i, j);
					complex.add(count);
					count = 1;	// 초기화
					complexCnt++;	// 단지 개수 더하기
				}
			}
		}
		
		Collections.sort(complex);	// 오름차순 정렬
		bw.write(complexCnt+"\n");
		for(int val : complex) {
			bw.write(val+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void DFS(int x, int y) {
		visited[x][y] = true;	// 방문처리
		
		for(int i = 0; i < 4; i++) {	// 상하좌우 4번
			int X = x+dx[i];
			int Y = y+dy[i];
			
			if(X < 0 || X > n-1 || Y < 0 || Y > n-1) {	// 범위 바깥 -> 넘어가기
				continue;
			}
			/* if문 두 번 적는 이유: 배열 범위 넘으면 안 돼서 */
			if(matrix[X][Y] == 0 || visited[X][Y]) {	// 칠해지지 않았거나 이미 방문함 -> 넘어가기 
				continue;
			}
			count++;	// 단지 내 세대수 추가
			DFS(X, Y);
		}
	}
}
// 과정 https://gimbalja.tistory.com/335