package beckjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Imoticon_14226 {

    static int S;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        DP = new int[1003];

        for(int i=1; i<=1002; i++){ // 1개복사 1개씩 붙여넣기
            DP[i] = i;
        }

        for(int i=2; i<=S/2+1; i++){
            for(int j=2; j*i<=1002; j++){
                DP[i * j] = Math.min(DP[i * j], DP[i] + j); // 약수인 경우 복사하고 붙여넣기
                DP[i * j -1] = Math.min(DP[i * j -1], DP[i * j] + 1); // 윗자리에서 하나 빼기
            }
        }

        System.out.println(DP[S]);
    }
}
