package beckjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static boolean[] Visit;
    static ArrayList<Integer>[] Graph;
    static int N, M, Answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N]; // 시간초과 때문에 list[] 사용
        Visit = new boolean[N]; // 찾은 친구를 체크하는 배열

        // Arraylist 배열 초기화
        for(int i=0; i<N; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }

        // 친구찾기 시작점 0번부터 -> N-1번까지
        for(int i=0; i<N; i++){
            if(Answer == 1) break;
            DFS(i, 1);
        }

        System.out.println(Answer);
    }

    static void DFS(int start, int depth){
        if(depth >= 5){ // 친구가 5명째일 때,
            Answer = 1;
            return;
        }

        Visit[start] = true;
        for(int i : Graph[start]){
            if(!Visit[i]){
                DFS(i, depth+1);
            }
        }
        Visit[start] = false;
    }



}
