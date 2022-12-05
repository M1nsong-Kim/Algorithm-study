package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 디버깅 System.out.println(Arrays.toString(arr));
		
		// 첫번째 수부터 세보기
		int max = 0;
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(max < arr[i]) {
				max = arr[i];
				count++;
			}
		}
		
		// 배열 2번째부터 끝까지 있는지 확인
		for(int i = 0; i < n; i++) {
			max = 0;
			int maxCnt = 0;
			for(int j = i+1; j < n; j++) {
				if(max < arr[j]) {
					max = arr[j];
					maxCnt++;
				}
			}
			
			if(count < maxCnt) {
				count = maxCnt;
			}
			
		}
		
		System.out.println(count);
	}

}
