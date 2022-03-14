import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            bw.write(1+"");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        BigInteger[] dp = new BigInteger[n];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.TWO;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        bw.write(dp[n-1].remainder(BigInteger.valueOf(10007)).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
