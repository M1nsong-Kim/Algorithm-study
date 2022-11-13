package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day78BOJ2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이의 수
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			//StringTokenizer는 한 줄씩 인식
			st = new StringTokenizer(br.readLine());	
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 디버깅
		System.out.println(Arrays.deepToString(arr));
		
		int sum = n*100;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if( (arr[j][0] < arr[i][0]+10 && arr[i][0]+10 < arr[j][0]+10) && (arr[j][1] < arr[i][1] && arr[i][1] < arr[j][1]+10)) {
					
					sum -= Math.abs(arr[i][0]+10-arr[j][0]) * Math.abs(arr[j][1]+10-arr[i][1]);
				}
			}
				
		}
		
		System.out.println(sum);
	}

}
