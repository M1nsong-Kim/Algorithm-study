package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
 
 
public class Day35_B_18870_3 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] sorted = new int[n];
		
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		int rank = 0;
		//★
		for(int i = 0; i < arr.length; i++) {
			if(!rankingMap.containsKey(sorted[i])) {
				rankingMap.put(sorted[i], rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int ranking = rankingMap.get(arr[i]);
			sb.append(ranking).append(' ');
		}
		// ★
		System.out.println(sb);
	}
}