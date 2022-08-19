import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, size;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        size++;

        for (int i = 1; i < n; i++) {
            if(dp[size-1] < arr[i]){
                dp[size] = arr[i];
                size++;
            } else{
                int idx = upper(arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(size);
    }

    static int upper(int k){
        int left = 0;
        int right = size;

        while (left < right){
            int mid = (left + right) / 2;

            if(dp[mid] <= k){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return left;
    }
}
