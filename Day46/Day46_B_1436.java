package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day46_B_1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int num = 666;
		int arr[] = new int[10001];
		
		while(true) {
			String str = num + "";
			
			int series = 0;
			int idx = 0;
			for(int i = 0; i < str.length() - 3; i++) {
				int one = str.charAt(i);
				int two = str.charAt(i+1);
				int three = str.charAt(i+2);
				if(one == 6 && two == 6 && three == 6) {
					series = num;
					break;
				}
			}
			
			if(series == num) {
				arr[idx] = series;
				idx++;
				if(idx == 10001)
					break;
			}
			num++;
		}
		System.out.println(arr[n]);
	}

}
