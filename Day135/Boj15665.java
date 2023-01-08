package codingtestAndAlgorithm.Day135;

import java.io.*;
import java.util.*;

public class Boj15665 {

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
		DFS(0);
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) throws IOException{
		if(depth == m) {
			for(int val : arr) {
				bw.write(val+" ");
			}
			bw.newLine();
			return;
		}
		
		int before = 0;
		for(int i = 0; i < n; i++) {
			if(before != nums[i]) {	// 이전에 들어갔던 수랑 다르면 == 중복이 아니면	
				arr[depth] = nums[i];
				before = nums[i];
				DFS(depth+1);
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/305