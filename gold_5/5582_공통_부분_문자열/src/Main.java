import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String a, b;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        a = br.readLine();
        b = br.readLine();

        dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
