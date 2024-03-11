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

    static int[][] dp, partitionMin;

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

        dp = new int[small.size() + 1][big.size() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        partitionMin = new int[small.size() + 1][big.size() + 1];
        Arrays.fill(partitionMin[small.size()], 0);

        for (int y = small.size() - 1; y >= 0; y--) {
            for (int x = y + small.size() - 1; x >= y; x--) {

                var abs = Math.abs(small.get(y) - big.get(x));
                dp[y][x] = abs + partitionMin[y + 1][x + 1];
                partitionMin[y][x] = Math.min(dp[y][x], dp[y][x + 1]);
            }
        }


    }
}
