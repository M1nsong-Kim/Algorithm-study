package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day70B2004 {
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int twoCnt = twoCount(n) - twoCount(n-m) - twoCount(m);	//n은 나눠지므로 그때마다 분모가 가진 개수만큼의 2의 개수가 줄어든다
		int fiveCnt = fiveCount(n) - fiveCount(n-m) - fiveCount(m);
		
		if(twoCnt >= fiveCnt) {	//2의 개수가 더 적거나 같으면
			System.out.println(fiveCnt);	//5의 개수 출력(같을 경우 둘 중 아무거나 출력해도 상관없음)
		}else {					//5의 개수가 더 적으면
			System.out.println(twoCnt);
		}
	}
	
	public static int fiveCount(int n) {
		count = 0;
		while(n >= 5) {
			count += n/5;
			n /= 5;
		}
		return count;
	}
	
	public static int twoCount(int n) {
		count = 0;
		while(n >= 2) {
			count += n/2;
			n /= 2;
		}
		return count;
	}
}
// 과정 https://gimbalja.tistory.com/177