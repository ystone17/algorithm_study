import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static String[] dp = new String[1001];


    //상근 SK 1, 3, 4
    //창영 CY 1, 3, 4
    public static void main(String[] args) throws IOException {
        dp[1] = "CY";
        dp[2] = "SK";
        dp[3] = "CY";
        dp[4] = "SK";

        for (int i = 5; i < dp.length; i++) {
            if (dp[i - 1].equals("CY") || dp[i - 3].equals("CY") || dp[i - 4].equals("CY")) {
                dp[i] = "SK";
                continue;
            }
            dp[i] = "CY";
        }

        n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
