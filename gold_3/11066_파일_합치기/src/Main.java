import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc, n;
    static long res;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Long> list = new LinkedList<>();
    static long[] file;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {

            n = Integer.parseInt(br.readLine());
            file = new long[n];
            dp = new long[n][n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long e = Integer.parseInt(st.nextToken());
                file[i] = e;
                dp[i][i] = e;
            }




        }
        System.out.println(sb);
    }
}
