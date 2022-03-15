import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int n;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
//            System.out.printf("%d %d\n", dp[n][0], dp[n][1]);
            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
        }

        bw.flush();


    }

}
