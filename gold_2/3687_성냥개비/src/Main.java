import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, number;
    static int[] count;
    static int[] min = {-1, -1, 1, 7, 4, 2, 0, 8};
    static int[] max = {-1, -1, 1, 7, 4, 5, 9, 8};
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {


        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        for (int i = 9; i <= 100; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 2; j <= 7; j++) {
                dp[i] = Long.min(dp[i], dp[i - j] * 10 + min[j]);
            }
        }


        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            number = Integer.parseInt(br.readLine());
            sb.append(dp[number]).append(" ");

            {
                count = new int[7 + 1];
                initMaxCount(number);
                maxPq.clear();

                for (int i = 2; i <= 7; i++) {
                    for (int j = 0; j < count[i]; j++) {
                        maxPq.add(max[i]);
                    }
                }
                for (Integer integer : maxPq) {
                    sb.append(integer);
                }
                sb.append("\n");
            }

        }

        System.out.println(sb);
    }


    public static boolean initMaxCount(int number) {
        if (number == 0) {
            return true;
        }

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= 7; i++) {
            count[i]++;
            if (initMaxCount(number - i)) {
                return true;
            }
            count[i]--;
        }

        return false;
    }
}
