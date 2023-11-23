import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX_NUM = 100_000;

    static int n, k;
    static int[] seq;
    static int[][] counting;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = new int[n + 1];
        counting = new int[MAX_NUM + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= MAX_NUM; j++) {
                counting[j][i + 1] = counting[j][i];
            }
            counting[seq[i + 1]][i + 1]++;
        }

        int left = 0;
        int right = n;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (ok(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }

    static boolean ok(int mid) {
        boolean isOk;
        for (int i = 1; i <= n - mid + 1; i++) {
            isOk = true;
            for (int j = 1; j <= MAX_NUM; j++) {
                if (counting[j][i + mid - 1] - counting[j][i - 1] > k) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                return true;
            }
        }

        return false;
    }
}
