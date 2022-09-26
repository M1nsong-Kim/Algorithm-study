package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day30_B_1427_first {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        String n = st.nextToken();
	        long arr[] = new long[n.length()];
	        
	        for(int i = 0; i < n.length(); i++) {
	            arr[i] = n.charAt(i) - '0';
	        }
//	        System.out.println(Arrays.toString(arr)); //배열 중간 확인용
	        
	        int count[] = new int[10]; //한 자리수당 범위 0~9
	        
	        //내림차순 정렬 -카운팅 정렬
	        for(int i = 0; i < n.length(); i++) {
	            count[(int)arr[i]]++;
	        }
	        
//	        System.out.println(Arrays.toString(count)); //배열 중간 확인용
	        
	        for(int i = 9; i >= 0; i--) {
	            while(count[i] > 0) {
	                sb.append(i);
	                count[i]--;
	            }
	        }    
	        System.out.println(sb);    

	}

}
