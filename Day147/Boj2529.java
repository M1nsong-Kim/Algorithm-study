package codingtestAndAlgorithm.Day147;

import java.io.*;
import java.util.*;

public class Boj2529 {

	static int k;
	static int[] arr;
	static char[] inequality;
	static boolean[] visited = new boolean[10];	// 0~9 숫자 확인 고정
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		k = Integer.parseInt(br.readLine());
		inequality = new char[k];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			inequality[i] = st.nextToken().charAt(0);
		}
		
//		System.out.println(Arrays.toString(inequality));
		DFS("", 0);	// 빈 문자열에서 숫자 하나씩 더하기
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	
	 static boolean checkInequality(int n, int m, char ch) {
		 boolean check = true;
        if (ch == '<'){
        	if(n > m) {
        		check = false;
        	}
        }else {
        	if(n < m) {
        		check = false;
        	}
        }
        return check;
    }

	static void DFS(String nums, int depth) {
		if(depth == k+1) {	// k+1 만큼의 숫자를 구하면
			list.add(nums);
			return;
		}
		
		for(int i = 0; i < 10; i++) {	// 0~9 숫자 모두 확인하기
			// depth가 0일 땐 부등호로 비교할 수가 없으므로 바로 문자열에 넣기
			// || nums에 들어가있지 않은 숫자고, nums에 저장된 이전수와 비교했을 때 부등호가 성립한다면 
			if( depth == 0 || !visited[i] && checkInequality(nums.charAt(nums.length()-1)-'0', i, inequality[depth - 1])) {
				visited[i] = true;	// 방문(다시 들어가지 않도록)
				DFS(nums+i, depth+1);	// 현재 문자열에 조건 성립하는 문자 붙이기
				visited[i] = false;
			}
		}
	}
}
// 과정 https://gimbalja.tistory.com/319