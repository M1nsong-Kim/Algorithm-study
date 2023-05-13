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
			for(int j = 0; j < n; j++) {
				// 가로 세로 다를 떄만 바꾸지 말고 모두 바꿔봄 -> 모든 행, 열 확인 가능
				if(j < n-1) { 
					change(i, j, i, j+1);	// 자리 바꾸기
					max = Math.max(check(i, j), max);	// 바뀐 대상 기준 세기
					max = Math.max(check(i, j+1), max);	// 바뀐 대상 기준 세기
					change(i, j, i, j+1);	// 원상복구
				}

				if(i < n-1) {
					change(i, j, i+1, j);
					max = Math.max(check(i, j), max);
					max = Math.max(check(i+1, j), max);
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

	static int check(int x, int y) {
		int cnt1 = 1;	// candies[x][y] 포함해서 1부터 세기
        for (int i = x-1; i >= 0; i--) {
            if (candies[i][y] == candies[x][y]) {            	
            	cnt1++;
            } else {            	
            	break;
            } 
        }
        for (int i = x+1; i < n; i++) {
            if (candies[i][y] == candies[x][y]){            	
            	cnt1++;
            } else {            	
            	break;
            } 
        }

        int cnt2 = 1;	// candies[x][y] 포함해서 1부터 세기
        for (int i = y-1 ; i >= 0; i--) {
            if (candies[x][i] == candies[x][y]){            	
            	cnt2++;
            } else {            	
            	break;
            } 
        }
        for (int i = y+1; i < n; i++) {
            if (candies[x][i] == candies[x][y]){            	
            	cnt2++;
            } else {            	
            	break;
            } 
        }
		return Math.max(cnt1, cnt2);
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