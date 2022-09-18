package codingtestAndAlgorithm;

import java.util.Scanner;

public class Day14_B_1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
        int c = sc.nextInt();
        
        long n = 0;
        
        if(b < c) {
        	while(true) {
        		n++;
        		if(a + b * n < c * n) {
        		break;
        		}
        	}
        }else {n = -1;}
        System.out.println(n);
	}
}
