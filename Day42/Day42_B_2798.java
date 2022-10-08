package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day42_B_2798 {

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
	
	static int Blackjack (int[] arr, int n, int m) {
		int answer = 0;
		int tmp = 0;
		for(int i = 0; i < n-2; i++) {	//처음부터 n-2(j, k가 반복해줄 부분)
			
			if(arr[i] > m) continue;	//첫 번째 카드가 m보다 크면 넘어간다
			
			for(int j = i+1; j < n-1; j++) {	//두번째부터 n-1(마지막은 k)
				
				if(arr[i] + arr[j] > m) continue; //처음+두번째 합이 m보다 크면 넘어간다
				
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