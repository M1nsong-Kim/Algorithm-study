package codingtestAndAlgorithm.Day152_153;

import java.io.*;
import java.util.*;

public class Boj14391_bitmask {

	static int n, m;
	static int max = Integer.MIN_VALUE;
	static int[][] paper;
	static boolean[][] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = str.charAt(j)-'0';
			}
		}

		getMax();
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

	static void getMax() {
		// 2^n*m 
		for(int t = 0; t < (1<<(n*m)); t++) {
			int num = 0;
			// 0 -> 가로
			for(int i = 0; i < n; i++) {
				int temp = 0;
				for(int j = 0; j < m; j++) {
					if((t&(1<<(i*m+j))) == 0) {	// 해당 자리의 비트가 꺼져있다면 == 0이라면 == 가로라면
						temp *= 10;	// 더해질 때마다 자릿수 늘려주기
						temp += paper[i][j];
					}else {
						num += temp;
						temp = 0;	// 세로니까 초기화
					}
				}
				num += temp;
			}
			// 1 -> 세로
			for(int i = 0; i < m; i++) {
				int temp = 0;
				for(int j = 0; j < n; j++) {
					if((t&(1<<j*m+i)) != 0) {	// 해당 자리의 비트가 켜있다면 == 1이라면 == 세로라면
						temp *= 10;	// 더해질 때마다 자릿수 늘려주기
						temp += paper[j][i];
					}else {
						num += temp;
						temp = 0;	// 가로니까 초기화
					}
				}
				num += temp;
			}
			max = Math.max(num, max);
		}

	}
}
// 과정 https://gimbalja.tistory.com/324