package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day70B2004_2 {
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int twoCnt = count(n,2) - count((n-m),2) - count(m,2);	//n은 나눠지므로 그때마다 분모가 가진 개수만큼의 2의 개수가 줄어든다
		int fiveCnt = count(n,5) - count((n-m),5) - count(m,5);
		
		bw.write(String.valueOf(Math.min(twoCnt, fiveCnt)));
		bw.flush();
		bw.close();
		
	}
	
	public static int count(int n, int m) {
		count = 0;
		while(n >= m) {
			count += n/m;
			n /= m;
		}
		return count;
	}
}
// 과정 https://gimbalja.tistory.com/177