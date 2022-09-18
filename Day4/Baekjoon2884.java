package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon2884{
	public static void main(String[] agrs){
		Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int M = scan.nextInt();
        if(M < 45){
            if(H == 0){
                H = 23; 
                M = 60-(45-M);
            }else{
                H = H - 1;
                M = 60-(45-M);
            }System.out.println(H + " " + M);
        }else{
            H = H;
            M = M - 45;
            System.out.println(H + " " + M);
        }
	}
}