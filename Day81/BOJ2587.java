package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2587 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] counting = new int[91];	//인덱스 '90'까지 나와야
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			counting[n]++;
		}
		
		
		int[] arr = new int[5];
		int j = 0;
		for(int i = 10; i < 90; i+=10) {	//인덱스값 10~90
			while(counting[i] > 0) {	//중복된 값도 넣으므로 if문이 아닌 while문
				arr[j] = i;
				counting[i]--;
				j++;
			}
		}
		
		System.out.println(sum/5);	//평균
		System.out.println(arr[2]);	//중앙값 (인덱스 0, 1, 2, 3, 4 중 2)

	}

}
// 과정 https://gimbalja.tistory.com/188