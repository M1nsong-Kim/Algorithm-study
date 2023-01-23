package codingtestAndAlgorithm.Day150;

import java.io.*;
import java.util.*;

public class Boj11723 {

	// 삭제할 때 인덱스가 아닌 값으로 인식하기 위해 String list
	static ArrayList<String> S = new ArrayList<>();
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
				add(st.nextToken());
				break;
			case "remove":
				remove(st.nextToken());
				break;
			case "check":
				check(st.nextToken());
				break;
			case "toggle":
				toggle(st.nextToken());
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
	
	static void add(String x) {
		if(S.contains(x)) {	// S에 x가 있으면
			return;
		}
		S.add(x);
	}
		
	static void remove(String x) {
		if(!S.contains(x)) {	// S에 x가 없으면
			return;
		}
		S.remove(x);
	}
	
	static void check(String x) throws IOException{
		if(S.contains(x)) {
			bw.write(1+"\n");
		}else {			
			bw.write(0+"\n");
		}
	}
	
	static void toggle(String x) {
		if(S.contains(x)) {	// 있으면
			S.remove(x);	// 제거
			return;
		}
		S.add(x);	// 없으면 추가
	}
	
	static void all() {
		empty();	// 비우고
		for(int i = 1; i < 21; i++) {
			S.add(i+"");
		}
	}
	
	static void empty() {
		for(int i = 0; i < S.size(); i++) {
			S.remove(i+"");
		}
	}

}
