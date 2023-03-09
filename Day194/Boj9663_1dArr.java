package codingtestAndAlgorithm.Day194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9663_1dArr {

	static int n, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		dfs(0);
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth) {
		if(depth == n) {	// 끝까지 다 돌다 == 경우의 수 중 하나
			cnt++;
			return;
		}

		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			
			if(isPossible(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	static boolean isPossible(int col) {
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) {	// 같은 행
				return false;
			}else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {	// 대각선
				return false;
			}
		}
		
		return true;
	}
}
// 과정 https://gimbalja.tistory.com/387