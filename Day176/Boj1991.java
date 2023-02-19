package codingtestAndAlgorithm.Day176;

import java.io.*;
import java.util.*;

public class Boj1991 {

	static int n;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int root = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			
			tree.get(root).add(new Node(left, right));
		}
		
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		
		System.out.println(sb.toString());
	}
	
	// 전위 순회
	static void preorder(int start) {
		for(Node n : tree.get(start)) {
			int left = n.left;
			int right = n.right;
			
			sb.append((char)(start+'A'));
			if(left != -19) {	// . : -19
				preorder(left);
			}
			if(right != -19) {	// . : -19
				preorder(right);
			}
		}
	}
	
	// 중위 순회
	static void inorder(int start) {
		for(Node n : tree.get(start)) {
			int left = n.left;
			int right = n.right;
			
			if(left != -19) {	// . : -19
				inorder(left);
			}
			sb.append((char)(start+'A'));
			if(right != -19) {	// . : -19
				inorder(right);
			}
		}
	}
	
	// 후위 순회
	static void postorder(int start) {
		for(Node n : tree.get(start)) {
			int left = n.left;
			int right = n.right;
			
			if(left != -19) {	// . : -19
				postorder(left);
			}
			if(right != -19) {	// . : -19
				postorder(right);
			}
			sb.append((char)(start+'A'));
		}
	}
	
	static class Node{
		int left;
		int right;
		Node(int left, int right){
			this.left = left;
			this.right = right;
		}
	}

}
// 과정 https://gimbalja.tistory.com/366