import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int min;
    static String s;
    static char[] seq;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        seq = s.toCharArray();
        dp = new int[s.length()][s.length()];

        for (int left = s.length() - 1; left >= 0; left--) {
            dp[left][left] = 1;
            for (int right = left + 1; right < s.length(); right++) {
                if (isOk(left, right)) {
                    dp[left][right] = 1;
                    continue;
                }

                min = 100_000_000;
                for (int i = 1; i <= right - left; i++) {
                    min = Math.min(min, dp[left][left + i - 1] + dp[left + i][right]);
                }
                dp[left][right] = min;
            }
        }

        System.out.print(dp[0][s.length() - 1]);
    }

    static boolean isOk(int left, int right) {
        while (left < right) {
            if (seq[left] != seq[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
