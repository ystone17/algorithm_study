import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int n;
    static long[] dp = new long[5000 + 1];

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        dp[0] = 1L;
        dp[2] = 1L;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
                dp[i * 2] %= 1000000007L;
            }
        }

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
