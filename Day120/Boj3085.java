package codingtestAndAlgorithm;

import java.io.*;

public class Boj3085 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < n; j++) {
                candies[i][j] = row.charAt(j);
            }
        }
        
        // 디버깅
        //System.out.println(Arrays.deepToString(candies));
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-1; j++) {
                // 오른쪽이랑 다르다면 (가로로 바꾸기)
                if(candies[i][j] != candies[i][j+1]) {
                    
                    // 바꾸기
                    char temp = candies[i][j];
                    candies[i][j] = candies[i][j+1];
                    candies[i][j+1] = temp;
                    
                    // 바꾼 후 확인 1. 가로
                    for(int k = 0; k < n; k++) {
                        int count = 1;
                        for(int l = 0; l < n-1; l++) {
                            //System.out.println("candies["+k+"]["+l+"] : "+candies[k][l]+", candies["+k+"]["+(l+1)+"] : "+candies[k][l+1]);
                            if(candies[k][l] == candies[k][l+1]) {
                                count++;
                            }else {
                                count = 1; // 다르다면 다시 1부터 시작
                            }
                            max = Math.max(max, count);
                        }
                    }
                        // 2. 세로
                    for(int k = 0; k < n; k++) {
                        int count = 1;
                        for(int l = 0; l < n-1; l++) {
                            if(candies[l][k] == candies[l+1][k]) {
                                count++;
                            }else {
                                count = 1; // 다르다면 다시 1부터 시작
                            }
                            max = Math.max(max, count);
                        }
                    }
                    
                    // 바꿨던 것 돌려놓기
                    temp = candies[i][j];
                    candies[i][j] = candies[i][j+1];
                    candies[i][j+1] = temp;
                }
            }
        }

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n; j++) {
                // 아래랑 다르다면 (세로로 바꾸기)
                if(candies[i][j] != candies[i+1][j]) {
                    
                    // 바꾸기
                    char temp = candies[i][j];
                    candies[i][j] = candies[i+1][j];
                    candies[i+1][j] = temp;
                    
                    // 바꾼 후 확인 1. 가로
                    for(int k = 0; k < n; k++) {
                        int count = 1;
                        for(int l = 0; l < n-1; l++) {
                            if(candies[k][l] == candies[k][l+1]) {
                                count++;
                            }else {
                                count = 1;    // 다르다면 다시 1부터 시작
                            }
                            max = Math.max(max, count);
                        }
                    }
                        // 2. 세로
                    for(int k = 0; k < n; k++) {
                        int count = 1;
                        for(int l = 0; l < n-1; l++) {
                            if(candies[l][k] == candies[l+1][k]) {
                                count++;
                            }else {
                                count = 1; // 다르다면 다시 1부터 시작
                            }
                            max = Math.max(max, count);
                        }
                    }
                    
                    // 바꿨던 것 돌려놓기
                    temp = candies[i][j];
                    candies[i][j] = candies[i+1][j];
                    candies[i+1][j] = temp;
                }
            }
        }

        System.out.println(max);
    }

}
// 과정 https://gimbalja.tistory.com/282