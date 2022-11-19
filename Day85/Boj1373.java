package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1373 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String binary = br.readLine();
		int len = binary.length();
		
		String[][] arr = new String[(len/3)+1][3]; //3으로 나누어 떨어지지 않을 수 있으므로 1이 더 큰 자리로 준비한다
		
		int j = 0;
		int k = 0;
		for(int i = len-1; i >= 0; i--) {	//뒤에서부터 3개씩 끊어야 하므로 뒤부터 반복문을 돌린다
			arr[j][k] = binary.charAt(i)+"";
			k++;
			
			if(k == 3) {
				j++;	//다음[!][] 배열로 넘어간다
				k = 0;
			}
		}
		
		//디버깅
		//System.out.println(Arrays.deepToString(arr));
		
		int sum = 0;
		String octal = "";	// 0이 나와도 빈공간으로 채워야 하므로 문자열로 선언
		for(int i = len/3; i >= 0; i--) {
			sum = 0;
			for(int idx = 0; idx < 3; idx++) {
				String ch = arr[i][idx];
				if(ch == null) {
					continue;
				}
				if(ch.equals("1")) {
					sum += (int)Math.pow(2, idx);	//1이면 2^idx를 더한다
				}else {
					sum += 0;	//0이나 null이면 0을 더한다
				}
				//디버깅 System.out.println(sum);
			}
			octal += sum;
		}

		System.out.println(octal);
	}

}
// 메모리 초과