import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[][] dp = new long[64 + 1][11];

    public static void main(String[] args) throws IOException {
        Arrays.fill(dp[1], 1);
        dp[1][10] = 10;

        for (int tc = 2; tc <= 64; tc++) {
            for (int number = 0; number < 10; number++) {
                long total = 0;
                for (int i = number; i < dp[tc - 1].length - 1; i++) {
                    total += dp[tc - 1][i];
                }
                dp[tc][number] = total;
            }

            for (int i = 0; i < dp[tc].length - 1; i++) {
                dp[tc][10] += dp[tc][i];
            }
        }

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][10]).append("\n");
        }

        System.out.println(sb);
    }
}
