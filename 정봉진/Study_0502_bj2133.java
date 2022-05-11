package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Study0502_bj2133 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		int arr[] = new int[N + 1];
		
		arr[0] = 1;		
		arr[2] = 3;
		
		for(int i = 4; i <= N; i += 2) {
			arr[i] = 3 * arr[i-2];
			for(int j = 0; j <= i - 4; j += 2) {
				arr[i] += 2 * arr[j];
			}
		}
		System.out.println(arr[N]);		
	}
}
