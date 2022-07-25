import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] investments;
    static int[][] dp, path;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        investments = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        path = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= m; j++) {
                int investment = Integer.parseInt(st.nextToken());
                investments[money][j] = investment;
            }
        }


        for (int idx = 1; idx <= m; idx++) {
            for (int maxMoney = 1; maxMoney <= n; maxMoney++) {
                for (int money = 0; money <= maxMoney; money++) {
                    int temp = dp[maxMoney - money][idx - 1] + investments[money][idx];
                    if (dp[maxMoney][idx] < temp) {
                        dp[maxMoney][idx] = temp;
                        path[maxMoney][idx] = money;
                    }
                }
            }
        }


        int money = n;
        Stack<Integer> s = new Stack<>();
        for (int i = m; i > 0; i--) {
            s.push(path[money][i]);
            money -= path[money][i];
        }

        sb.append(dp[n][m]).append("\n");
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);

    }


}
