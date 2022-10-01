package codingtestAndAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day35_B_18870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sortarr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sortarr[i] = arr[i];
		}
	

		sortarr = Arrays.stream(sortarr).distinct().toArray();	//중복 제거
		Arrays.sort(sortarr);	//오름차순 정렬
		
//		System.out.println(Arrays.toString(sortarr));	//sortarr 확인용
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < sortarr.length; j++){
				if(arr[i] == sortarr[j]) {
					arr[i] = j;
					break;
				}
			}
			System.out.print(arr[i] + " ");
		}
	}

}
