package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day40_B_2447 {
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		star10(0, 0, n, false);
		
		for(int i = 0; i < n; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void star10(int x, int y, int n, boolean blank) {
		if(blank) {	//공백이라면
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
				 	arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {	//9칸씩 나누다가 더이상 쪼갤 수 없다면
			arr[x][y] = '*';	//별 찍기 시작
			return;
		}
		
		int size = n/3;
		int count =0;
		for(int i = x; i < x+n; i+=size) {		//입력한 size 덩어리별로 움직인다
			for(int j = y; j < y+n; j+=size) {
				count++;
				if(count == 5) {	//9칸씩 나누므로 매번 공백은 가운데인 5번째에서 나타난다
					star10(i, j, size, true);	//true = blank
				}else {
					star10(i, j, size, false);
				}
			}
		}
	}

}