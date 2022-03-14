import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] rgb = new int[3][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[j][i + 1] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[3][n + 1];
        dp[0][1] = rgb[0][1];
        dp[1][1] = rgb[1][1];
        dp[2][1] = rgb[2][1];


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = Math.min(dp[(j + 1) % 3][i - 1], dp[(j + 2) % 3][i - 1]) + rgb[j][i];
            }
        }


        System.out.println(Math.min(Math.min(dp[0][n], dp[1][n]), dp[2][n]));
    }
}
