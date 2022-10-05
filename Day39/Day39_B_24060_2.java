package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day39_B_24060_2 {
	
	static int[] arr, tmp;
	static int count = 0;
	static int k;
	static int result = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		arr = new int[n];	//★
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		tmp = new int[n];	//★
		merge_sort(arr, 0, n-1);
		System.out.println(result);
	}

	public static void merge_sort(int[] arr, int start, int end) {
		if(count > k) return ;
		if(start < end) {
			int mid = (start+end)/2;
			merge_sort(arr, start, mid);
			merge_sort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;	//★ end → mid+1
		int t = 0;
		
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				tmp[t] = arr[i];
				i++;
			}else {
				tmp[t] = arr[j];
				j++;
			}
			t++;
		}
		
		while(i <= mid) {
			tmp[t++] = arr[i++];	//★ 순서 반대로 함
		}
		
		while(j <= end) {
			tmp[t++] = arr[j++];	//★ 순서 반대로 함
		}
		
		i = start; //★
		t = 0; //★
		while(i <= end) {
			count++;
			if(count == k) {
				result = tmp[t];
				break;
			}
			arr[i++]=tmp[t++];
		}
	}
}
