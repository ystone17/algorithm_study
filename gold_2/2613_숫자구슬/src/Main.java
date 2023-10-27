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
    static int[] seq, partSum, endIdxSeq;
    static int[][] dpMax, dpEndIdx;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n + 1];
        partSum = new int[n + 1];
        endIdxSeq = new int[m + 1];
        dpMax = new int[n + 1][m + 1];
        dpEndIdx = new int[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
            partSum[i + 1] = partSum[i] + seq[i + 1];
        }

        int[] f = f(1, m);
        endIdxSeq[m] = f[1];
        endIdxSeq[1] = n;

        sb.append(endIdxSeq[endIdxSeq.length - 1]).append(" ");
        for (int i = endIdxSeq.length - 2; i >= 1; i--) {
            sb.append(endIdxSeq[i] - endIdxSeq[i + 1]).append(" ");
        }

        System.out.println(f[0]);
        System.out.println(sb);
    }

    static int[] f(int end, int k) {
        if (dpMax[end][k] != 0) {
            return new int[]{dpMax[end][k], dpEndIdx[end][k]};
        }

        if (k == 1) {
            return new int[]{dpMax[end][1] = partSum[n] - partSum[end - 1], n};
        }

        int leftSum = 0;
        int rightSum;
        int curEndIdx = 0;
        int nextEndIdx = 0;
        int diff = Integer.MAX_VALUE;
        int max = 0;

        for (int i = end; i <= n - k + 1; i++) {
            leftSum += seq[i];
            int[] f = f(i + 1, k - 1);
            rightSum = f[0];

            if (diff > Math.abs(leftSum - rightSum)) {
                diff = Math.abs(leftSum - rightSum);
                max = Math.max(leftSum, rightSum);
                curEndIdx = i;
                nextEndIdx = f[1];
            }

        }

        endIdxSeq[k - 1] = nextEndIdx;
        dpEndIdx[end][k] = curEndIdx;
        dpMax[end][k] = max;
        return new int[]{max, curEndIdx};
    }

}
