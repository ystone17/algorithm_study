import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] seq, partSum, size;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n + 1];
        partSum = new int[n + 1];
        size = new int[m + 1];
        dp = new int[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
            partSum[i + 1] = partSum[i] + seq[i + 1];
        }

        int f = f(1, m);
        sb.append(f).append("\n");

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + seq[i] <= f && n - (i - 1) >= m) {
                sum += seq[i];
                count++;
                continue;
            }

            sb.append(count).append(" ");
            sum = seq[i];
            count = 1;
            m--;
        }

        sb.append(count);

        System.out.println(sb);
    }

    static int f(int inStart, int k) {
        if (dp[inStart][k] != 0) {
            return dp[inStart][k];
        }

        if (k == 1) {
            return dp[inStart][1] = partSum[n] - partSum[inStart - 1];
        }

        int leftSum = 0;
        int rightSum;
        int diff = Integer.MAX_VALUE;
        int max = 0;

        for (int i = inStart; i <= n - k + 1; i++) {
            leftSum += seq[i];
            rightSum = f(i + 1, k - 1);

            if (diff > Math.abs(leftSum - rightSum)) {
                diff = Math.abs(leftSum - rightSum);
                max = Math.max(leftSum, rightSum);

            }

        }

        return dp[inStart][k] = max;
    }
}
