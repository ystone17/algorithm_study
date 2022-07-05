import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, r;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());

        dp = new int[n + 1][r + 1];
        dp[2][1] = 2;
        dp[3][1] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i][1] = i;
            for (int j = 2; j <= r; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % 1000000003;
            }
        }

        System.out.println(dp[n][r]);
    }
}
