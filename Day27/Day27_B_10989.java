package codingtestAndAlgorithm;

import java.io.*;

public class Day27_B_10989 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int count[] = new int[10001];		//입력되는 숫자의 범위는 10_000까지
		
		for(int i = 0; i < n; i++) {
			count[Integer.parseInt(br.readLine())]++;	//count 함수의 인덱스 = 입력한 수
		}
		
		br.close();
		
		for(int i = 1; i < count.length; i++) {	//문제에서 0은 입력하지 않아서 1부터 시작
			while(0 < count[i]) {	//해당 인덱스값이 입력되었다면
				sb.append(i).append('\n');	//인덱스값=입력값과 줄바꾸기를 결합
				count[i]--;			//1번 입력되었으므로 1번 줄인다
			}
		}
		System.out.println(sb);
	}
}
