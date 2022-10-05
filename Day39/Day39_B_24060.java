package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Day39_B_24060 {
	
	static int[] arr, tmp;
	static int count = 0;
	static int result = -1;	//count가 k보다 작으면 -1 출력하기 위해 초기화
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		tmp = new int[N];
		merge_sort(arr, 0, N - 1);	//인덱스 0부터 n-1까지 = 크기가 n인 배열
		System.out.println(result);
		
	}
	
	public static void merge_sort(int[] A, int start, int end) {
		if (count > K) return ;
		if (start < end) {
			int mid = (start + end) / 2;	//정렬 나눌 중앙값
			merge_sort(A, start, mid);		//처음~중앙값 정렬1
			merge_sort(A, mid + 1, end);	//중앙값+1~끝 정렬2
			merge(A, start, mid, end);		//정렬 후 병합
		}
	}
	
	public static void merge(int[] A, int start, int mid, int end) {
		int i = start;	//정렬1 시작 인덱스
		int j = mid + 1;	//정렬2 시작 인덱스
		int t = 0;		//0부터 시작
		
		while (i <= mid && j <= end) {	//정렬1, 2가 각각 인덱스 값 안에서 돌 때
			if(arr[i] <= arr[j]) {	//정렬2의 첫번째값이 크면
				tmp[t] = arr[i];	//저장하는 정렬 tmp에 정렬1값을 넣는다(더 작은 수)
				i++;				//정렬1의 다음 값으로
			}else {					//정렬1의 첫번째값이 크면
				tmp[t] = arr[j];	//저장하는 정렬 tmp에 정렬2값을 넣는다(더 작은 수)
				j++;				//정렬2의 다음 값으로
			}
			t++;					//저장하는 정렬 tmp의 인덱스값을 1씩 늘린다(옆자리 반복해서 구하기)
		}
		
		while (i <= mid) 	//정렬1 처음부터 끝까지
			tmp[t++] = arr[i++];

		while (j <= end) 	//정렬2 처음부터 끝까지
			tmp[t++] = arr[j++];
		

		i = start;
		t = 0;
		while (i <= end) {	//처음부터 끝까지 정렬 반복
			count++;	//저장할 때마다 1씩 늘어난다
			if (count == K) {	//count가 k와 같다면
				result = tmp[t];	//result값은 k번째에 저장된 값을 불러온다
				break;
			} 
			arr[i++] = tmp[t++];
		}
	}
	
}