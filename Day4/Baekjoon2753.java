package codingtestAndAlgorithm;

import java.util.Scanner;

public class Baekjoon2753 {
    public static void main(String[] agrs){
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            if(i % 4 == 0){
                if(i % 100 != 0 || i % 400 == 0){
                System.out.println("1");
                }else if(i % 100 == 0){
                    System.out.println("0");
                }
            }else{System.out.println("0");}
        }
    }