import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14500 {

    public static int N;
    public static int M;
    public static int[][] arr;
    // 1 노란색, 2~3 파란색, 4~7 보라색, 8~15 초록색, 16 ~ 23 주황색
    public static int[][] dRow = {{0, 1, 0, 1},
            {0, 0, 0, 0}, {0, 1, 2, 3},
            {0, 0, 0, 1}, {-1, 0, 1, 0}, {-1, 0, 0, 0}, {0, -1, 0, 1},
            {-1, 0, 0, 1}, {1, 1, 0, 0}, {-1, 0, 0, 1}, {0, 0, -1, -1}, {1, 0, 0, -1}, {0, 0, 1, 1}, {1, 0, 0, -1}, {-1, -1, 0, 0},
            {-2, -1, 0, 0}, {1, 0, 0, 0}, {0, 0, 1, 2}, {0, 0, 0, -1}, {0, 0, -1, -2}, {0, 0, 0, 1}, {2, 1, 0, 0}, {-1, 0, 0, 0}
    };
    public static int[][] dCol = {{0, 0, 1, 1},
            {0, 1, 2, 3}, {0, 0, 0, 0},
            {-1, 0, 1, 0}, {0, 0, 0, 1}, {0, -1, 0, 1}, {-1, 0, 0, 0},
            {0, 0, 1, 1}, {-1, 0, 0, 1}, {-1, -1, 0, 0}, {-1, 0, 0, 1}, {-1, -1, 0, 0}, {-1, 0, 0, 1}, {0, 0, 1, 1}, {-1, 0, 0, 1},
            {0, 0, 0, 1}, {0, 0, 1, 2}, {-1, 0, 0, 0}, {-2, -1, 0, 0}, {-1, 0, 0, 0}, {-2, -1, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 2}
    };

    public static boolean isWall(int row, int col){
        if(row >= 0 && row < N && col >= 0 && col < M){
            return true;
        }
        return false;
    }

    public static int solve(int row, int col){
        int max = 0;

        for(int i = 0; i < 23; i++){
            int total = 0;
            for(int j = 0; j < 4; j++){
                int dx = row + dRow[i][j];
                int dy = col + dCol[i][j];

                if(!isWall(dx, dy)) break;

                total += arr[dx][dy];
            }

            max = Math.max(max, total);
        }


        return max;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                max = Math.max(max, solve(i, j));
            }
        }

        System.out.println(max);
    }
}
