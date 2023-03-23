package codingtestAndAlgorithm.Day208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj17299 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[1_000_001];
		int[] stack = new int[n];	// stack 대신 배열로
		int idx = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}
		
		for(int i = 0; i < n; i++) {
			while(idx > 0 && count[arr[i]] > count[arr[stack[idx-1]]]) {	// 스택 맨 위랑 비교
				arr[stack[--idx]] = arr[i];	// pop()은 전위연산자로 표기할 것
			}
			
			stack[idx++] = i;
		}
		
		while(idx != 0) {
			arr[stack[--idx]] = -1;	// pop()은 전위연산자로 표기할 것
		}
		
		for(int val : arr) {
			bw.write(val + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}