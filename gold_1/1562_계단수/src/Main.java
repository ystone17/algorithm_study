import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[][][] dp = new long[100][10][10];
    static final int max = 1000000000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp[10][9][0] = 1;
        dp[10][0][9] = 1;

        for (int len = 11; len <= n; len++) {
            for (int start = 0; start < 10; start++) {
                for (int end = 0; end < 10; end++) {
                    if (start - 1 >= 0) {
                        dp[len][start][end] += dp[len - 1][start - 1][end];
                        dp[len][start][end] %= max;
                    }

                    if (start + 1 < 10) {
                        dp[len][start][end] += dp[len - 1][start + 1][end];
                        dp[len][start][end] %= max;
                    }

                    if (end - 1 >= 0) {
                        dp[len][start][end] += dp[len - 1][start][end - 1];
                        dp[len][start][end] %= max;
                    }

                    if (end + 1 < 10) {
                        dp[len][start][end] += dp[len - 1][start][end + 1];
                        dp[len][start][end] %= max;
                    }
                }
            }
        }

        long res = 0;
        for (int len = 10; len <= n; len++) {
            for (int start = 1; start < 10; start++) {
                for (int end = 0; end < 10; end++) {
                    res += dp[len][start][end];
                    res %= max;
                }
            }
        }

        System.out.println(res);
    }
}
