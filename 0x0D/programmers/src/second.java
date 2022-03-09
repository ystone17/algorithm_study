import java.math.BigInteger;

public class second {
    public static void main(String[] args) {
        int a = 1000;

        long solution = solution(a);
        System.out.println(solution);
    }

    static BigInteger[][] dp;

    public static long solution(int n) {

        BigInteger b = BigInteger.ZERO;

        initDp(n);

        int one = n;
        int two = 0;

        while (one >= 0) {
            b = b.add(dp[one + two][two]);
            two++;
            one -= 2;
        }

        return b.remainder(BigInteger.valueOf(1234567)).longValue() ;
    }

    private static void initDp(int n) {
        dp = new BigInteger[n + 1][n + 1];

        for (int y = 0; y < n + 1; y++) {
            for (int x = 0; x < n + 1; x++) {
                dp[y][x] = BigInteger.valueOf(0);
            }
        }


        for (int y = 1; y < n + 1; y++) {
            for (int x = 0; x < n + 1; x++) {
                if (y == x || x == 0) {
                    dp[y][x] = BigInteger.valueOf(1);
                } else if (x == 1) {
                    dp[y][x] = BigInteger.valueOf(y);
                } else {
                    dp[y][x] = dp[y - 1][x - 1].add(dp[y - 1][x]);
                }
            }
        }
    }


}
