import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] dp = new int[1001];

    //sk == 0
    //cy == 1

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 0;

        for (int i = 5; i <= 1000; i++) {
            int res = 0;
            res = Math.max(res, dp[i - 1]);
            res = Math.max(res, dp[i - 3]);
            res = Math.max(res, dp[i - 4]);

            if (res == 1) dp[i] = 0;
            else dp[i] = 1;
        }
        if (dp[n] == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
