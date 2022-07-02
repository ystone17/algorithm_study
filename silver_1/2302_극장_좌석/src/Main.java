import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int seatNum, vipNum, answer = 1;
    static int[] dp = new int[41];

    public static void main(String[] args) throws IOException {
        seatNum = Integer.parseInt(br.readLine());
        vipNum = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        int lastSeat = 0;
        for (int i = 0; i < vipNum; i++) {
            int n = Integer.parseInt(br.readLine());
            answer *= dp[n - lastSeat - 1];
            lastSeat = n;
        }
        answer *= dp[seatNum - lastSeat];
        System.out.println(answer);
    }
}
