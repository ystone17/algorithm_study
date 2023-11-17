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
    static int[] seq;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        int a;
        for (int i = 0; i < n; i++) {
            a = 0;
            for (int b = i; b < n; b++, a++) {
                if (a == b) {
                    dp[a][b] = 0;
                    continue;
                }

                if (seq[a] == seq[b]) {
                    dp[a][b] = dp[a + 1][b - 1];
                    continue;
                }

                dp[a][b] = Math.min(dp[a + 1][b], dp[a][b - 1]) + 1;
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
