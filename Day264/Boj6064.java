package codingtestAndAlgorithm.Day264;

public class Boj6064 {
	
	/*
		m = 10
		n = 12
		
		1:	<1:1>
		2:	<12>
		...
		11:	<1:11>	11:11 -> x > 10 -> <1:11>
		12:	<2:12>
		13:	<3:1>		3:13 -> y > 12 -> <3:1>
		14:	<4:2>
		...
		...
		21:	<1:9>
		22:	<2:10>
		23:	<3:11>
		...
		33:	<3:9>
		
		35:	<5:11>
		
		==> m의 배수 + x = x차례
	 */

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		
		int t = read();
		
		for(int i = 0; i < t; i++) {
			int M = read();
			int N = read();
			int x = read();
			int y = read();
		
			int multiple = 0;	// 곱할 수
		}
	}

	static void calendar() {
		
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
// https://gimbalja.tistory.com/463