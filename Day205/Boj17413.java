package codingtestAndAlgorithm.Day205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj17413 {
	
	static char[] str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   
	    str = br.readLine().toCharArray();	// char 배열
	    
	    int idx = 0;
	    while(idx < str.length) {
	    	if(str[idx] == ' ') {	// 공백 위치는 그대로
	    		idx++;
	    		continue;
	    	}
	    	
	    	if(str[idx] == '<') {	// 괄호 안은 그대로
	    		while(str[idx] != '>') {
	    			idx++;
	    		}
	    		idx++;	// > 다음으로 가기 위함
	    		continue;
	    	}
	    	
	    	// 거꾸로 만들어야 할 구간의 인덱스값 구하기
	    	int first = idx;
	    	while(idx != str.length && str[idx] != ' ' && str[idx] != '<') {
	    		idx++;
	    	}
	    	reverse(first, idx-1);	// 조건에 부합하면 ++을 해줬으므로 -1 필요
	    }
	    
	    bw.write(String.valueOf(str));	// string 타입으로 변환(null도 처리)
	    bw.flush();
	    bw.close();
	    br.close();
	}
	  
	static void reverse(int from, int to) {
		while(from < to) {
			char temp = str[from];
			str[from] = str[to];
			str[to] = temp;
			from++;
			to--;
		}
	}
}
// 복습 과정 https://gimbalja.tistory.com/400