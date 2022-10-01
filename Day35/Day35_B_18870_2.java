package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
 
 
public class Day35_B_18870_2 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] sorted = new int[n];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	// rank를 매길 HashMap
 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		//map에 순위 넣기
		int rank = 0;
		for(int i = 0; i < arr.length; i++) {		//.contansKey() : 같은 값 있으면 true 반환
			if(!rankingMap.containsKey(sorted[i])) { // !가 붙었으므로 같은 값 없으면 = 중복 아니어야 아래 .put 실행 
				rankingMap.put(sorted[i], rank);	// .put : map에 값 추가
				rank++;		// map에 넣고나면 다음 순위를 가리킬 수 있도록 1씩 더한다
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int ranking = rankingMap.get(arr[i]);	//순위 가져옴 // .get(): map에 존재하면 입력받은 값 리턴, 없으면 null 
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
		
	}
}