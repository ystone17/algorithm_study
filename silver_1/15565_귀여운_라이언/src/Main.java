import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, result = Integer.MAX_VALUE;
    static int[] dolls = new int[1_000_000 + 1];
    static int[] index = new int[1_000_000 + 1];
    static int[] memoization = new int[1_000_000 + 1];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (dolls[i] == 2) {
                memoization[i] = memoization[i - 1];
                index[memoization[i]] = i;
                continue;
            }

            memoization[i] = memoization[i - 1] + 1;
            index[memoization[i]] = i;

            if (memoization[i] >= k) {
                result = Math.min(result, index[memoization[i]] - index[memoization[i] - k]);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
