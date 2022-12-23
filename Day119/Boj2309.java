package codingtestAndAlgorithm;

import java.io.*;
import java.util.Arrays;

public class Boj2309 {

	static int[] dwarves;
	static int len;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarves = new int[9];
		len = dwarves.length;	// 9명으로 고정되어 있긴 하지만 코드의 유연성을 위해 변수로 선언하기
		
		for(int i = 0; i < len; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
		}
		
		
		int[] answer = sevenDwarves(dwarves);
		for(int i : answer) {
			System.out.println(i);
		}
		
	}
	
	public static int[] sevenDwarves(int[] dwarves) {
		len = dwarves.length;
		int[] arr = dwarves;
		int[] answer = new int[7];
		// 7보다 적은데도 합이 100이 될 수도 있음 -> count로 난쟁이의 수를 센다 
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i < len-1; i++) {	
			//배열의 끝에 있는 수는 항상 아래 코드에 껴 있으므로 확인할 필요 없다
			// + (j = i+1이라서 len까지 하면 배열의 크기를 벗어남)
			int temp1 = dwarves[i];	// 기존값 저장
			dwarves[i] = 0;
			
			for(int j = i+1; j < len; j++) {
				int temp2 = dwarves[j];	// 기존값 저장
				dwarves[j] = 0;
				
				for(int k = 0; k < len; k++){
					sum += dwarves[k];
					
					// 0이 아니다 == 본래 숫자를 가지고 있었다
					if(dwarves[k] != 0) {
						count++;	// 본래 숫자를 가지고 더해진 난쟁이의 수 세기
					}
				}
				
				if(count == 7 && sum == 100) {
					int idx = 0;
					for(int k = 0; k < len; k++) {
						if(dwarves[k] != 0) {
							answer[idx] = dwarves[k];
							idx++;
						}
					}
				}
				
				//초기화
				count = 0;
				sum = 0;	
				dwarves[j] = temp2;	// 다시 값 넣어주기
			}
			dwarves[i] = temp1;	// 다시 값 넣어주기
		}
		
		Arrays.sort(answer);	// 오름차순 정렬
		return answer;
	}

}
// 과정 https://gimbalja.tistory.com/281