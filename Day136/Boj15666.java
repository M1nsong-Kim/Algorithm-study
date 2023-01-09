package codingtestAndAlgorithm.Day136;

import java.io.*;
import java.util.*;

public class Boj15666 {

	static int n, m;
	static int[] arr, nums;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		nums = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		DFS(0, 0);
		bw.flush();
		bw.close();
	}

	public static void DFS(int start, int depth) throws IOException{
		if(depth == m) {
			for(int val : arr) {
				bw.write(val+" ");
			}
			bw.newLine();
			return;
		}
		
		int before = 0;
		for(int i = start; i < n; i++) {
			if(before != nums[i]) {	// 중복처리
				visited[i] = true;	// 비내림차순처리 1
				arr[depth] = nums[i];
				before = nums[i];
				DFS(i, depth+1);
				visited[i] = false;	// 비내림차순처리 2
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/306