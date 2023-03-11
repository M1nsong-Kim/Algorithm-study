package codingtestAndAlgorithm.Day196;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2580 {

	static int count;
	static int[][] sudoku = new int[9][9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) {
					count++;
				}
			}
		}
		
		backtracking(0, 0);

	}
	
	static void backtracking(int x, int y) throws IOException{
		if(y == 9) {	// 한줄 다 채움
			backtracking(x+1, 0);	// 다음 줄로
			return;
		}
		

		if(x == 9) {	// 끝까지 다 채움 -> 종료
			// 메인이 아닌 여기서 출력하는 이유 -> 가능한 경우의 수가 여러가지일 수 있으므로
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(j == 8) {
						bw.write(sudoku[i][j]+"\n");
					}else {					
						bw.write(sudoku[i][j]+" ");
					}
				}
			}
			bw.flush();
			bw.close();
			
			System.exit(0);	// 프로그램 종료
		}
		
		if(sudoku[x][y] == 0) {
			for(int i = 1; i < 10; i++) {
				if(isPossible(x, y, i)) {
					sudoku[x][y] = i;
					backtracking(x, y+1);
				}
			}
			// 잘못 들어간 값이라면 초기화
			sudoku[x][y] = 0;
			return;
		}
		backtracking(x, y+1);	// 이미 숫자가 채워진 구간
	}
	
	
	static boolean isPossible(int x, int y, int num) {	
		// 가로 확인
		for(int i = 0; i < 9; i++) {
			if(sudoku[x][i] == num) {
				return false;
			}
		}
		
		// 세로 확인
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][y] == num) {
				return false;
			}
		}
		
		// 3x3 확인
		int firstX = (x/3)*3;
		int firstY = (y/3)*3;
		for(int i = firstX; i < firstX + 3; i++) {
			for(int j = firstY; j < firstY + 3; j++) {
				if(sudoku[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

}
// 과정 https://gimbalja.tistory.com/390