package beckjoon.dp;

import java.util.Scanner;

public class Tile_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];

        DP[1] = 0;
        DP[2] = 3;
        // DP[3] = 0;
        // DP[4] = 9;
        // DP[6] = 24; // 점화식 찾기
        for (int i = 4; i <= N; i += 2) {
            DP[i] = DP[i - 2] * DP[2];
            for (int j = i - 4; j >= 0; j -= 2) { DP[i] += DP[j] * 2; }
        }

        System.out.print(DP[N]);
    }
}
