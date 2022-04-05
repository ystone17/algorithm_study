import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, kg;
    static int[] weight, value;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        kg = Integer.parseInt(st.nextToken());

        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new int[n + 1][kg + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i + 1] = Integer.parseInt(st.nextToken());
            value[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int w = 1; w <= kg; w++) {
            for (int i = 1; i <= n; i++) {
                if (weight[i] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - weight[i]] + value[i], dp[i - 1][w]);
                }
            }
        }

        System.out.println(dp[n][kg]);

    }
}
