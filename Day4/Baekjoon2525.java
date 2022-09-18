package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon2525{
    public static void main(String[] agrs){
    	Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        
        int total = A * 60 + B + C;
        A = total / 60;
        B = total % 60;
            
        if(A >= 24){
            A = A - 24;
        }
        System.out.println(A + " " + B);
	}
}