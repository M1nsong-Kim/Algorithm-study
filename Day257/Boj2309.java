package codingtestAndAlgorithm.Day257;

import java.util.Arrays;

public class Boj2309 {
	

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		int[] dwarves = new int[9];
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			dwarves[i] = read();
			sum += dwarves[i];
		}

		Arrays.sort(dwarves);
		
		loop :
		for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if((sum - dwarves[i] - dwarves[j]) == 100) {
                    dwarves[i] = 0;
                    dwarves[j] = 0;
                    break loop;
                }
            }
        }

		for(int i = 0; i < 9; i++) {
			if(dwarves[i] != 0) {
				sb.append(dwarves[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

	static int read() throws Exception {
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32) {	    	
	    	n = (n << 3) + (n << 1) + (c & 15);
	    } 
	    if (c == 13) {	    	
	    	System.in.read();
	    } 
	    return n;

	}
}
// 복습 과정 https://gimbalja.tistory.com/458