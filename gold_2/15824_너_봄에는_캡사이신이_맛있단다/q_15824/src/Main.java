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

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long diff = (seq[j] - seq[i]) % MAX;
                int count = j - i - 1;
                sum = (sum + diff * (long) Math.pow(2, count)) % MAX;
            }
        }

        System.out.println(sum);
    }
}
