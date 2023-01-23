package codingtestAndAlgorithm.Day150;

import java.io.*;
import java.util.*;

public class Boj11723 {

	static Set<Integer> S = new HashSet<>();	// 중복 제거
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "add":
				add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				check(Integer.parseInt(st.nextToken()));
				break;
			case "toggle":
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static void add(int x) {
		S.add(x);
	}
		
	static void remove(int x) {
		S.remove(x);
	}
	
	static void check(int x) throws IOException{
		if(S.contains(x)) {
			bw.write(1+"\n");
		}else {			
			bw.write(0+"\n");
		}
	}
	
	static void toggle(int x) {
		if(S.contains(x)) {	// 있으면
			S.remove(x);	// 제거
			return;
		}
		S.add(x);	// 없으면 추가
	}
	
	static void all() {
		for(int i = 1; i < 21; i++) {
			S.add(i);
		}
	}
	
	static void empty() {
		S.clear();
	}

}
// 과정 https://gimbalja.tistory.com/322