package codingtestAndAlgorithm.Day191;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj15658 {

	static int n;
	static int[] arr;
	static int[] operations = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		 n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);
		
		bw.write(max+"\n");
		bw.write(min+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int num, int idx) {
		if(idx == n) {	// n-1까지 모두 탐색 완료 -> 한 가지 경우의 수 끝
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operations[i] > 0) {
				operations[i]--;
				switch(i){
					case 0:	// 덧셈
						dfs(num+arr[idx], idx+1);
						break;
					case 1:	// 뺄셈
						dfs(num-arr[idx], idx+1);
						break;
					case 2:	// 곱셈
						dfs(num*arr[idx], idx+1);
						break;
					case 3:	// 나눗셈
						dfs(num/arr[idx], idx+1);
						break;
				}
				operations[i]++;	// 다른 경우의 수 탐색 위해 재귀 끝나면 연산자 개수 돌려놓기
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/384