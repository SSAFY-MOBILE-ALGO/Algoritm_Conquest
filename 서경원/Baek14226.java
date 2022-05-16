import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek14226 {

    public static int S;
    public static int[][] dp;

    public static void bfs(){
        //화면 이모티콘 개수 , 클립보드 이모티콘 개수
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(0);

        int count = 0;

        while(!queue.isEmpty()){

            int size = queue.size() / 2;

            for(int t = 0; t < size; t++){

                int monitor = queue.poll();
                int clipboard = queue.poll();

                if(monitor == S){
                    System.out.println(count);
                    return;
                }


                if(monitor > S || clipboard > S + 1000){
                    continue;
                }

                if(dp[clipboard][monitor] == -1){
                    dp[clipboard][monitor] = count;
                }else{
                    continue;
                }

                queue.add(monitor);
                queue.add(monitor);

                if(clipboard != 0){
                    queue.add(monitor + clipboard);
                    queue.add(clipboard);
                }

                if(monitor > 1) {
                    queue.add(monitor - 1);
                    queue.add(clipboard);
                }
            }

            count++;
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        dp = new int[S + 10][S + 1000];
        for(int i = 0; i < S + 10; i++){
            Arrays.fill(dp[i], -1);
        }
        bfs();

    }
}
