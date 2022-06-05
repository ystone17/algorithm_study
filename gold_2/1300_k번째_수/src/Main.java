import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;


        while (left < right) {
            int mid = (left + right) / 2;

            if (getCount(mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }

    private static int getCount(int k) {

        int res = 0;

        for (int i = 1; i <= n; i++) {
            res += Math.min(n, k / i);
        }

        return res;
    }
}
