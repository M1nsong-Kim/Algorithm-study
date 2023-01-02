package codingtestAndAlgorithm.Day129;

import java.io.*;
import java.util.*;

public class Boj15654 {

	static int n, m;
	static int[] arr;
	static int[] nums;	// 주어지는 수를 입력받기 위한 배열 생성
	static BufferedWriter bw;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		nums = new int[n];	
		visited = new boolean[10_001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);	// 사전순대로 출력하기 위해 오름차순 정렬
		
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
		
		for(int i = 0; i < n; i++) {
			if(!visited[nums[i]]) {	// 이전 i 자리에 nums[i]를 넣어 입력 받은 숫자만 들어가도록
				visited[nums[i]] = true;
				arr[depth] = nums[i];
				DFS(depth+1);
				visited[nums[i]] = false;
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/295