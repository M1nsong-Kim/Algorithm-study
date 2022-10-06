package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day40_B_2447_2 {
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		arr = new char[n][n];
		
		star10(0, 0, n, false);
		
		for(int i = 0; i < n; i++) {
			bw.write(arr[i]);
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
	
	static void star10(int x, int y, int n, boolean blank) {
		if(blank) {
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {
			arr[x][y] = '*';
			return;		//★ if문 밖에 return 씀
		}
		
		int size = n/3;
		int count = 0;
		for(int i = x; i < x+n; i += size) {
			for(int j = y; j < y+n; j += size) {
				if(count == 5) {
					star10(i, j, n, true); 	//★ i, j 대신 x, y 씀
				} else {
					star10(i, j, n, false);	//★ i, j 대신 x, y 씀
				}
			}
		}
	}

}