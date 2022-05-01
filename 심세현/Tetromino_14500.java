package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {

    static int N, M, MAX = -1;
    static int[][] PAPER;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PAPER = new int[N][M];
        VISITED = new boolean[N][M];
        // 종이에 값 채워넣기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){ PAPER[i][j] = Integer.parseInt(st.nextToken()); }
        }
        // 0,0 부터 시작
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 4방 탐색
                VISITED[i][j] = true;
                solveFir(i, j,1, 0);
                VISITED[i][j] = false;
                // 3방 탐색
                for(int start=0; start<4; start++){
                    int sum = PAPER[i][j];
                    int cnt = 0;

                    for(int k=start; k<start+3; k++){
                        int newCol = i + dc[k % 4];
                        int newRow = j + dr[k % 4];

                        if(checkWall(newCol, newRow)){
                            cnt++;
                            sum += PAPER[newCol][newRow];
                        }
                    }
                    if(cnt == 3){
                        if(sum > MAX) MAX = sum;
                    }
                }
            }
        }

        System.out.println(MAX);
    }
    // 상하좌우 4방 탐색
    static int[] dc = { -1, 1, 0, 0 };
    static int[] dr = { 0, 0, -1, 1};

    static void solveFir(int col, int row, int depth, int sum){
        sum += PAPER[col][row];
        // 4개를 채웠다면 return
        if(depth == 4){
            if(sum > MAX) MAX = sum;
            return;
        }
        // 4방 탐색
        for(int i=0; i<4; i++){
            int newCol = col + dc[i];
            int newRow = row + dr[i];

            if(checkWall(newCol, newRow) && !VISITED[newCol][newRow]){ // 벽체크, 방문체크
                VISITED[newCol][newRow] = true;
                solveFir(newCol, newRow, depth+1, sum);
                VISITED[newCol][newRow] = false;
            }
        }
    }

    // 벽체크
    static boolean checkWall(int newCol, int newRow) {
        if(newCol < 0 || newCol >= N || newRow < 0 || newRow >= M){
            return false;
        }
        return true;
    }

}
