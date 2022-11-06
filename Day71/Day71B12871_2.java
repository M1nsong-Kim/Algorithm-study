package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day71B12871_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String t = br.readLine();
		String strS = s;
		String strT = t;
		int result = 0;
		

        if (s.length() != t.length()) {
            int len = lcm(s.length(), t.length());

            while (strS.length() != len) {
                strS += s;
            }

            while (strT.length() != len) {
                strT += t;
            }
        }

		if(strS.equals(strT)) {
            result = 1;
        }
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	
	// 최소공배수를 구하기 위한 최대공약수 메서드
	public static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	// 최소공배수
	public static int lcm(int x, int y) {
		return x*y/gcd(x,y);
	}

}
// 과정 https://gimbalja.tistory.com/178