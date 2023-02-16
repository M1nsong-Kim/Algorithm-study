package codingtestAndAlgorithm.Day173;

import java.io.*;
import java.util.*;

public class Boj14226 {

	static int s;
	static boolean[][] visited = new boolean[1001][1001];	//[클립보드][화면]

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());

		bfs();
	}

	static void bfs() {
		Queue<Emoticon> q = new LinkedList<>();
		q.add(new Emoticon(0, 1, 0));
		visited[0][1] = true;	// 클립보드0 모니터1 방문처리

		while(!q.isEmpty()) {
			Emoticon now = q.poll();
			
			if(now.screen == s) {
				System.out.println(now.time);
				return;
			}
			
			// 화면의 이모티콘을 클립보드에 저장
			q.add(new Emoticon(now.screen, now.screen, now.time+1));
			
			// 클립보드의 이모티콘을 화면에 붙여넣기
				// 현재 클립보드에 무언가 저장되어 있고 & 클립보드를 붙여넣기했을 때 원하는 개수를 넘지 않으며 & 아직 방문하지 않음
			if(now.clipboard != 0 && now.screen + now.clipboard < s+1 && !visited[now.clipboard][now.screen+now.clipboard]) {
				q.add(new Emoticon(now.clipboard, now.screen+now.clipboard, now.time+1));
				visited[now.clipboard][now.screen+now.clipboard] = true;	// 방문 처리
			}
			
			// 화면의 이모티콘 중 1개 지우기
				// (조건: s >= 2) s가 될 수 있는 범위이고 && 아직 방문하지 않음
			if(now.screen-1 > 1 && !visited[now.clipboard][now.screen-1]) {
				q.add(new Emoticon(now.clipboard, now.screen-1, now.time+1));
				visited[now.clipboard][now.screen-1] = true;
			}
		}
	}
	
}

class Emoticon{
	int clipboard = 0;
	int screen = 0;
	int time = 0;
	
	Emoticon(int clipboard, int screen, int time){
		this.clipboard = clipboard;
		this.screen = screen;
		this.time = time;
	}
}
// 과정 https://gimbalja.tistory.com/361