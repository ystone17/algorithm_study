import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp {
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

        int answer = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            int total= 0;
            for (int j = 0; j <= i-1; j++) {
                if(arr[j] <arr[i]){
                    total = Math.max(total, dp[j]);
                }
            }
            dp[i] += total;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
