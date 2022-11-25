import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res = 1;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[2][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][n - 1] = 1;
        dp[1][n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                dp[0][i] = dp[0][i + 1] + 1;
            } else {
                dp[0][i] = 1;
            }

            if (arr[i] >= arr[i + 1]) {
                dp[1][i] = dp[1][i + 1] + 1;
            } else {
                dp[1][i] = 1;
            }

            res = Math.max(res, dp[0][i]);
            res = Math.max(res, dp[1][i]);
        }
        System.out.println(res);
    }
}
