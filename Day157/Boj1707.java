package codingtestAndAlgorithm.Day157;

import java.io.*;
import java.util.*;

public class Boj1707 {

	static int k, v, e;
	static int[] colors;	// 경우가 세 가지여야 하므로 boolean[] 대신 int[]
	static final int red = 1;
	static final int blue = -1;
	static ArrayList<Integer>[] list;	// 인접 리스트
	static String result = "YES";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			list = new ArrayList[v+1];	// 그래프 초기화
			colors = new int[v+1];
			e = Integer.parseInt(st.nextToken());
			result = "YES";	// 그래프마다 초기화
			
			// 정점
			for(int j = 1; j < v+1; j++) {
				list[j] = new ArrayList<>();
				colors[j] = 0;
			}
			
			// 간선 연결
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				// 양방향
				list[x].add(y);
				list[y].add(x);
			}
			
			for(int j = 1; j < v+1; j++) {
				if(result.equals("NO")) {
					break;
				}
				
				if(colors[j] == 0) {					
					DFS(j, red);
				}
			}
			System.out.println(result);
		}

	}

	public static void DFS(int start, int color) {
		colors[start] = color;	// 방문 처리 == 색깔 주기
		
		for(int next : list[start]) {
			if(colors[next] == color) {	// 같은 색끼리 인접 == 이분 그래프 x
				result = "NO";
				return;
			}
			
			if(colors[next] == 0) {
				DFS(next, -color);	// 1, -1 이므로 - 를 붙이면 반대색깔을 준다 (인접 정점이 다른 색깔이어야 하므로)
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/333