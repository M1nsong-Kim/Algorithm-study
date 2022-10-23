package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day57_B_17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int num = 0;
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			num = arr[i];
			
			for(int j = i+1; j < n; j++) {
				if(num < arr[j]) {
					answer = arr[j];
					break;
				}
				else {
					answer = -1;
				}
			}
			
			if(num == arr[n-1])
				answer = -1;
			
			System.out.print(answer+" ");
		}
		
		//시간 초과(스택x)
	}

}
