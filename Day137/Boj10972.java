package codingtestAndAlgorithm.Day137;

import java.io.*;
import java.util.*;

public class Boj10972 {

	static int n, count;
	static int[] arr, nums;
	static boolean[] visited;
	static int[][] permutation;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		nums = new int[n];
		visited = new boolean[n];
		permutation = new int[getSize()][n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		getPermutation(0);
		
		for(int i = 0; i < getSize(); i++) {			
			if(Arrays.equals(permutation[i], nums)) {	// 같으면
				if(i+1 >= getSize()) {
					System.out.println(-1);
				}else {					
					for(int val : permutation[i+1]) {
						System.out.print(val+" ");// 배열 모두 출력하고
					}					
				}
				return;	// 반복문 종료
			}
		}
		
	}
	
	// 배열 개수 구하기
	public static int getSize() {
		int[] dp = new int[10_001];
		dp[2] = 2;
		for(int i = 3; i < n+1; i++) {
			dp[i] = dp[i-1]*i;
		}
		return dp[n];
	}
	
	// DFS 활용하여 전체 순열 구하기
	public static void getPermutation(int depth) {
		// 입력된 숫자의 깊이까지의 배열 출력
		if(depth == n) {
			if(count < getSize()) {				
				for(int i = 0; i < n; i++) {
					permutation[count][i] = arr[i];
				}
			}
			count++;
		}
		
		for(int i = 0; i < n; i++) {
			// 방문하지 않은 노드라면
			if(!visited[i]) {
				visited[i] = true;	// 방문상태로 변경 후 	
				arr[depth] = i+1; 	// 그 깊이의 노드에 값 넣기
				getPermutation(depth+1);	// 다음 노드 : 깊이+1
				visited[i] = false;	// 다시 false로 돌려서 검사할 수 있도록
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/308