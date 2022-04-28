package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Calendar_6064 {
    static int T, M, N, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.valueOf(br.readLine());

        test:for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken())-1;
            Y = Integer.parseInt(st.nextToken())-1;

            for(int x=X; x<N*M; x+=M){
                if(x % N == Y){
                    System.out.println(x+1); continue test;
                }
            }
            System.out.println(-1);
        }
    }

}
