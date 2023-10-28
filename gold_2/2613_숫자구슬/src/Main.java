import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, total;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
            total += seq[i + 1];
        }

        int left = 1;
        int right = total;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (possible(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }

    private static boolean possible(int k) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + seq[i] > k) {
                count++;
                sum = 0;
            }
            sum += seq[i];
        }

        return count == m;
    }


}
