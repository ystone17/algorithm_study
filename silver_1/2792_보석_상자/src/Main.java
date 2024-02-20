import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] counts;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        counts = new int[m];
        for (int i = 0; i < m; i++) {
            counts[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int left = 1;
        int right = 1_000_000_000;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (check(mid) > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static long check(int k) {
        long res = 0;
        for (int count : counts) {
            res += (count / k) + (count % k == 0 ? 0 : 1);
        }

        return res;
    }
}
