package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day45_B_1018 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[] chess = new String[m];
		for(int i = 0; i < m; i++) {
			chess[i] = br.readLine();
		}
		
		//체스판 자르기
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < m - 7; i++) {	//체스판 자르는 경우의 수: 8x8 = 1이므로 -7을 해준다(8이면 1이 나올 수 있도록)
			for(int j = 0; j < n - 7; j++) {
				int curResult = Newchessboard(i, j, chess);	//체스판 최소비용
				
				if(result > curResult) {
					result = curResult;	//최소값 갱신
				}
			}
		}
		System.out.println(result);
	}

	static int Newchessboard(int startRow, int startCol, String[] chess) {
		String[] origin = {"WBWBWBWB", "BWBWBWBW"};
		int WhiteFirst = 0;
		
		for(int i = 0; i < 8; i++) {
			int m = startRow + i;
			for(int j = 0; j < 8; j++) {
				int n = startCol + j;
				
				if(chess[m].charAt(n) != origin[m % 2].charAt(j)) { //origin에 %2하는 이유는 어느 숫자가 나오든 origin의 0 또는 1번째 인덱스값을 사용하기 위함
					WhiteFirst++;									//입력한 체스판 요소가 origin과 다르다면 +1
				}
			}
			
		}
		return Math.min(WhiteFirst, 64 - WhiteFirst);	//8x8에서 w가 먼저일 때, b가 먼저일 때의 최소비용을 더하면 64
	}
}