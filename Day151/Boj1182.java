package codingtestAndAlgorithm.Day151;

import java.io.*;
import java.util.*;

public class Boj1182 {

	static int n, s, count;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(s == 0) {
			count--;	// 아무것도 더하지 않은 0의 경우 제외
		}
		DFS(0,0);
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth, int sum) {
		if(depth == n) {
			if(sum == s) {				
				count++;
			}
			return;
		}
		DFS(depth+1, sum+arr[depth]);
		DFS(depth+1, sum);
	}
}
// 과정 https://gimbalja.tistory.com/323