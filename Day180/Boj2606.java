package codingtestAndAlgorithm.Day180;

import java.io.*;
import java.util.*;

public class Boj2606 {

	static int computers, n, cnt;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		computers = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		visited = new boolean[computers];
		
		for(int i = 0; i < computers; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			// 양방향
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(0);	// 1번 컴퓨터가 걸림
		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		for(int i : list.get(start)) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}

}
// 과정 https://gimbalja.tistory.com/370