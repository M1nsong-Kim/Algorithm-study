package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day_13_B_1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			boolean[] check= new boolean[26];
			boolean group = true;
			
			for(int j = 0; j < s.length(); j++) {
				
				if(check[s.charAt(j) - 'a']) {
					if(s.charAt(j) != s.charAt(j-1)) {
						group = false;
						break;
					}
				}else {
					check[s.charAt(j)-'a'] = true;
				}
			}
			if(group) {count++;}
		}
		System.out.println(count);
	}
}