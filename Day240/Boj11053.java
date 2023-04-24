package codingtestAndAlgorithm.Day240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());	// 숫자 넣기
            int idx = max;	// 이전 인덱스
            
            while (input <= arr[idx]) {	// 현재 입력된 숫자가 앞의 수들보다 작다면(증가수열이 아니라면)
                idx--;
            }
            arr[idx + 1] = input;	// 중복이면 첫번째 중복 숫자 자리에, 아니면 원래 위치에 입력 숫자 저장
            
            if (idx == max) {	//  증가 수열이라면
            	max++;
            }
        }
        
        System.out.println(max);
        br.close();
	}

}
// 복습 과정 https://gimbalja.tistory.com/441