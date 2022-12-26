package codingtestAndAlgorithm.Day122;

import java.io.*;
import java.util.*;

public class Boj1107{
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = null;
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> brokenBtn = new ArrayList<Integer>();
		
		int n = sc.nextInt();	// 채널
		int m = sc.nextInt();	// 고장난 버튼 개수
		
		//st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			brokenBtn.add(sc.nextInt());
		}
		
		int min = Math.abs(n - 100); // 모든 숫자버튼이 고장났을 때는 +, -로만 움직여야 한다
		for(int i = 0; i <1_000_000; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			for(int j = 0; j < len; j++) {
				if(brokenBtn.contains(str.charAt(j)-'0')) {	
					// 0~999,999에 해당하는 숫자 i의 자리수 중 하나가 고장난 버튼의 숫자라면
					isBreak = true;
					break;	// 빠져나온다 (그 숫자 거름)
				}
			}
			
			if(!isBreak) {
				min = Math.min(min ,Math.abs(n - i)+len);
			}
		}

		System.out.println(min);
	}
}
// 과정 https://gimbalja.tistory.com/285