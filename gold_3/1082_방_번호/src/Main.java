import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] prices;
    static String[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        prices = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        dp = new String[m + 1];

        System.out.println(solve(m, true));
    }

    public static String solve(int money, boolean isFirst) {
        if (dp[money] != null) {
            return dp[money];
        }

        String cur = "";
        String temp = "";

        for (int i = 0; i < n; i++) {
            if (money - prices[i] < 0) {
                continue;
            }

            if (i == 0 && isFirst) {
                cur = "0";
                continue;
            }

            String res = solve(money - prices[i], false);

            if (temp.length() <= res.length()) {


                cur = String.valueOf(i);
                temp = res;
            }
        }

        return dp[money] = cur + temp;
    }


}