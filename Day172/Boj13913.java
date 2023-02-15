package codingtestAndAlgorithm.Day172;

import java.io.*;
import java.util.*;

public class Boj13913 {
	
	static int n, k;
	static int result = Integer.MAX_VALUE;
	static int[] visited = new int[100_001];
	static int[] parent = new int[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);	// 가장 마지막에 나올 k를 먼저 넣어주기(stack:first in last out)
        int idx = k;	// parent[]에서 idx가 곧 자식
        while (idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];	// 자식에서 부모로
        }

        // 최종 출력
        sb.append(result).append('\n');
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb.toString());
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);	// 수빈이 위치부터 시작
		visited[n] = 1;
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
//			if(now == k) {
//				result = visited[now]-1;
//				return;
//			}

			for(int i = 0; i < 3; i++) {	// 경우의 수 3개
				int next = 0;
				
				if(i == 0) {
					next = now-1;
				}else if(i == 1) {
					next = now+1;
				}else {
					next = now*2;
				}
				
				if(next == k) {
					result = visited[now];
					return;
				}
				
				if(next > -1 && next < 100_001 && visited[next] == 0) {	// 범위 안 && 아직 방문 전
					q.add(next);
					visited[next] = visited[now]+1;
					parent[next] = now;
				}
			}
			
		}
	}
}
// 과정 https://gimbalja.tistory.com/360