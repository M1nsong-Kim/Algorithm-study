package codingtestAndAlgorithm.Day221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9613 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];
			for(int j = 0; j < n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for(int j = 0; j < nums.length - 1; j++) {
				for(int k = j+1; k < nums.length; k++) {
					sum += gcd(nums[j], nums[k]);
				}
			}
			
			System.out.println(sum);
		}
	}
	
	// gcd
	static int gcd(int x, int y) {
		if(x % y == 0) {	// ★
			return y;
		}
		return gcd(y, x%y);
	}

}
// 복습 과정 https://gimbalja.tistory.com/421