import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static double[] arr;
    static double[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp = new double[n];

        dp[0] = arr[0];
        double max = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.printf("%.3f", max);


    }
}
