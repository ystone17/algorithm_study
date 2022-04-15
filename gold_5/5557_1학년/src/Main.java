import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, goal;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n - 1];
        dp = new long[n - 1][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        goal = Integer.parseInt(st.nextToken());

        dp[0][arr[0]] = 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] > 0) {
                    if (j + arr[i + 1] <= 20) dp[i + 1][j + arr[i + 1]] += dp[i][j] ;
                    if (j - arr[i + 1] >= 0) dp[i + 1][j - arr[i + 1]] += dp[i][j] ;
                }
            }
        }

        System.out.println(dp[n-2][goal]);
    }

}
