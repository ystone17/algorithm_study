import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int size = (1 + n) * n / 2;
        int[] a = new int[size + 1];
        int[] dp = new int[size + 1];

        int idx =1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                a[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int floor = 0;
        int left = 1;
        int i = 1;


        while (i < a.length) {
            left += floor;
            floor++;

            for (; i < left + floor && i < a.length; i++) {
                if (i == left) {
                    dp[i] = dp[i - floor + 1] + a[i];
                } else if (i == left + floor - 1) {
                    dp[i] = dp[i - floor] + a[i];
                } else {
                    dp[i] = Math.max(dp[i - floor + 1], dp[i - floor]) + a[i];
                }
            }

        }

        int answer = 0;
        for (int j = left; j < dp.length; j++) {
            answer = Math.max(answer, dp[j]);
        }

        System.out.println(answer);

    }

}
