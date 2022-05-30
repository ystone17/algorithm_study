import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int tc, n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            dp = new int[n][n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(setDp(0, n - 1, 0)).append("\n");
        }
        System.out.println(sb);
    }

    static int setDp(int left, int right, int turn) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];


        if (turn % 2 == 0) {
            return dp[left][right] = Math.max(arr[left] + setDp(left + 1, right, turn + 1), setDp(left, right - 1, turn + 1) + arr[right]);
        } else {
            return dp[left][right] = Math.min(setDp(left + 1, right, turn + 1), setDp(left, right - 1, turn + 1));
        }
    }

}
