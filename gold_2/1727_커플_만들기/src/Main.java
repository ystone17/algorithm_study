import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer> men = new ArrayList<>();
    static List<Integer> women = new ArrayList<>();

    static int[][] dp = new int[1001][1001];

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

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        if (man > woman) {
            System.out.println(solve(women, 0, men, 0));
        } else {
            System.out.println(solve(men, 0, women, 0));
        }
    }

    static int solve(List<Integer> small,
                      int smallIdx,
                      List<Integer> big,
                      int bigIdx) {
        if (smallIdx >= small.size() || bigIdx >= big.size()) {
            return -1;
        }

        if (dp[smallIdx][bigIdx] >= 0) {
            return dp[smallIdx][bigIdx];
        }

        var res = 1_000_000_000;
        var base = Math.abs(small.get(smallIdx) - big.get(bigIdx));

        for (int i = bigIdx; i <= big.size() - (small.size() - smallIdx); i++) {
            var s = solve(small, smallIdx + 1, big, i + 1);
            if (s == -1) {
                continue;
            }

            if (res > base + s) {
                res = base + s;
            }
        }

        return dp[smallIdx][bigIdx] = res;
    }

}
