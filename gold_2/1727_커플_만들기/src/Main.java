import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer> men = new ArrayList<>();
    static List<Integer> women = new ArrayList<>();
    static List<Integer> small, big;

    static int[][] dp;

    static int man;
    static int woman;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        man = Integer.parseInt(st.nextToken());
        woman = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < man; i++) {
            men.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < woman; i++) {
            women.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(men);
        Collections.sort(women);

        if (man < woman) {
            small = men;
            big = women;
        } else {
            small = women;
            big = men;
        }

        dp = new int[small.size()][big.size()];

        dp[0][0] = Math.abs(small.get(0) - big.get(0));
        for (int i = 1; i < big.size(); i++) {
            dp[0][i] = Math.min(dp[0][i - 1], Math.abs(small.get(0) - big.get(i)));
        }

        for (int i = 1; i < small.size(); i++) {
            for (int j = 0; j < big.size(); j++) {
                if (j < i) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }

                dp[i][j] = dp[i - 1][j - 1] + Math.abs(small.get(i) - big.get(j));
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[small.size() - 1][big.size() - 1]);
    }
}
