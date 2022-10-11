package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day45_B_1018_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[] chess = new String[m];
		
		for(int i = 0; i < m; i++) {
			chess[i] = br.readLine();
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < m - 7; i++) {
			for(int j = 0; j < n - 7; j++) {
				int curResult = Newchess(i, j, chess);
				
				if(result > curResult) {
					result = curResult;
				}
			}
		}
		System.out.println(result);
	}
	
	public static int Newchess(int startRow, int startCol, String[] chess) {
		String origin[] = {"WBWBWBWB", "BWBWBWBW"};
		int WhiteFirst = 0;
		for(int i = 0; i < 8; i++) {
			int row = startRow + i;
			for(int j = 0; j < 8; j++) {
				int col = startCol + j;
				
				if(chess[row].charAt(col) != origin[row % 2].charAt(j)) {
					WhiteFirst++;
				}
			}
		}
		return Math.min(WhiteFirst, 64 - WhiteFirst); 	//★Math.min 안씀
	}

}
