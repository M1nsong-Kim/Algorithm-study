package codingtestAndAlgorithm.Day149;

import java.io.*;

public class Boj1248 {

	static int n;
	static int[] arr;
	static char[][] matrix;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		matrix = new char[n][n];
		String str = br.readLine();
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				matrix[i][j] = str.charAt(idx);	// idx 자리에 idx++ 넣어도 가능
				idx++;
			}
		}
		
//		System.out.println(Arrays.deepToString(matrix));
		DFS(0);
	}
	
	static void DFS(int depth) throws IOException {
		if(depth == n) {
			for(int val : arr) {
				bw.write(val+" ");
			}
			bw.flush();
			bw.close();
			System.exit(0);	// 프로그램 종료
		}
		
		for(int i = -10; i < 11; i++) {
			arr[depth] = i;
			if(check(depth+1)) {	// 그 다음 수가 조건에 맞으면
				DFS(depth+1);	// 재귀 호출(arr의 다음 인덱스 자리에 조건 맞는 숫자 넣기)
			}
		}
	}
	
	static boolean check(int idx) {
		for(int i = 0; i < idx; i++) {
			int sum = 0;
			for(int j = i; j < idx; j++) {
				sum += arr[j];
				if(sum > 0 && matrix[i][j] != '+') {	// 양수인데 해당 자리 기호가 +가 아니라면
					return false;
				}else if(sum < 0 && matrix[i][j] != '-') {	// 음수인데 해당 자리 기호가 -가 아니라면
					return false;
				}else if(sum == 0 && matrix[i][j] != '0'){	// 0인데 해당 자리 기호가 0이 아니라면
					return false;
				}
			}
		}
		return true;
	}

}
// 과정 https://gimbalja.tistory.com/321