import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MOD = 10007;

    static int n, res;
    static int[][] combine = new int[53][53];

    public static void main(String[] args) throws IOException {
        combine[0][0] = 1;

        for (int n = 0; n < 52; n++) {
            combine[n][0] = 1;
            for (int r = 1; r <= n - 1; r++) {
                combine[n][r] = (combine[n - 1][r - 1] + combine[n - 1][r]) % MOD;
            }
            combine[n][n] = 1;
        }

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n / 4; i++) {
            if (i % 2 == 1) {
                res = (res + combine[13][i] * combine[52 - i * 4][n - i * 4]) % MOD;
                continue;
            }

            res = (res + MOD - combine[13][i] * combine[52 - i * 4][n - i * 4]) % MOD;
        }

        System.out.println(res);
    }
}
