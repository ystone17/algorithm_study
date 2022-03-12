import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][t + 1];
        int[] points = new int[t + 1];
        int n;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            points[i + 1] = n;
        }

        if ( t == 1){
            bw.write(points[1] + "");
            bw.flush();
            return;
        }

        // [0][] 이전 1칸점프
        // [1][] 이전 2칸점프
        dp[0][1] = points[1];
        dp[1][1] = points[1];

        dp[0][2] = points[1] + points[2];
        dp[1][2] = points[2];

        for (int i = 3; i <= t; i++) {
            dp[0][i] = dp[1][i-1] + points[i];
            dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + points[i];
        }


        bw.write(Math.max(dp[0][t], dp[1][t]) + "");
        bw.flush();
    }
}
