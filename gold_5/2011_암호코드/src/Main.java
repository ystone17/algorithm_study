import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] number;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = br.readLine().toCharArray();

        if(number[0] == '0'){
            System.out.println(0);
            return;
        }

        dp = new int[number.length][2];

        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (number[i] != '0') {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] ) % 1000000;
            }

            int temp = Integer.parseInt("" + number[i - 1] + number[i]);
            if (temp > 0 && temp <= 26) {
                dp[i][1] = dp[i - 1][0];
            } else if (temp == 0) {
                System.out.println(0);
                return;
            }

        }

        System.out.println((dp[number.length - 1][0] + dp[number.length - 1][1] ) % 1000000);
    }

}
