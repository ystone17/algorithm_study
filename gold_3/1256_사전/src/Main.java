import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        BigInteger target = BigInteger.valueOf(k);
        BigInteger start = BigInteger.ONE;
        BigInteger mid;
        BigInteger end;

        int len = n + m;

        for (int i = 0; i < len; i++) {
            if (n == 0 || m == 0) break;
            mid = start.add(c(n + m - 1, n - 1)).subtract(BigInteger.ONE);
            end = mid.add(c(n + m - 1, n));

            if (end.compareTo(target) < 0) {
                System.out.println(-1);
                return;
            }

            if (mid.compareTo(target) >= 0) {
                sb.append("a");
                n -= 1;
            } else {
                sb.append("z");
                m -= 1;
                start = mid.add(BigInteger.ONE);
            }
        }
        while (n-- != 0) {
            sb.append("a");
        }

        while (m-- != 0) {
            sb.append("z");
        }

        System.out.println(sb);

    }

    static BigInteger c(int n, int r) {
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            res = res.multiply(BigInteger.valueOf(n - i));
        }
        for (int i = 2; i <= r; i++) {
            res = res.divide(BigInteger.valueOf(i));
        }
        return res;
    }

}
