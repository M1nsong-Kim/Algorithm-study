package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day41_B_11729 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, n)-1).append("\n");	//횟수 2^n - 1. 형변환 안 하면 실수형 .0으로 표시
		
		hanoi(n, 1, 2, 3);
		System.out.println(sb);

	}
	
	public static void hanoi(int n, int start, int mid, int end) {
		if(n==1) {
			sb.append(start + " " + end + "\n");
		}else {
			hanoi(n-1, start, end, mid);	//1. n-1개를 장대2로 보낸다
			sb.append(start + " " + end + "\n"); //2. 가장 큰 원판을 장대3으로 보낸다 (1회)
			hanoi(n-1, mid, start, end);	//3. 장대2에 있는 n-1개를 장대3으로 보낸다
		}
	}

}
