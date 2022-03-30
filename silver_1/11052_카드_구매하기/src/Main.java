import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        cost = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i];
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + cost[i - j]);
            }
        }

        System.out.println(dp[n]);


    }
}
