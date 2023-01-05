package codingtestAndAlgorithm.Day132;

import java.io.*;
import java.util.*;

public class Boj15657 {

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
		
		for(int i = start; i < n; i++) {
			arr[depth] = nums[i];
			DFS(i, depth+1);
		}
	}

}
// 과정 https://gimbalja.tistory.com/m/301