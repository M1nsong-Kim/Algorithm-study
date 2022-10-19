package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day53_B_1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);		//1부터 n까지 큐에 삽입
		}
		
		sb.append('<');
		while(q.size() > 1) {	// ',' 출력 안 하기 위해 마지막 숫자는 따로 추가해야 함
			
			for(int i = 0; i < k - 1; i++) {
				q.offer(q.poll());	//앞에 있는 숫자들 k-1번 뒤로 보내기(앞에서 삭제하면서 뒤에 추가)
			}
			sb.append(q.poll()).append(", ");
		}
		
		//마지막 숫자
		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}

}
