import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 30; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if (j + 1 <= 30) dp[i][j] += dp[i - 1][j + 1];
                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(sb);
                return;
            }

            sb.append(dp[n][0]).append("\n");
        }

    }
}
