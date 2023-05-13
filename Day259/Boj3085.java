package codingtestAndAlgorithm.Day259;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj3085 {
	
	static int n;
	static char[][] candies;
	static int max;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = read();
		candies = new char[n][n];
		max = 0;

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				candies[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				// 가로가 다르다
				if(candies[i][j] != candies[i][j+1]) {
					// 바꾸기
					change(i, j, i, j+1);
					check();
					// 돌려놓기
					change(i, j, i, j+1);
				}
			}
		}
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n; j++) {
				// 세로가 다르다
				if(candies[i][j] != candies[i+1][j]) {
					change(i, j, i+1, j);
					check();
					change(i, j, i+1, j);
				}
			}
		}
		System.out.println(max);
	}
	
	static void change(int x1, int y1, int x2, int y2) {
		char temp = candies[x1][y1];
		candies[x1][y1] = candies[x2][y2];
		candies[x2][y2] = temp;
	}

	static int check() {
		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = 0; j < n-1; j++) {
				if(candies[i][j] == candies[i][j+1]) {
					count++;
				}else {
					count = 1;	// 다르면 1부터 다시 시작
				}
				max = Math.max(count, max);
			}
		}
		
		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = 0; j < n-1; j++) {
				if(candies[j][i] == candies[j+1][i]) {
					count++;
				}else {
					count = 1;
				}
				max = Math.max(count, max);
			}
		}
		return max;
	}

	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		if(c == 13) {
			System.in.read();
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/459