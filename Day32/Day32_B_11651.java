package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Day32_B_11651 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int [n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
				public int compare(int[] n1, int[] n2) {
					if(n1[0] == n2[0]) {
						return Integer.compare(n1[1], n2[1]);
					}else {
						return Integer.compare(n1[0], n2[0]);
					}
				}
		});
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i][1]+" "+arr[i][0]).append("\n");
		}
		System.out.println(sb);
	}
}
