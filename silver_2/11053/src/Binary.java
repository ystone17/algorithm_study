import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        String[] arrStr = br.readLine().split(" ");

        for (int i = 0; i < arrStr.length; i++) {
            arr[i + 1] = Integer.parseInt(arrStr[i]);
        }

        int len = 0;
        dp[++len] = arr[1];
        for (int i = 2; i <= n; i++) {
            if(arr[i] > dp[len]){
                dp[++len] = arr[i];
            } else {
                dp[lower(1, len, arr[i])] = arr[i];
            }
        }
        System.out.println(len);
    }

    static int lower(int left, int right, int k){


        while (left < right){
            int mid = (left + right) / 2;
            if(dp[mid] >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
