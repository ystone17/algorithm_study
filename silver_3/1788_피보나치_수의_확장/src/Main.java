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
    static long[] dp = new long[2000001];

    public static void main(String[] args) throws IOException {
        dp[1000000] = 0;
        dp[1000001] = 1;

        for (int i = 1000002; i <= 2000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }

        for (int i = 999999; i >= 0; i--) {
            dp[i] = (dp[i + 2] - dp[i + 1]) % 1000000000;
        }

        n = Integer.parseInt(br.readLine()) + 1000000;
        if (dp[n] > 0) {
            System.out.println(1);
        } else if (dp[n] < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
        System.out.println(Math.abs(dp[n]));
    }

}
