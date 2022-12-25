package codingtestAndAlgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1476 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[3];
		
		int year = 0;
		while(true) {
			arr[0]++;
			arr[1]++;
			arr[2]++;
			if(arr[0] > 15) {	// 범위를 벗어나면
				arr[0] = 1;	// 1로 초기화
			}
			if(arr[1] > 28) {
				arr[1] = 1;
			}
			if(arr[2] > 19) {
				arr[2] = 1;
			}
			year++;
			
			if(arr[0] == e && arr[1] == s && arr[2] == m) {
				break;
			}
		}
		
		System.out.println(year);
	}

}
// 과정 https://gimbalja.tistory.com/283