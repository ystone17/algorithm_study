import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, maxTrain, answer;
    static int[] arr, partSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        partSum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            partSum[i] = partSum[i - 1] + arr[i];
        }

        maxTrain = Integer.parseInt(br.readLine());

        dp = new int[4][n + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = maxTrain * i; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - maxTrain] + (partSum[j] - partSum[j - maxTrain]));
            }
        }

        System.out.println(dp[3][n]);

    }

}
