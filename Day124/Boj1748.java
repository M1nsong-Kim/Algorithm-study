package codingtestAndAlgorithm.Day124;

import java.io.*;

public class Boj1748 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(i < 10) {
				count++;
			}else if(i < 100) {
				count += 2;
			}else if(i < 1_000) {
				count += 3;
			}else if(i < 10_000) {
				count += 4;
			}else if(i < 100_000) {
				count += 5;
			}else if(i < 1_000_000) {
				count += 6;
			}else if(i < 10_000_000) {
				count += 7;
			}else if(i < 100_000_000) {
				count += 8;
			} else {	//if(i == 100_000_000) {
				count += 9;
			}
		}
		
		System.out.println(count);

	}

}
// 과정 https://gimbalja.tistory.com/289