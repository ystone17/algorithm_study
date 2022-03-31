import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, tc;
    static int[][] sticker, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(n == 1){
                sb.append(Math.max(sticker[0][0],sticker[1][0])).append("\n");
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = sticker[0][1] + sticker[1][0];
            dp[1][1] = sticker[1][1] + sticker[0][0];

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[j][i] = dp[(j + 1) % 2][i - 1] + sticker[j][i];
                    dp[j][i] = Math.max(dp[j][i], dp[j][i - 2] + sticker[j][i]);
                    dp[j][i] = Math.max(dp[j][i], dp[(j + 1) % 2][i - 2] + sticker[j][i]);
                }
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);

    }

}
