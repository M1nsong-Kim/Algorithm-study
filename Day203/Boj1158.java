package codingtestAndAlgorithm.Day203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");	// < 붙이고 시작
		ArrayList<Integer> list = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			list.add(i+1);
		}
		
		int idx = 0;	
		// 처음부터 k-1로 초기화하고 sb.append(list.get(idx)); 하는 방법도 있지만 코드 중복
		while(!list.isEmpty()) {
			idx = (idx+k-1)%n;	// 뺄 자리 추적
			sb.append(list.get(idx));
			if(n != 1) {	// 끝에 , 안 붙이기 위함
				sb.append(", ");
			}
			list.remove(idx);
			n--;
		}
		sb.append(">");
		System.out.println(sb.toString());
	}

}
// 복습 과정 https://gimbalja.tistory.com/398