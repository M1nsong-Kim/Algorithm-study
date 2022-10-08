package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day42_B_2798_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Blackjack(arr, n, m);
		System.out.println(answer);
	}
	
	static int Blackjack(int[] arr, int n, int m) {
		int answer = 0;
		int tmp = 0;
		
		for(int i = 0; i < n-2; i++) {
			if(arr[i] > m) continue;
			for(int j = i+1; j < n-1; j++) {
				if(arr[i]+arr[j] > m) continue;
				for(int k = j+1; k < n; k++) {
					tmp = arr[i] + arr[j] + arr[k];
					
					if(m == tmp) {
						return tmp;
					}
					
					if(answer < tmp && tmp < m) {
						answer = tmp;
					}
				}
			}
		}
		return answer;
	}
}