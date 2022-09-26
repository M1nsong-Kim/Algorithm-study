package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day30_B_1427_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		int count[] = new int[10];
		
		for(int i = 0; i < n.length(); i++) {
			count[n.charAt(i)-'0']++;
		}
		
		for(int i = 9; i >= 0; i--) {
			while(count[i] > 0) {
			System.out.print(i);
			count[i]--;
			}
		}
	}
}