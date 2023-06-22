import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String[] dp = new String[1001];

    public static void main(String[] args) throws IOException {
        dp[1] = "CY";
        dp[2] = "SK";
        dp[3] = "CY";
        for (int i = 4; i < dp.length; i++) {
            if (dp[i - 1].equals("CY") || dp[i - 3].equals("CY")) {
                dp[i] = "SK";
                continue;
            }

            dp[i] = "CY";
        }

        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}
