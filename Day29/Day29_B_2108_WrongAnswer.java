package codingtestAndAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day29_B_2108_WrongAnswer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		int count = 0;
		int max = -1;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		System.out.println(sum/n);	//평균
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr)); //arr 배열 확인
		
		System.out.println(arr[(n-1)/2]); //중앙값
		//최빈값을 구하기 위해 빈도수 구하기
		int mod = arr[0];
		boolean check = false;
		for(int i = 0; i < n-1; i++) {
			if(arr[i] == arr[i+1]) {
				count++;
			}else {
				count = 0;
			}
			
			if(max < count) {
				max = count;
				mod = arr[i];
				check = true;
			}else if(max == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		System.out.println(mod);
		System.out.println(arr[n-1] - arr[0]); //범위	
	}
}
