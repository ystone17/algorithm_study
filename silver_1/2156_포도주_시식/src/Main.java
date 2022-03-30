import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        } else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        } else if (n == 3) {
            int res = arr[0] + arr[1] + arr[2] - Arrays.stream(arr).min().getAsInt();
            System.out.println(res);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = arr[0] + arr[1] + arr[2] - Arrays.stream(arr,0,3).min().getAsInt();

        for (int i = 3; i < n; i++) {
            // 먹는다
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
            // 안 먹는다
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n - 1]);


    }


}
