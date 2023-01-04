package codingtestAndAlgorithm.Day131;

import java.io.*;
import java.util.*;

public class Boj15656 {

	static int n, m;
	static int[] arr, nums;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);	// 오름차순 정렬
		
		DFS(0);
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) throws IOException{
		if(depth == m) {
			for(int val : arr) {
				bw.append(val+" ");
			}
			bw.newLine();	// == System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {			
			arr[depth] = nums[i];
			DFS(depth+1);	// 재귀로 호출하여 다음 깊이의 노드 탐색
		}
	}

}
// 과정 https://gimbalja.tistory.com/299