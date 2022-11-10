package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day75BOJ1541 {

	public static void main(String[] args) throws IOException{
		// 가장 작아지도록 만드는 법 -> 가장 작은 수에서 가장 큰 수를 뺀다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] subtraction = br.readLine().split("-");
		
		// 디버깅 System.out.println(Arrays.toString(subtraction)); 
		
		int result = 0;
		for(int i = 0; i < subtraction.length; i++) {
			int sum = 0;
			String[] addtion = subtraction[i].split("\\+");
			
			for(int j = 0; j < addtion.length; j++) {
				// 덧셈 다 더함
				sum += Integer.parseInt(addtion[j]);
			}
			
			if(i == 0) {	//가장 처음에 있는 숫자라면
				result += sum;	//더해준다(가장 큰 수를 뺄 가장 작은 수)
			}else {
				result -= sum;
			}
			// 디버깅 System.out.print(sum + " " + "\n");
		}
		System.out.println(result);
	}

}
// 과정 https://gimbalja.tistory.com/182