package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Study_0503_bj13023 {
	static ArrayList<Integer>[] arr;
	static boolean[] v;
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = br.readLine();
		int N = Integer.parseInt(s.split(" ")[0]);
		int M = Integer.parseInt(s.split(" ")[1]);

		arr = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}		
		result = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);

		}

		for (int i = 0; i < N; i++) {			
			v = new boolean[N];
			find(i, 0);			
			if(result == 1) break;
		}
		System.out.println(result);

	}

	static void find(int next, int len) {
		if (len >= 4 || result == 1) {
			result = 1;
			return;
		}
		v[next] = true;
		for (int i = 0; i < arr[next].size(); i++) {
			int nextTo = arr[next].get(i);
			if (!v[nextTo]) {
				v[nextTo] = true;
				find(nextTo, len + 1);
				v[nextTo]= false;
			}
		}
	}

}
