package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day41_B_11729_2 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		sb.append((int)Math.pow(2, n)-1).append("\n");
		
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int start, int mid, int end) {
		if(n == 1) {
			sb.append(start + " " + end + "\n");
		}else {
			hanoi(n-1, start, end, mid);
			sb.append(start + " " + end + "\n");
			hanoi(n-1, mid, start, end);
		}
	}

}