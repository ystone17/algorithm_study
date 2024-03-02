import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer> men = new ArrayList<>();
    static List<Integer> women = new ArrayList<>();
    static int[] memoization;
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
        memoization = new int[Math.min(man, woman)];
        memoization[memoization.length - 1] = Math.abs(men.get(man - 1) - women.get(woman - 1));
        for (int idx = memoization.length - 2; idx >= 0; idx--) {
            var i = memoization.length - idx;
            memoization[idx] = memoization[idx + 1] + Math.abs(men.get(man - i) - women.get(woman - i));
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        if (man > woman) {
            System.out.println(backTracking(women, 0, men, 0));
        } else {
            System.out.println(backTracking(men, 0, women, 0));
        }
    }

    static int backTracking(List<Integer> small,
                            int smallIdx,
                            List<Integer> big,
                            int bigIdx) {
        if (smallIdx >= small.size()) {
            return 0;
        }

        if (dp[smallIdx][bigIdx] != -1) {
            return dp[smallIdx][bigIdx];
        }

        if (big.size() - bigIdx == small.size() - smallIdx) {
            return memoization[smallIdx];
        }

        var minBt = Integer.MAX_VALUE;
        var bIdx = bigIdx;
        while (small.size() - smallIdx != big.size() - bIdx) {
            var cur = Math.abs(small.get(smallIdx) - big.get(bigIdx));
            var res = backTracking(small, smallIdx + 1, big, bigIdx + 1);
            minBt = Math.min(minBt, cur + res);
            bIdx++;
        }

        return dp[smallIdx][bigIdx] = minBt;
    }

}
