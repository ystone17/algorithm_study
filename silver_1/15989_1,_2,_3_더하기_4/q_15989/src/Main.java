import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int tc, n;
    static int[][] dp = new int[10001][4];

    public static void main(String[] args) throws IOException {
        initDp();

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }
        System.out.println(sb);
    }

    private static void initDp() {
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][1] = dp[i - 1][1];

            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];

            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
    }

}
