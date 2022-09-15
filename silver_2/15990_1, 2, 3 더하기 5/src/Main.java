import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[][] dp = new long[100001][4];

    public static void main(String[] args) throws IOException {
        dp[1][1] = 1;

        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j != 1) dp[i][j] = (dp[i][j] + dp[i - j][1]) % 1000000009;
                if (j != 2) dp[i][j] = (dp[i][j] + dp[i - j][2]) % 1000000009;
                if (j != 3) dp[i][j] = (dp[i][j] + dp[i - j][3]) % 1000000009;
            }
        }

        long tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int a = Integer.parseInt(br.readLine());
            sb.append(((dp[a][1] + dp[a][2]) % 1000000009 + dp[a][3]) % 1000000009).append("\n");
        }

        System.out.println(sb);

    }
}
