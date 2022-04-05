import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] a, b;
    static int[][] dp;
    static int answer, temp, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];

        for (int ai = 1; ai <= a.length; ai++) {
            for (int bi = 1; bi <= b.length; bi++) {
                if (a[ai - 1] == b[bi - 1]) {
                    dp[ai][bi] = dp[ai - 1][bi - 1] + 1;
                } else {
                    dp[ai][bi] = Math.max(dp[ai - 1][bi], dp[ai][bi - 1]);
                }
            }
        }

        System.out.println(dp[a.length][b.length]);

    }
}
