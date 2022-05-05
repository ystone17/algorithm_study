import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] seq;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][n + 1];

        for (int k = 1; k <= n; k++) {
            int i = k;
            int j = k;
            dp[i][j] = 1;

            while (--i > 0 && ++j <= n) {
                if (seq[i] != seq[j]) {
                    break;
                }
                dp[i][j] = 1;
            }
        }

        for (int k = 1; k < n; k++) {
            int i = k;
            int j = k + 1;
            if (seq[i] != seq[j]) {
                continue;
            }
            dp[i][j] = 1;

            while (--i > 0 && ++j <= n) {
                if (seq[i] != seq[j]) {
                    break;
                }
                dp[i][j] = 1;
            }
        }

        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(dp[i][j]).append("\n");
        }

        System.out.println(sb);
    }

}
