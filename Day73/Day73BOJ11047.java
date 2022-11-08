package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day73BOJ11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//동전 개수
		int k = Integer.parseInt(st.nextToken());	//만들 금액
		int[] coin = new int[n];
		
		for(int i = 0; i < coin.length; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i = n-1; i >= 0; i--) {	//가장 큰값부터 거꾸로
			if(k >= coin[i]) {	//k가 i번째 동전단위보다 크다면
				while(true) {
					k -= coin[i];	//계속 i번째 동전단위만큼 뺀다
					count++;
					if(k < coin[i])	//k가 i번째 동전단위보다 작아졌다면
						break;	//while문만 탈출 -> 그다음작은 단위로 넘어감
				}
				/* while문 대신
				 * 
				 * count += k/coin[i];
				 * k = k%coin[i];
				 * 
				 * 도 가능*/
			}
		}
		System.out.println(count);
	}

}
