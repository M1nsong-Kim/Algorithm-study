package codingtestAndAlgorithm.Day217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj6588 {

	static boolean[] nums = new boolean[1_000_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		getPrime();

		int n = 0;
		boolean isTrue = false;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			
			for(int i = 3; i <= n/2 + 1; i += 2) {
				if(!nums[i] && !nums[n-i]) {
					sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
					isTrue = true;
					break;
				}
			}
			
			if(!isTrue) {
				sb.append("Goldbach's conjecture is wrong.");
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

	static void getPrime() {
		nums[0] = true;
		nums[1] = true;
		
		for(int i = 2; i <= Math.sqrt(nums.length); i++) {
			if(nums[i]) {
				continue;
			}
			
			for(int j = i*i; j < nums.length; j += i) {
				nums[j] = true;
			}
		}
	}
}
// 복습 과정 https://gimbalja.tistory.com/415