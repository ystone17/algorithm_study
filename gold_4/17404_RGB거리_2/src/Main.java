import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int r = 0, g = 1, b = 2;

    static int n, answer = Integer.MAX_VALUE;
    static int[][] costs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        costs = new int[3][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            dp = new int[3][n];
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) dp[i][0] = costs[i][0];
                else dp[i][0] = 1000 * 1000 * 10;
            }

            for (int i = 1; i < n - 1; i++) {
                dp[r][i] = Math.min(dp[g][i - 1], dp[b][i - 1]) + costs[r][i];
                dp[g][i] = Math.min(dp[b][i - 1], dp[r][i - 1]) + costs[g][i];
                dp[b][i] = Math.min(dp[r][i - 1], dp[g][i - 1]) + costs[b][i];
            }


            dp[r][n - 1] = Math.min(dp[g][n - 2], dp[b][n - 2]) + costs[r][n - 1];
            dp[g][n - 1] = Math.min(dp[b][n - 2], dp[r][n - 2]) + costs[g][n - 1];
            dp[b][n - 1] = Math.min(dp[r][n - 2], dp[g][n - 2]) + costs[b][n - 1];

            for (int i = 0; i < 3; i++) {
                if (i == firstColor) continue;
                answer = Math.min(answer, dp[i][n - 1]);
            }
        }

        System.out.println(answer);
    }
}

