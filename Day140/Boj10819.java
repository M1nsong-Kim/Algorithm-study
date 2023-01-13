package codingtestAndAlgorithm.Day140;

import java.io.*;
import java.util.*;

public class Boj10819 {
	
	static int n, count;
	static int[] arr, nums;
	static boolean[] visited;
	static int[][] permutation;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		nums = new int[n];
		visited = new boolean[n];
		permutation = new int[getSize()][n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0);
		
//		System.out.println(count);
//		System.out.println(Arrays.deepToString(permutation));
		System.out.println(getMax());
	}
	
	public static int getSize() {
        int[] dp = new int[10_001];
        dp[2] = 2;
        for(int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1]*i;
        }
        return dp[n];
    }
    
    // DFS 활용하여 전체 순열 구하기
    public static void DFS(int depth) {
        // 입력된 숫자의 깊이까지의 배열 출력
        if(depth == n) {
            if(count < getSize()) {                
                for(int i = 0; i < n; i++) {
                    permutation[count][i] = arr[i];
                }
            }
            count++;
            return;        // 멈추기
        }
        
        for(int i = 0; i < n; i++) {
            // 방문하지 않은 노드라면
            if(!visited[i]) {
                visited[i] = true;    // 방문상태로 변경 후     
                arr[depth] = nums[i];     // 그 깊이의 노드에 값 넣기
                DFS(depth+1);    // 다음 노드 : 깊이+1
                visited[i] = false;    // 다시 false로 돌려서 검사할 수 있도록
            }
        }
    }
    
    static int getMax() {
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < count; i++) {
    		int sum = 0;
    		for(int j = 0; j < n-1; j++) {
    			sum += Math.abs(permutation[i][j]-permutation[i][j+1]);
    		}
    		max = Math.max(max, sum);
    	}
    	return max;
    }
}
// 과정 https://gimbalja.tistory.com/312