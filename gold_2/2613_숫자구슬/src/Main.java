import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] seq, partSum, size;
    static int[][] dp;
    static List<Integer> border = new ArrayList<>();

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

        int min = f(1, m);
        sb.append(min).append("\n");

        border.add(0);
        for (int groupCount = m - 1; groupCount >= 1; groupCount--) {
            for (int inStart = 1; inStart <= n; inStart++) {
                if (dp[inStart][groupCount] == 0) continue;

                if (dp[inStart][groupCount] <= min) {
                    min = dp[inStart][groupCount];
                    border.add(inStart - 1);
                    break;
                }
            }
        }
        border.add(n);

        for (int i = 0; i < border.size() - 1; i++) {
            sb.append(border.get(i + 1) - border.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static int f(int inStart, int groupCount) {
        if (dp[inStart][groupCount] != 0) {
            return dp[inStart][groupCount];
        }

        if (groupCount == 1) {
            return dp[inStart][1] = partSum[n] - partSum[inStart - 1];
        }

        int leftSum = 0;
        int rightSum;
        int diff = Integer.MAX_VALUE;
        int max = 0;

        for (int i = inStart; i <= n - (groupCount - 1); i++) {
            leftSum += seq[i];
            rightSum = f(i + 1, groupCount - 1);

            if (diff > Math.abs(leftSum - rightSum)) {
                diff = Math.abs(leftSum - rightSum);
                max = Math.max(leftSum, rightSum);

            }

        }

        return dp[inStart][groupCount] = max;
    }
}
