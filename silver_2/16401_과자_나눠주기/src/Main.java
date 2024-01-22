import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, min = 1, max = Integer.MIN_VALUE, mid;
    static int[] snackLens;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        snackLens = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            snackLens[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snackLens[i]);
        }

        max++;
        while (min < max) {
            mid = (min + max) / 2;

            if (getCount(mid) >= n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }

    static int getCount(int l) {
        int count = 0;
        for (int snackLen : snackLens) {
            count += snackLen / l;
        }

        return count;
    }
}
