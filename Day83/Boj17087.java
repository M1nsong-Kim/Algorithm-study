package codingtestAndAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj17087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			//주어진 숫자에서 수빈이의 위치를 빼고 리스트에 추가한다
			list.add(Math.abs(sc.nextInt()-s));		
			
			//디버깅
			System.out.println(list.get(i));
		}
		

		
		int result = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			// n개 이상의 수의 최대공약수: gcd(gcd(gcd(gcd(a,b),c),d),e)...
			result = gcd(result, list.get(i));
		}
		
		// 리스트 비우기
		list.clear();
		System.out.println(result);
	}
	
	
	//최대공약수
	public static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}else {
			return gcd(y, x%y);
		}
	}

}
// 과정 https://gimbalja.tistory.com/192