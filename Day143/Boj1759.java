package codingtestAndAlgorithm.Day143;

import java.io.*;
import java.util.*;

public class Boj1759 {
	
	static int l, c;
	static char[] arr;
	static char[] alphabet;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		alphabet = new char[c];
		arr = new char[l];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alphabet);	// 사전순 정렬을 위해
		DFS(0, 0);
		bw.flush();
		bw.close();
	}
	
	static void DFS(int start, int depth) throws IOException {
		if(depth == l) {
			if(condition()) {	// 모음/자음 조건 일치 여부
				for(char ch : arr) {
					bw.write(ch+"");
				}
				bw.newLine();
			}
			return;
		}
		
		for(int i = start; i < c; i++) {
			arr[depth] = alphabet[i];
			DFS(i+1, depth+1);	// 오름차순(메인 메서드에서 사전순 정렬 후 가능)
		}
	}
	
	// 모음/자음 검사
	static boolean condition() {
		int vowelsCnt = 0;
		int consonantsCnt = 0;
		for(int i = 0; i < l; i++) {
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vowelsCnt++;
			} else {				
				consonantsCnt++;
			}
		}
		if(vowelsCnt >= 1 && consonantsCnt >= 2) {
			return true;
		}
		return false;
	}
}
// 과정 https://gimbalja.tistory.com/315