import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc, n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {

            n = Integer.parseInt(br.readLine());
            sum = new int[n + 1];
            dp = new int[n + 1][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                int size = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + size;
            }


            for (int k = 2; k <= n; k++) {
                for (int from = 1; from < n && from + k - 1 <= n; from++) {
                    int to = from + k - 1;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int m = from; m < to; m++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][m] + dp[m + 1][to]);
                    }
                    dp[from][to] += sum[to] - sum[from - 1];
                }
            }
            sb.append(dp[1][n]).append("\n");
        }
        System.out.println(sb);
    }
}
