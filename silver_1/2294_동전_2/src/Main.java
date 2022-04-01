import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cost = new int[n + 1];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);

        for (int i = 0; i < n; i++) {
            cost[i + 1] = Integer.parseInt(br.readLine());
            if(cost[i + 1] <= k)
                dp[cost[i + 1]] = 1;
        }

        Arrays.sort(cost);
        for (int i = 1; i < cost.length; i++) {
            if(cost[i] > k) break;
            for (int j = cost[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - cost[i]] + 1);
            }
        }

        if (dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
