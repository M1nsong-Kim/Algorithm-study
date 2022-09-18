package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon2480{
	public static void main(String[] agrs){
		Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        
        if(x == y && y == z){
            System.out.println(10000+(x*1000));
        }else if(x == y || y == z || x == z) {
        	if(x == y || x == z) {
        		System.out.println(1000+(x*100));
        	}else if(y == z) {
        		System.out.println(1000+(y*100));
        	}
        }else {
        	System.out.println(Math.max(x, Math.max(y, z)));
        }
	}
}