package codingtestAndAlgorithm.Day133;

import java.io.*;
import java.util.*;

public class Boj15663 {

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
		
		DFS(0);
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) throws IOException {
		if(depth == m) {
			for(int val : arr) {
				bw.write(val+" ");
			}
			bw.newLine();
			return;
		}
		
		int before = 0;
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				continue;
			}
			
			if(before != nums[i]){	
				visited[i] = true;
				arr[depth] = nums[i];
				before = nums[i];
				DFS(depth+1);
				visited[i] = false;
			}
		}
	}
	

}
// 과정 https://gimbalja.tistory.com/303