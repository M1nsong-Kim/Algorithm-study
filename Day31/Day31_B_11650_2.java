package codingtestAndAlgorithm;

import java.util.*;

public class Day31_B_11650_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][]	= new int[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			//★오버라이딩★
			public int compare(int[] n1, int[] n2) {
				if(n1[0] == n2[0]) {
					return n1[1] - n2[1];
				}else {
					return n1[0] - n2[0];
				}
			}
		}); //★
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}
}