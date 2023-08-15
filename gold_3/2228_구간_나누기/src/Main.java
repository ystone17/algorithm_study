import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] partSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        partSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            partSum[i] = partSum[i - 1] + Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1][m + 1];

        for (int nIdx = 1; nIdx <= n; nIdx++) {
            for (int mIdx = 1; mIdx <= m; mIdx++) {
                if (mIdx > Math.ceil((double) nIdx / 2)) {
                    continue;
                }

                dp[nIdx][mIdx] = dp[nIdx - 1][mIdx];

                for (int kIdx = 1; kIdx <= nIdx; kIdx++) {
                    if (kIdx >= 2) {
                        dp[nIdx][mIdx] = Math.max(dp[nIdx][mIdx], dp[kIdx - 2][mIdx - 1] + partSum[nIdx] - partSum[kIdx - 1]);
                        continue;
                    }

                    if(kIdx == 1 && mIdx == 1) {
                        dp[nIdx][mIdx] = Math.max(dp[nIdx][mIdx], partSum[nIdx]);
                    }
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
