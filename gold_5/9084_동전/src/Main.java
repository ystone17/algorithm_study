import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int[] dp;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int coinNum = Integer.parseInt(br.readLine());
            coins = new int[coinNum];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < coinNum; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            dp = new int[target + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= target; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}
