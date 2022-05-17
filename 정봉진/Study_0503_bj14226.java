package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Study_0503_bj14226 {	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		boolean[][] v = new boolean[1001][1001];
		Queue<Emoticon> q = new LinkedList<Emoticon>();
		
		q.offer(new Emoticon(1, 0, 0));		
		v[1][0] =  true;
		
		while(!q.isEmpty()) {
			Emoticon e = q.poll();
			if(e.total == N) {
				result = e.time;
				break;
			}
			
			//복사
			q.offer(new Emoticon(e.total, e.total, e.time + 1));
			
			//붙여넣기
			if(e.clipboard > 0 && e.clipboard + e.total <= N && !v[e.clipboard + e.total][e.clipboard]) {
				v[e.clipboard + e.total][e.clipboard] = true;
				q.offer(new Emoticon(e.clipboard + e.total, e.clipboard, e.time + 1));
			}
			//삭제
			if(e.total > 0 && !v[e.total - 1][e.clipboard]) {
				v[e.total - 1][e.clipboard] = true;
				q.offer(new Emoticon(e.total - 1, e.clipboard, e.time + 1));
			}
		}	
		System.out.println(result);
		

	}

}
class Emoticon{
	int total;	
	int clipboard;	
	int time;
	public Emoticon(int total, int clipboard, int time) {
		super();
		this.total = total;
		this.clipboard = clipboard;
		this.time = time;
	}
}













