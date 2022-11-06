package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day71B12871 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();
        int result = 0;
        
        
        if(f(s).contains(f(t)) || f(t).contains(f(s))) {
            result = 1;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    
    public static String f(String str) {
        while(true) {
            str = str.concat(str);	//str에 str 붙이기
            if(str.length() >= 50) {	//str의 길이가 50이거나 넘으면
                break;					//반복문 종료
            }
        }
        return str;
    }

}
// 과정 https://gimbalja.tistory.com/178