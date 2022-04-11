import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] dp = new int[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dp[0], 1);

        for (int nIdx = 1; nIdx <= 200; nIdx++) {
            for (int kIdx = 1; kIdx <= 200; kIdx++) {
                dp[nIdx][kIdx] = (dp[nIdx - 1][kIdx] + dp[nIdx][kIdx - 1]) % 1000000000;
            }
        }

        System.out.println(dp[n][k]);

    }
}
