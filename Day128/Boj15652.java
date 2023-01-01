package codingtestAndAlgorithm.Day128;

import java.io.*;
import java.util.*;

public class Boj15652 {
	
	static int n, m;
	static int[] arr;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		DFS(0);
		
		bw.flush();
		bw.close();

	}

	static void DFS(int depth) throws IOException{
		if(depth == m) {
			for(int num : arr) {
				bw.write(num+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(depth == 0) {	// depth-1이 -1이 되지 않도록 주는 조건
				arr[depth] = i+1;
				DFS(depth+1);
			}else{
				if(i+1 >= arr[depth-1]) {	// 같거나 크다 == 비내림차순
				arr[depth] = i+1;
				DFS(depth+1);	
				}
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/294