package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day30_B_2108_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int countarr[] = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int median = 4001;
		int mode = 4001;
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			countarr[x+4000]++;
			sum += x;
			max = Math.max(max, x);
			min = Math.min(min, x);
		}
		
		int count = 0;
		int mode_max = 0;
		boolean flag = false;
		
		for(int i = min + 4000; i <= max + 4000; i++) {
			if(countarr[i] > 0) {
				if(count < (n+1)/2) {
					count += countarr[i];
					median = i - 4000;
				}
				
				if(mode_max < countarr[i]) {
					mode_max = countarr[i];
					mode = i - 4000;
					flag = true;
				}else if(mode_max == countarr[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
			}
		}
		System.out.println(Math.round((double)sum/n));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}