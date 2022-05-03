package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Study_0501_bj6064 {
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int T = 0; T < tc ; T++) 
		{
			String input = br.readLine();
			int m = Integer.parseInt(input.split(" ")[0]);
			int n = Integer.parseInt(input.split(" ")[1]);
			int x = Integer.parseInt(input.split(" ")[2]);
			int y = Integer.parseInt(input.split(" ")[3]);
			
			
			int mm = 0;
			int min = Math.min(m, n);
			
			for(int i = 1; i <= min; i++) {
				if(m % i == 0 && n % i == 0) {
					mm = i;					
				}
			}			
			
			int count = x;
			int a = 0;			
			while(true) {
				
				if(count >= m*n / mm) {
					System.out.println(-1);
					break;
				}
				
				a = (count-1) % n + 1;
				System.out.println(count+" "+ count % m +" "+ a);
				if(a == y) {
					System.out.println(count);
					break;
				}
				count += m;
			}
		}
	}
}
