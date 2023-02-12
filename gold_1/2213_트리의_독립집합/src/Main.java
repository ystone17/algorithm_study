import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Integer>> tree = new ArrayList<>();
    static int n;
    static int[] g;
    static int[] used;
    static int[][] dp;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        g = new int[n + 1];
        used = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            g[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dp = new int[n + 1][2];
        int containRes = req(-1, 1, 1);
        dp = new int[n + 1][2];
        int notContainRes = req(-1, 1, 0);


        if(containRes > notContainRes) {
            used[1] = 1;
        }

        sb.append(Math.max(containRes, notContainRes)).append("\n");

        trace(1, 0, used[1]);

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }


    static int req(int parent, int me, int isContain) {
        if(dp[me][isContain] != 0) {
            return dp[me][isContain];
        }

        int res = 0;

        if (isContain == 1) {
            for (Integer child : tree.get(me)) {
                if (child == parent) continue;

                int subRes = req(me, child, 0);

                res += subRes;
            }
            return res + g[me];
        } else {
            for (Integer child : tree.get(me)) {
                if (child == parent) continue;

                dp[child][1] = req(me, child, 1);
                dp[child][0] = req(me, child, 0);

                if(dp[child][1] > dp[child][0]) {
                    used[child] = 1;
                } else {
                    used[child] = 0;
                }


                res += Math.max(dp[child][1], dp[child][0]);
            }
            return res;
        }
    }

    static void trace(int cur, int parent, int contain) {
        if(contain == 1) {
            pq.add(cur);
            for (Integer next : tree.get(cur)) {
                if(next == parent) continue;
                trace(next, cur, 0);
            }
        } else {
            for (Integer next : tree.get(cur)) {
                if(next == parent) continue;
                trace(next, cur, used[next]);
            }
        }
    }

}
