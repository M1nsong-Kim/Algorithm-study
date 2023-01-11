package codingtestAndAlgorithm.Day138;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10973 {

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
		
		if(previousPermutation()) {	// 그 다음 순열이 존재한다면
			for(int val : nums) {
				bw.write(val+" ");
			}
		}else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		
	}
	
	// 이전 순열 있는지 체크
	public static boolean previousPermutation() {
		int i = nums.length - 1;
		while(i > 0 && nums[i-1] <= nums[i]) {	// 끝에서부터 오름차순인지 체크
			i--;
		}
		if(i < 1) {	// 전체 오름차순(즉, 맨첫번째 순열)
			return false;
		}
		
		int j = nums.length - 1;
		while(nums[i-1] <= nums[j]) {
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
// 과정 https://gimbalja.tistory.com/310