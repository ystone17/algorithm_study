import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] seq, partSum, size;
    static int[][] dp;
    static List<Integer> border = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[] a = {62, 9, 76, 30, 98, 74, 50, 56, 40, 1, 97, 97, 7, 84, 36, 35, 68, 29, 74, 41, 48, 10, 75, 31, 95, 59, 43, 48, 100, 47, 85, 3, 45, 28, 90, 80, 91, 25, 14, 41, 51, 13, 60, 57, 80, 82, 1, 74, 48, 48, 30, 68, 10, 9, 95, 54, 71, 22, 12, 100, 10, 76, 67, 42, 34, 44, 85, 77, 7, 44, 54, 4, 72, 60, 85, 83, 59, 54, 9, 91, 36, 67, 53, 13, 9, 6, 22, 70, 35, 66, 26, 52, 61, 71, 6, 67, 34, 46, 13, 10};
        int[] b = {6, 7, 6, 7, 6, 5, 7, 5, 6, 5, 5, 4, 5, 2, 4, 4, 5, 3, 3, 5};

        int idx = 0;
        for (int i : b) {
            int sum = 0;
            for (int i1 = 0; i1 < i; i1++) {
                sum += a[idx++];
            }
            System.out.printf("%d개 %d\n", i, sum);
        }


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
//        Random random = new Random();
//
//        for (int i = 0; i < 100; i++) {
//            seq[i + 1] = random.nextInt(100) + 1;
//            partSum[i + 1] = partSum[i] + seq[i + 1];
//        }

        int min = f(1, m);
        sb.append(min).append("\n");

        border.add(1);
        for (int groupCount = m - 1; groupCount >= 1; groupCount--) {
            for (int inStart = n; inStart >= 1; inStart--) {
                if (dp[inStart][groupCount] == 0) continue;

                if (dp[inStart][groupCount] <= min && partSum[inStart - 1] - partSum[border.get(border.size() - 1) - 1] <= min) {
                    min = dp[inStart][groupCount];
                    border.add(inStart);
                    break;
                }
            }
        }
        border.add(n + 1);

        for (int i = 0; i < border.size() - 1; i++) {
            sb.append(border.get(i + 1) - border.get(i)).append(" ");
        }

        for (int i = 1; i < seq.length; i++) {
            System.out.printf("%d ",seq[i]);
        }
        System.out.println();
        System.out.println(sb);
        System.out.println(border);
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
