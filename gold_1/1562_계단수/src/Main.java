import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][][] dp = new int[101][10][1 << 10];
    static final int max = 1000000000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());


        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 1; len < 100; len++) {
            for (int endNum = 0; endNum < 10; endNum++) {
                for (int bit = 0; bit < (1 << 10); bit++) {
                    if (dp[len][endNum][bit] == 0) continue;
                    if (endNum + 1 < 10) {
                        dp[len + 1][endNum + 1][add(bit, endNum + 1)] += dp[len][endNum][bit];
                        dp[len + 1][endNum + 1][add(bit, endNum + 1)] %= max;
                    }
                    if (endNum - 1 >= 0) {
                        dp[len + 1][endNum - 1][add(bit, endNum - 1)] += dp[len][endNum][bit];
                        dp[len + 1][endNum - 1][add(bit, endNum - 1)] %= max;
                    }
                }
            }
        }

        int res = 0;
        for (int endNum = 0; endNum < 10; endNum++) {
            res += dp[n][endNum][(1 << 10) - 1];
            res %= max;
        }

        System.out.println(res);
    }

    static int add(int origin, int target) {
        return origin | (1 << target);
    }
}
