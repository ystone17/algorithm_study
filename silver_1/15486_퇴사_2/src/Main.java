import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] spendTimes, costs, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        spendTimes = new int[n];
        costs = new int[n];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            spendTimes[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        if (spendTimes[n - 1] == 1) {
            dp[n - 1] = costs[n - 1];
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (i + spendTimes[i] <= n) {
                dp[i] = Math.max(dp[i], dp[i + spendTimes[i]] + costs[i]);
            }
        }

        System.out.println(dp[0]);
    }
}
