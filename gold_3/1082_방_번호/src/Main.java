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

        System.out.println(solve(m));
    }

    public static String solve(int money) {
        if (dp[money] != null) {
            return dp[money];
        }

        String cur = "";
        String temp = "";

        for (int i = 0; i < n; i++) {
            if (money - prices[i] < 0) {
                continue;
            }

            String res = solve(money - prices[i]);

            if (temp.length() <= res.length() && !(String.valueOf(i).equals("0") && !res.equals(""))) {
                cur = String.valueOf(i);
                temp = res;
            }
        }

        return dp[money] = cur + temp;
    }


}