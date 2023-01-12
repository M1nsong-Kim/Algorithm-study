package codingtestAndAlgorithm.Day139;

import java.io.*;

public class Boj10974 {
	
	static int n;
	static int[] arr;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		
		DFS(0);
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) throws IOException{
		if(depth == n) {	// 깊이가 n과 같아지면 == n개의 수가 들어가면
			for(int i : arr) {
				bw.write(i+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {	// visited[i]가 false 일 때만 수행 -> 중복 수가 걸러진다
				visited[i] = true;
				arr[depth] = i+1;
				DFS(depth+1);
				visited[i] = false;
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/311