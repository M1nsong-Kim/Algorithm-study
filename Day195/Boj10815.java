package codingtestAndAlgorithm.Day195;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10815 {

	static int n;
	static int[] card;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		card = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(binarySearch(num)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int binarySearch(int num) {
		int lo = 0;
		int hi = n-1;
		int mid = 0;
		
		while(lo <= hi) {
			mid = (lo+hi)/2;

			if(card[mid] == num) {	// 경계에 걸림
				return 1;
			}
			
			if(card[mid] < num) {	// 중간보다 큼 -> 그 윗값들만 확인
				lo = mid + 1;
			}else {
				hi = mid - 1;
			}
		}
		return 0;
	}

}
// 과정 https://gimbalja.tistory.com/389