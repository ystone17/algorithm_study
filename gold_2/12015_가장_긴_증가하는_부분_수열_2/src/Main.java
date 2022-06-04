import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, idx;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        idx = 1;
        for (int i = 1; i < arr.length; i++) {
            if (dp[idx - 1] < arr[i]) {
                dp[idx] = arr[i];
                idx++;
            } else {
                int lowerIdx = lower(arr[i]);
                dp[lowerIdx] = arr[i];
            }
        }

        System.out.println(idx);
    }

    static int lower(int k) {
        int left = 0;
        int right = idx;

        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
