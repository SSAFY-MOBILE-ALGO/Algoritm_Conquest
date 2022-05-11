package beckjoon.dp;

import java.util.Scanner;

public class Zoo_1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];

        DP[0] = 1;
        DP[1] = 3;
        for(int i=2; i<=N; i++){
            DP[i] = (DP[i-1]*2 + DP[i-2]) % 9901;
        }

        System.out.println(DP[N]);
    }
}
