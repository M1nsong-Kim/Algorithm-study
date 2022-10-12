package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day46_B_1436_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int number = 666;	//666은
		int count = 1;		//1번째
		
		while(count != n) {
			number++;
			String str = number + "";
			
			if(str.contains("666")) {
				count++;
			}
		}
		System.out.println(number);
		
	}

}