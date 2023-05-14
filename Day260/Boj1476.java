package codingtestAndAlgorithm.Day260;

public class Boj1476 {

	public static void main(String[] args) throws Exception{
		int e = read();
		int s = read();
		int m = read();
		int year = 0;
		
		while (true) {
            year++;
            if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0) {            	
            	break;
            } 
        }

        System.out.println(year);
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
// 복습 과정 https://gimbalja.tistory.com/460