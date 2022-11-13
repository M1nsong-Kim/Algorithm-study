package codingtestAndAlgorithm.Day78;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day78BOJ2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이의 수
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		
		int area = 0;	//넓이 변수
		for(int i = 0; i < n; i++) {	
			//StringTokenizer는 한 줄씩 인식
			st = new StringTokenizer(br.readLine());	
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x + 10; j++) {	//x좌표 한줄당
				for(int k = y; k < y + 10; k++) {	//y좌표 모두 확인
					if(paper[j][k] == 0) {	//아직 해당 좌표가 칠해지지 않았다면
						paper[j][k] = 1;	//칠하고
						area++;	//넓이에 더하기
					} 
				}
			}
			
		}
		
		System.out.println(area);
		
	}

}
// 과정 https://gimbalja.tistory.com/185