import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
//        String[] history = new String[n + 1];
//        history[1] = "1 ";

        int[] history = new int[n + 1];


        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            history[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                history[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                history[i] = i / 2;
            }
        }
//        bw.write(dp[n] + "\n");
//        bw.write(n + " ");
        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        while (history[n] != 0) {
//            bw.write(history[n] + " ");
            sb.append(history[n]).append(" ");
//            System.out.printf("%d ", history[n]);
            n = history[n];
        }
//        bw.flush();
//        bw.close();
        System.out.println(sb);
        br.close();
    }
}
