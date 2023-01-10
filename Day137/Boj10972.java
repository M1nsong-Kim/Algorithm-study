package codingtestAndAlgorithm.Day137;

import java.io.*;
import java.util.*;

public class Boj10972 {
	
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation()) {	// 그 다음 순열이 존재한다면
			for(int val : nums) {
				bw.write(val+" ");
			}
		}else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		
	}
	
	// 다음 순열 있는지 체크
	public static boolean nextPermutation() {
		
		int i = nums.length - 1;
		while(i > 0 && nums[i-1] >= nums[i]) {	// 내림차순이 되기 직전의 자리 찾기
			i--;
		}
		if(i < 1) {	// i == 0 --> 전체 내림차순(즉, 가장 마지막 순열)
			return false;
		}
		
		int j = nums.length - 1;
		while(nums[i-1] >= nums[j]) {	// 내림차순 되기 직전 수 +1 찾기
			j--;
		}
		
		swap(i-1, j);	// 자리 바꾸기
		
		j = nums.length-1;
		
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	
	// 자리 바꾸기
	public static void swap(int n, int m) {
		int temp = nums[n];
		nums[n] = nums[m];
		nums[m] = temp;
	}

}
// 과정 https://gimbalja.tistory.com/308