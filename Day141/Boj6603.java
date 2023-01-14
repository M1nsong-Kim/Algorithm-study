package codingtestAndAlgorithm.Day141;

import java.io.*;
import java.util.*;

public class Boj6603 {

	static int k;
	static int[] arr, nums;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {	// 0 입력되면 반복문 중지
				break;
			}
			arr = new int[k];
			nums = new int[k];
			visited = new boolean[k];
			
			for(int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0);
			bw.newLine();	// 테스트 케이스마다 분리
		}
		
		bw.flush();
		bw.close();
	}
	
	static void DFS(int depth) throws IOException{
		if(depth == 6) {	// 로또는 총 6개 숫자
			for(int i : arr) {
				if(i != 0) {					
					bw.write(i + " ");
				}
			}
			bw.newLine();
			return;
		}
		
		for(int i = 0; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];
				DFS(depth+1);
				for(int j = i+1; j < k; j++) {	// 오름차순 나열을 위함(매개변수에 start 두는 방법도 있음)
					visited[j] = false;
				}					
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/313