import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] townNum;
    static int[][] dp;
    static List<List<Integer>> tree = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        townNum = new int[n + 1];
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            townNum[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        System.out.println(Math.max(req(1, true, 0), req(1, false, 0)));
    }

    static int req(int townIdx, boolean isGreat, int parentIdx) {

        if (dp[townIdx][isGreat ? 1 : 0] != 0) return dp[townIdx][isGreat ? 1 : 0];

        int res = isGreat ? townNum[townIdx] : 0;

        for (Integer nextTown : tree.get(townIdx)) {
            if (nextTown == parentIdx) continue;
            int max = 0;

            if (!isGreat) max = Math.max(max, req(nextTown, true, townIdx));
            max = Math.max(max, req(nextTown, false, townIdx));

            res += max;
        }

        return dp[townIdx][isGreat ? 1 : 0] = res;
    }
}
