import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1_000_000_007;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(seq);

        long sum = 0L;

        for (int i = 0; i < seq.length; i++) {
            long maxCaseCount = pow(2, i);
            sum += (seq[i] * maxCaseCount) % MAX;

            long minCaseCount = pow(2, n - 1 - i);
            sum -= (seq[i] * minCaseCount) % MAX;

            sum = (sum + MAX) % MAX;
        }

        System.out.println(sum % MAX);
    }

    private static long pow(int i, int k) {
        if (k == 0) {
            return 1;
        }

        if (k == 1) {
            return i;
        }

        long res = pow(i, k / 2);
        res = (res * res) % MAX;
        if (k % 2 == 1) {
            res *= i;
        }

        return res % MAX;
    }
}
