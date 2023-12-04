import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s;
    static char[] seq;
    static boolean[][] palindrome;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        seq = new char[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            seq[i + 1] = s.charAt(i);
        }

        palindrome = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            palindrome[i][i] = true;
            if (i < s.length()) {
                palindrome[i][i + 1] = seq[i] == seq[i + 1];
            }
            if (i < s.length() - 1) {
                palindrome[i][i + 2] = seq[i] == seq[i + 2];
            }
        }

        for (int left = s.length(); left > 0; left--) {
            for (int right = left + 3; right <= s.length(); right++) {
                if (seq[left] != seq[right]) {
                    continue;
                }

                palindrome[left][right] = (palindrome[left + 1][right - 1]);
            }
        }


        dp = new int[s.length() + 1];

        for (int right = 1; right <= s.length(); right++) {
            dp[right] = 100_000_000;
            for (int left = 1; left <= right; left++) {
                if (palindrome[left][right]) {
                    dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                }
            }
        }

        System.out.print(dp[s.length()]);
    }
}
