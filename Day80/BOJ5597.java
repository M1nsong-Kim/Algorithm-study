package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5597 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] count = new int[31];	// 카운팅 정렬을 위해 인덱스가'30'까지 들어가야 하므로 31크기의 배열 생성
		
		for(int i = 0; i < 28; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}
		
		//디버깅
//		System.out.println(Arrays.toString(count));
		
		for(int i = 1; i < count.length; i++) {	// 출석번호는 1부터 시작
			if(count[i] == 0) {
				System.out.println(i);
			}
		}

	}

}
// 과정 https://gimbalja.tistory.com/187