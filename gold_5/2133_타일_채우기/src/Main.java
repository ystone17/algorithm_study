import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[31];

        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i < 31; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2;
            for (int j = 2; j <= i - 4; j += 2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);

    }
}
