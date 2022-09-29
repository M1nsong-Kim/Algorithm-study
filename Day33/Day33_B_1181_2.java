package codingtestAndAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day33_B_1181_2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		String arr[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}else {
					return s1.length() - s2.length();
				}
			}
		});
		System.out.println(arr[0]);
		for(int i = 1; i < n; i++) {
			if(!arr[i].equals(arr[i-1])) {
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}