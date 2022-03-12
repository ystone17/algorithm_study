import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                res = Math.min(res, dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                res = Math.min(res, dp[i / 2] + 1);
            }
            res = Math.min(res, dp[i - 1] + 1);
            dp[i] = res;
        }

        System.out.println(dp[n]);

    }
}
