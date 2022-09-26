package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day30_B_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int countarr[] = new int[8001];
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int median = 4001; //중앙값. -4000~4000 제외
		int mode = 4001; //최빈값. -4000~4000 제외
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			countarr[x+4000]++;
			
			sum += x;
			max = Math.max(max, x);
			min = Math.min(min, x);
		}
		
		int count = 0;
		int mode_max = 0;
		boolean flag = false;
		
		for(int i = min + 4000; i <= max + 4000; i++) {
			
			if(countarr[i] > 0) {	//입력된 값이 있다면
				if(count < (n+1)/2) {	//누적횟수가 전체 길이의 절반보다 작은
					count += countarr[i];	//값이 몇 번씩 입력됐는지
					median = i - 4000;
				}
				
				if(mode_max < countarr[i]) {
					mode_max = countarr[i];
					mode = i - 4000;
					flag = true;
				}else if(mode_max == countarr[i] && flag == true) {
					mode = i - 4000;
					flag = false; //값은 최빈값 나와도 두번쨰에서 멈추기 위함
				}
			}
		}
		System.out.println(Math.round((double)sum/n));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}