import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n <= 20) {
            int res = hanoi(n, 1, 3, 2);
            System.out.println(res);
            System.out.println(sb);
        } else {
            dp = new BigInteger[n + 1];
            dp[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1].multiply(BigInteger.TWO).add(BigInteger.ONE);
            }
            System.out.println(dp[n]);
        }
    }

    static int hanoi(int size, int from, int to, int extra) {
        if (size == 1) {
            if (n <= 20) sb.append(from).append(" ").append(to).append("\n");
            return 1;
        }

        int first = hanoi(size - 1, from, extra, to);
        if (n <= 20) sb.append(from).append(" ").append(to).append("\n");
        int second = hanoi(size - 1, extra, to, from);

        return first + second + 1;
    }
}
