package codingtestAndAlgorithm.Day148;

import java.io.*;
import java.util.*;

public class Boj16198 {
	
	static int n, sum;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> W = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			W.add(Integer.parseInt(st.nextToken()));
		}
		
		DFS(W.size(), 0);
		bw.write(max+"");
		bw.flush();
		bw.close();

	}
	
	static void DFS(int depth, int sum){
		if(depth == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 1; i < W.size()-1; i++) {	// 첫 번째와 마지막 에너지 구슬은 고를 수 없다
			int iValue = W.get(i);
			int energy = W.get(i-1) * W.get(i+1);	// 에너지 모으기
			W.remove(i);	// i번째 에너지 구슬 제거
			DFS(depth-1, sum+energy);
			W.add(i, iValue);	// 배열 원래대로 돌리기(i번째 자리에 원래 i값 넣기)
		}
	}

}
// 과정 https://gimbalja.tistory.com/320