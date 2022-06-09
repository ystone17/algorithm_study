import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] a;
    static char[] b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];

        for (int aIdx = 0; aIdx < a.length; aIdx++) {
            for (int bIdx = 0; bIdx < b.length; bIdx++) {
                if (a[aIdx] == b[bIdx]) dp[aIdx + 1][bIdx + 1] = dp[aIdx][bIdx] + 1;
                else {
                    dp[aIdx + 1][bIdx + 1] = Math.max(dp[aIdx][bIdx + 1], dp[aIdx + 1][bIdx]);
                }
            }
        }



        int y = a.length;
        int x = b.length;

        while (dp[y][x] != 0) {
            if (dp[y - 1][x] == dp[y][x]) {
                y -= 1;
            } else if (dp[y][x - 1] == dp[y][x]) {
                x -= 1;
            } else {
                sb.append(b[x -1]);
                y -= 1;
                x -= 1;
            }
        }

        System.out.println(dp[a.length][b.length]);
        System.out.println(sb.reverse());
    }
}
