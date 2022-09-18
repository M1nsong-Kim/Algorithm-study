package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day12_B_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] change = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		String s = sc.next();
		
		for(int i = 0; i < 8;i++) {
			if(s.contains(change[i])) {
				s = s.replace(change[i], "@");
			}
		}System.out.println(s.length());
	}

}
