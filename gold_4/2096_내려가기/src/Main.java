import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] table, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        table = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = table[0][0];
        dp[0][1] = table[0][1];
        dp[0][2] = table[0][2];

        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            for (int j = 0; j < 3; j++) {
                for (int k = j-1; k <= j+1; k++) {
                    if(k == -1 || k == 3) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + table[i][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max ,dp[n-1][i]);
        }
        System.out.print(max + " ");

        dp[0][0] = table[0][0];
        dp[0][1] = table[0][1];
        dp[0][2] = table[0][2];

        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < 3; j++) {
                for (int k = j-1; k <= j+1; k++) {
                    if(k == -1 || k == 3) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + table[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min ,dp[n-1][i]);
        }
        System.out.print(min);

    }
}
