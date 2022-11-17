package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj9613 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			// 줄마다 초기화하기 위해 ArrayList 객체를 반복문 안에 생성
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));	//숫자 넣기
				// 디버깅
				//System.out.print(list.get(j)+" ");
			}
			
			
			long sum = 0;
			for(int j = 0; j < list.size() - 1; j++) {
				for(int k = j+1; k < list.size(); k++) {
					sum += gcd(list.get(j), list.get(k));
				}
			}

			System.out.println(sum);
			
		}

	}
	
	// 최대공약수
	 public static int gcd(int x, int y) {
        if(y == 0) {
        	return x;	        	
        }else {
        	return gcd(y, x%y);	        	
        }
	}

}
// 과정 https://gimbalja.tistory.com/190