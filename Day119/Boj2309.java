package codingtestAndAlgorithm;

import java.io.*;
import java.util.Arrays;

public class Boj2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarves = new int[9];
		int len = dwarves.length;	// 9명으로 고정되어 있긴 하지만 코드의 유연성을 위해 변수로 선언하기
		int fake1 = 0;
		int fake2 = 0;
		int sum = 0;
		
		for(int i = 0; i < len; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
			sum += dwarves[i];
		}
		Arrays.sort(dwarves);
		
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(sum - dwarves[i] - dwarves[j] == 100) {
					fake1 = dwarves[i];
					fake2 = dwarves[j];
				}
			}
		}
		
		for(int i = 0; i < len; i++) {
			if(fake1 == dwarves[i] || fake2 == dwarves[i]) {
				continue;
			}
			System.out.println(dwarves[i]);
		}
	}
}
// 과정 https://gimbalja.tistory.com/281