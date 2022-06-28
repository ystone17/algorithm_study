import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = arr[0];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }

}
