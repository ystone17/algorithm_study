import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] seq = new String[3];

    public static void main(String[] args) throws IOException {
        read();
        System.out.println(lcs());
    }

    private static int lcs() {
        char[] A = seq[0].toCharArray();
        char[] B = seq[1].toCharArray();
        char[] C = seq[2].toCharArray();
        int[][][] dp = new int[A.length + 1][B.length + 1][C.length + 1];

        for (int a = 1; a < A.length + 1; a++) {
            for (int b = 1; b < B.length + 1; b++) {
                for (int c = 1; c < C.length + 1; c++) {
                    if (A[a - 1] == B[b - 1] && B[b - 1] == C[c - 1]) {
                        dp[a][b][c] = dp[a - 1][b - 1][c - 1] + 1;
                    } else {
                        dp[a][b][c] = Math.max(dp[a - 1][b][c], Math.max(dp[a][b - 1][c], dp[a][b][c - 1]));
                    }
                }
            }
        }
        return dp[A.length][B.length][C.length];
    }

    private static void read() throws IOException {
        for (int i = 0; i < 3; i++) {
            seq[i] = br.readLine();
        }

    }
}
