import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		// 인덱스에 n이 들어가야 하므로 배열의 크기는 n+1
		int[] dp = new int[n+1];	//최댓값 구할 배열
		int[] pack = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		// System.out.println(Arrays.toString(pack)); 디버깅
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < i+1; j++) {
				dp[i] = Math.max(dp[i], pack[j]+dp[i-j]);
			}
		}

		System.out.println(dp[n]);
	}

}
