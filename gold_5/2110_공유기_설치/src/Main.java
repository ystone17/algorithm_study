import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, c;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        solve();
    }

    private static void solve() {
        int left = 0;
        int right = home[n - 1];

        while (left < right) {
            int mid = (left + right) / 2;

            if (getCount(mid) >= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);

    }

    private static int getCount(int dist) {
        int count = 1;
        int prev = home[0];

        for (int i = 1; i < home.length; i++) {
            if (home[i] - prev >= dist) {
                count++;
                prev = home[i];
            }
        }
        return count;
    }
}
