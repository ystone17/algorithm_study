import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] matrix;
    static Matrix[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new Matrix[n][n];
        matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            dp[i][i] = new Matrix(y, x, 0);
        }

        for (int length = 2; length <= n; length++) {
            for (int to = 0; to < n - length + 1; to++) {
                int from = to + length - 1;
                dp[to][from] = new Matrix(0, 0, Integer.MAX_VALUE);
                for (int m = to; m < from; m++) {
                    int res = dp[to][m].y * dp[to][m].x * dp[m + 1][from].x + dp[to][m].total + dp[m + 1][from].total;
                    if (dp[to][from].total > res) {
                        dp[to][from] = new Matrix(dp[to][m].y, dp[m + 1][from].x, res);
                    }
                }
            }
        }

        System.out.println(dp[0][n-1].total);

    }

    static class Matrix {
        int y;
        int x;
        int total;

        public Matrix(int y, int x, int total) {
            this.y = y;
            this.x = x;
            this.total = total;
        }
    }
}
