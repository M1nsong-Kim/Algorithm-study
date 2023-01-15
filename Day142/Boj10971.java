package codingtestAndAlgorithm.Day142;

import java.io.*;
import java.util.*;

public class Boj10971 {

	static int n;
	static int min = 10_000_000;
	static int[] arr;
	static boolean[] visited;
	static int[][] W;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		W = new int[n][n];
		arr = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int depth) throws IOException{
		if(depth == n) {
			min = Math.min(getSum(), min);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				DFS(depth+1);
				visited[i] = false;
			}
		}
	}

	public static int getSum() {
		int sum = 0;
		for(int i = 0; i < n-1; i++) {			
			if(W[arr[i]][arr[i+1]] != 0) {
//					System.out.println("W["+arr[i]+"]["+arr[i+1]+"]");
				sum += W[arr[i]][arr[i+1]];
			}else {
				sum += 10_000_000;	// 0이다 == 갈 수 없는 경로 == 최대값으로 처리하여 최소값이 될 수 없도록
			}
		}
		if(W[arr[n-1]][arr[0]] != 0) {			
			sum += W[arr[n-1]][arr[0]];
		}else {
			sum += 10_000_000;
		}
//		System.out.println();
		return sum;
	}
}
