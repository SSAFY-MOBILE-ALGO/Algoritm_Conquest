import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek13023 {

    public static int N;
    public static ArrayList<Integer>[] arr;
    public static int answer;
    public static boolean[] visited;

    public static void dfs(int num, int cur){
        if(cur == 4){
            answer = 1;
            return;
        }

        visited[num] = true;

        for(int next : arr[num]){
            if(visited[next]) continue;
            dfs(next, cur + 1);
        }

        visited[num] = false;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        visited = new boolean[N + 1];
        for(int i = 0; i < N; i++){
            dfs(i, 0);
            if(answer == 1) break;
        }

        System.out.println(answer);
        br.close();

    }
}
