import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (dp[len] < arr[i]) {
                dp[++len] = arr[i];
                total += arr[i];
                System.out.println(arr[i]);
            } else {
                int idx = lower(arr[i], len);
                if(idx == len){
                    total -= dp[idx];
                    total += arr[i];
                    System.out.printf("-%d +%d\n", dp[idx], arr[i]);
                }
                dp[idx] = arr[i];
            }
        }

        System.out.println(total);

    }

    static int lower(int num, int len) {
        int left = 0;
        int right = len;

        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if(num == 3) System.out.println("aaa "+left);
        return left;
    }

}
