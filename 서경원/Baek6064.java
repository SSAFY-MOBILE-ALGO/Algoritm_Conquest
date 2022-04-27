import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek6064 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int a = 0;
            int b = 0;
            if(M > N){
                a = M;
                b = N;
            }else{
                a = N;
                b = M;
            }

            while(a % b != 0){
                int tmp = a;
                a = b;
                b = tmp % b;
            }

            // 3   3 + 10   3 + 10 + 10   3 + 10 + 10 + 10
            // 9   9 + 12   9 + 12 + 12   9 + 12 + 12 + 12
            int sum = x;
            boolean isFind = false;
            while(sum <= (M * N) / b){      //최소공배수
                if(sum - y >= 0 && (sum - y) % N == 0){
                    sb.append(sum + "\n");
                    isFind = true;
                    break;
                }else{
                    sum += M;
                }
            }

            if(!isFind) sb.append("-1\n");
        }
        System.out.print(sb);
        br.close();
    }
}
