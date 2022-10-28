package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day62_B_10820_Fail {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
        //br.readLine()은 어차피 줄로 구분해서 StringTokenizer로 구분이 안 됨

        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            // 소문자 대문자 숫자 공백
            int lower = 0;
            int upper = 0;
            int number = 0;
            int blank = 0;
            
            for(int i = 0; i < str.length(); i++) {
                if('a'<=str.charAt(i) && str.charAt(i)<='z') {    //소문자
                    lower++;
                } else if('A'<=str.charAt(i) && str.charAt(i)<='Z') { //대문자
                    upper++;
                } else if('0'<=str.charAt(i) && str.charAt(i)<='9') {    //숫자
                    number++;
                } else if(str.charAt(i) == ' ') {    //공백
                    blank++;
                }
            }
            
            System.out.print(lower+" "+upper+" "+number+" "+blank+"\n");
        }

    }

}