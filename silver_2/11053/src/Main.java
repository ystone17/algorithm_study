import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        String[] arrStr = br.readLine().split(" ");

        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        // i 번째를 취하는 부분 수열의 최대 값..
        dp[0] = 1;
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    value = Math.max(value, dp[j]);
                }
            }
            dp[i] = value + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
