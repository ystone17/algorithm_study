import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[] dp = new long[1_000_001];

    public static void main(String[] args) throws IOException {
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= 1_000_000; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % 1_000_000_000;
        }

        System.out.println(dp[Integer.parseInt(br.readLine())]);

    }
}
