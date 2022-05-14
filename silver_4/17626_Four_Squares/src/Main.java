import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int[] dp = new int[50000 + 1];
    static int[] squared = new int[223 + 1];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < squared.length; i++) {
            squared[i] = i * i;
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= 223; i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= 50000; i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }

}

