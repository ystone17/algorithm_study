import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] seq, dp;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new int[n];
        num = new int[2][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = seq[0];
        int size = 1;
        num[0][0] = size;
        for (int i = 1; i < n; i++) {
            if (seq[i] > dp[size - 1]) {
                dp[size++] = seq[i];
                num[0][i] = size;
            } else {
                int idx = upper(seq[i], size, dp);
                dp[idx] = seq[i];
                num[0][i] = idx + 1;
            }

        }

        dp = new int[n];
        dp[0] = seq[n - 1];
        size = 1;
        num[1][n - 1] = size;
        for (int i = n - 2; i >= 0; i--) {
            if (seq[i] > dp[size - 1]) {
                dp[size++] = seq[i];
                num[1][i] = size;
            } else {
                int idx = upper(seq[i], size, dp);
                dp[idx] = seq[i];
                num[1][i] = idx + 1;
            }

        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, num[0][i] + num[1][i] - 1);
        }
        System.out.println(res);
    }

    static int upper(int k, int size, int[] dp) {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
