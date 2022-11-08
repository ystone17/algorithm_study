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
    static int[] prices, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        prices = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i + 1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
