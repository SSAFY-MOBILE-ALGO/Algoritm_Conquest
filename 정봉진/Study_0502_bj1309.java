package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Study_0502_bj1309 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[0][2] = 1;		
		for(int i = 1; i < N; i++) {
			//01
			arr[i][0] = arr[i - 1][1] + arr[i - 1][2] % 9901;
			//10
			arr[i][1] = arr[i - 1][0] + arr[i - 1][2] % 9901;
			//00
			arr[i][2] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] % 9901;			
		}
		
		int r = (arr[N-1][0] + arr[N-1][1]+ arr[N-1][2]) % 9901;
		System.out.println(r);
	}

}
