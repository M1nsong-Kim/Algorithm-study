package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Day64_B_10824 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger first = new BigInteger(st.nextToken()+st.nextToken());
		BigInteger second = new BigInteger(st.nextToken()+st.nextToken());
		
		System.out.println(first.add(second));
		
	}

}
//과정 https://gimbalja.tistory.com/171