package codingtestAndAlgorithm.Day264_265;

public class Boj6064 {
	
	/*
		m = 10
		n = 12
		
		1:	<1:1>
		2:	<12>
		...
		11:	<1:11>		11:11 -> x > 10 -> <1:11>
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
		...
		60: <10:12>		최소공배수번째 해가 마지막
	 */

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		
		int t = read();
		
		for(int i = 0; i < t; i++) {
			int M = read();
			int N = read();
			int x = read();
			int y = read();
		
			int multiple = x;	// 곱할 수
			int lcm = (M*N/gcd(M, N));	// 최소공배수
			while(true) {
				if(multiple > lcm) {	// 마지막 해 == 최소공배수
					sb.append(-1).append("\n");
					break;
				}else if((multiple % N == 0 ? N : multiple % N) == y){
					sb.append(multiple).append("\n");
					break;
				}
				multiple += M;
			}
		}
		System.out.println(sb);
	}

	static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
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