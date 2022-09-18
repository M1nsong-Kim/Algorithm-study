package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= n;i++) {
			if(i <= 99) {
				count++;
			}else {
				String[] nArr = Integer.toString(i).split("");
				if(Integer.parseInt(nArr[2]) - Integer.parseInt(nArr[1]) 
						== Integer.parseInt(nArr[1]) - Integer.parseInt(nArr[0])) {
					count++;
				}
			}
		}System.out.println(count);
	}

}
