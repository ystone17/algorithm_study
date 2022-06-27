import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, n, m;
    static int[][] dp = new int[30][30];
    //nCr = n-1Cr-1 + n-1Cr
    public static void main(String[] args) throws IOException {

        dp[0][0] = 1;

        for (int n = 1; n < 30; n++) {
            dp[n][0] = 1;
            for (int r = 1; r <= n; r++) {
                dp[n][r] = dp[n-1][r-1] + dp[n-1][r];
            }
        }

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);
    }
}
