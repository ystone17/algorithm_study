import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] time;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch(0, (long) time[time.length - 1] * m));
    }

    static long binarySearch(long left, long right) {

        while (left < right) {
            long mid = (left + right) / 2;

            long check = check(mid);

            if (check >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static long check(long t) {
        long sum = 0;

        for (int ti : time) {
            sum += t / ti;
        }

        return sum;
    }
}
