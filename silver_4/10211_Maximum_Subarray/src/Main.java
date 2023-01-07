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
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[2][n];
            dp[0][0] = dp[1][0] = arr[0];
            for (int i = 1; i < n; i++) {
                dp[1][i] = Math.max(dp[1][i - 1] + arr[i], arr[i]);
                dp[0][i] = Math.max(arr[i], Math.max(dp[1][i - 1] + arr[i], dp[0][i - 1]));
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}
