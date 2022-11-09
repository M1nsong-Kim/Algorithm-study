package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day74BOJ11399 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 최소 시간을 구하기 위한 오름차순 정렬

		int sum = 0;
		int[] tmp = new int[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				tmp[i] += arr[j];	//빈 배열 tmp에 i까지의 합 넣기
			}
		}
		
		for(int i = 0; i < n; i++) {
			sum += tmp[i];
		}
		System.out.println(sum);
	}

}
