package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class methodTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarves = new int[9];
		int len = dwarves.length;
		int[] answer = new int[7];
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i < len; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(Arrays.toString(dwarves));
		
		// 일곱명이 아닌데 100이 될 수도 있음
		for(int i = 0; i < len-1; i++) {
			int temp1 = dwarves[i];
			dwarves[i] = 0;
			
			for(int j = i+1; j < len; j++) {
				int temp2 = dwarves[j];
				dwarves[j] = 0;
				
				for(int k = 0; k < len; k++){
					System.out.print("dwarves["+k+"] : "+dwarves[k]+" ");
					sum += dwarves[k];
					System.out.println("sum : "+sum);
					
					if(dwarves[k] != 0) {
						count++;
					}
				}
				System.out.println("count : "+count);
				System.out.println("---------------");

				if(count == 7 && sum == 100) {
					int idx = 0;
					for(int k = 0; k < len; k++) {
						if(dwarves[k] != 0) {
							System.out.println("k :"+k);
							answer[idx] = dwarves[k];
							idx++;
							/*
							if(idx > 6) {
								continue;
							}
							// 이 디버깅 코드 때문에 idx가 위의 continue를 포함한 if문이 필요
							System.out.println("dwarves["+k+"] : "+dwarves[k]);
							System.out.println("answer["+idx+"] :"+answer[idx]);
							System.out.println(Arrays.toString(answer));
							System.out.println(idx);
							 */
						}
					}
				}
				
				//초기화
				count = 0;
				sum = 0;	
				dwarves[j] = temp2;	// 다시 값 넣어주기
			}
			dwarves[i] = temp1;	// 다시 값 넣어주기
			System.out.println("다시 값 넣어주고: dwarves["+i+"] : "+dwarves[i]);
		}
		
		for(int i : answer) {
			System.out.println(i);
		}

	}

}
