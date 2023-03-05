package codingtestAndAlgorithm.Day190;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14225 {

	static int n, before;
	static int[] arr;
	static int[] answer = new int[2_000_001];
	// 숫자가 20이고 수열 s의 구성요소가 모두 최댓값 100,000 -> 합의 최댓값은 20 * 100,000
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		// 수열s는 자연수로만 이루어져 있으므로 합의 최솟값인 1부터 시작
		for(int i = 1; i < answer.length; i++) {
			if(answer[i] == 0) {				
				bw.write(i+"");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int depth, int sum) {
		answer[sum]++;	// 합이 존재하면 그 자리에 숫자 넣기
		
		if(depth == n) {
			return;
		}
		
		// 트리 형식으로 모든 합을 확인한다고 보면 된다
		dfs(depth+1, sum+arr[depth]);
		dfs(depth+1, sum);
	}

}
// 과정 https://gimbalja.tistory.com/383