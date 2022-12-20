package codingtestAndAlgorithm;

import java.io.*;
import java.util.*;

public class Boj13398 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dpR = new int[n];
		int[] dpL = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dpR[i] = dpL[i] = arr[i];
		}
		
		// 오른쪽 방향으로 최대 연속합 저장 (기존 연속합과 동일)
		int max = dpR[0];	// 수열의 첫 번째 값과 비교하기 시작
		for(int i = 1; i < n; i++) {
			dpR[i] = Math.max(dpR[i], dpR[i-1]+arr[i]);
			max = Math.max(max, dpR[i]);	// 기존 연속합 최대값 구하기
		}
		// 왼쪽 방향으로 최대 연속합 저장
		for(int i = n-2; i >= 0; i--) {
			dpL[i] = Math.max(dpL[i], dpL[i+1]+arr[i]);
		}
		
		// 숫자를 아무것도 지우지 않았을 때(원래 연속합)랑 무언가를 지웠을 때 중 큰 값 산출
		for(int i = 1; i < n-1; i++) {
			int exceptI = dpR[i-1]+dpL[i+1];
			// arr[i]를 뺀 값 : dpR[i-1]+dpL[i+1] (i 전까지의 최대값 + i 후의 최대값)
			
			max = Math.max(max, exceptI);
		}
		System.out.println(max);
	}

}
// 과정 https://gimbalja.tistory.com/276