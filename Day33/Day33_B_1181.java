package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Day33_B_1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];

		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator <String>(){
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) { //길이가 같다면
					return s1.compareTo(s2);	//compareTo = 사전순 정렬
				}else {
					return s1.length() - s2.length(); //길이가 다르다면 오름차순으로 순서 바뀜
				}
			}
		});
		
		sb.append(arr[0]).append('\n');	//뒤의 문자열과 비교할 문자열 먼저 출력
		
		for(int i = 1; i < n; i++) {
			if(!arr[i].equals(arr[i-1])) { //arr[i]가 바로 앞에 출력된 문자열과 같지 않다면(중복이 아니라면)	
				sb.append(arr[i]).append('\n');	//출력
			}
		}
		System.out.println(sb);
	}
}