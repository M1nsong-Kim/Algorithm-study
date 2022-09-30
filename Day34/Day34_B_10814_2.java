package codingtestAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day34_B_10814_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Person arr[] = new Person[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	//br은 한 줄씩만 인식해서
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Person(age, name);
		}
		
		Arrays.sort(arr, new Comparator<Person>() {
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}

}

class Person{
	int age;
	String name;
	
	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String toString() {
		return age + " " + name + "\n";
	}
}