package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Day14_B_1712_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
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
