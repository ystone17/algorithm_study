import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] number, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp[n - 1] = -1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (number[i] < number[i + 1]) {
                dp[i] = i + 1;
            } else {
                int tempIdx = dp[i + 1];
                while (tempIdx > -1) {
                    if (number[i] < number[tempIdx]) {
                        break;
                    }
                    tempIdx = dp[tempIdx];
                }
                dp[i] = tempIdx;
            }
        }

        for (int i : dp) {
            if (i == -1) sb.append(i).append(" ");
            else sb.append(number[i]).append(" ");
        }

        System.out.println(sb);

    }

}
