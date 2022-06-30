import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int t, w;
    static int[][] fruitsPos;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        fruitsPos = new int[2][t];

        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(br.readLine()) - 1;

            fruitsPos[number][i] = 1;
        }

        dp = new int[2][t][w + 1];

        dp[0][0][0] = fruitsPos[0][0];
        dp[1][0][1] = fruitsPos[1][0];

        for (int time = 1; time < t; time++) {
            for (int move = 0; move <= time + 1 && move <= w; move++) {
                if (move == 0) {
                    dp[0][time][move] = dp[0][time - 1][move] + fruitsPos[0][time];
                } else if (move % 2 == 0) {
                    dp[0][time][move] = Math.max(dp[0][time - 1][move], dp[1][time - 1][move - 1]) + fruitsPos[0][time];
                } else {
                    dp[1][time][move] = Math.max(dp[1][time - 1][move], dp[0][time - 1][move - 1]) + fruitsPos[1][time];
                }
            }
        }

        int answer = 0;

        for (int i : dp[0][t - 1]) {
            answer = Math.max(answer, i);
        }
        for (int i : dp[1][t - 1]) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }


}
