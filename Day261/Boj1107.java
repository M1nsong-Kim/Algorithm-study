package codingtestAndAlgorithm.Day261;

import java.util.ArrayList;

public class Boj1107 {

	public static void main(String[] args) throws Exception{
		ArrayList<Integer> brokenBtn = new ArrayList<Integer>();
		int channel = read();
		int count = read();
		
		for(int i = 0; i < count; i++) {
			brokenBtn.add(read());
		}
		
		int min = Math.abs(channel - 100); // 모든 숫자버튼이 고장났을 때는 +, -로만 움직여야 한다
		for(int i = 0; i <1_000_000; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			for(int j = 0; j < len; j++) {
				if(brokenBtn.contains(str.charAt(j)-'0')) {	
					isBreak = true;
					break;
				}
			}
			
			if(!isBreak) {
				min = Math.min(min ,Math.abs(channel - i)+len);
			}
		}

		System.out.println(min);
	}

	static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		if(c == 13) {
			System.in.read();
		}
		return n;
	}
}
// 복습 과정 https://gimbalja.tistory.com/461