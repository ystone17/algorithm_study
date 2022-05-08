import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, reqMemory;
    static int[] memories, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        reqMemory = Integer.parseInt(st.nextToken());

        memories = new int[n];
        dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int memory = Integer.parseInt(st.nextToken());
            memories[i] = memory;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cost = Integer.parseInt(st.nextToken());

            for (int j = 10000; j >=cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + memories[i]);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i] >= reqMemory){
                System.out.println(i);
                return;
            }
        }


    }

}