package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day38_B_25501 {
	static int count;	//static메서드에 들어갈 변수이므로 static변수로 만들어준다
	public static int recursion(String s, int l, int r){
		count++;	
		if(l >= r) return 1;
	    else if(s.charAt(l) != s.charAt(r)) return 0;
	    else return recursion(s, l+1, r-1);
	}
	
	public static int isPalindrome(String s){
		return recursion(s, 0, s.length()-1);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < t; i++) {
//			count = 0;	//이전 count값을 누적해서 나타내지 않도록 반복될 때마다 0으로 초기화
			String s = br.readLine();
			sb.append(isPalindrome(s)).append(" ").append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
}