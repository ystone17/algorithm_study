import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int maxV;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] earlyAdaptor;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        maxV = Integer.parseInt(br.readLine());
        earlyAdaptor = new boolean[maxV + 1];
        dp = new int[maxV + 1][2];
        for (int i = 0; i < maxV + 1; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        for (int i = 0; i < maxV + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < maxV - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        earlyAdaptor[0] = true;
        int earlyAdaptor = findEarlyAdaptor(0, 1);
        System.out.println(earlyAdaptor);

    }

    static int findEarlyAdaptor(int parent, int cur) {
        int total = 1;

        if(dp[cur][0] == -1){
            earlyAdaptor[cur] = true;
            for (Integer next : tree.get(cur)) {
                if (next == parent) continue;
                int subTree = findEarlyAdaptor(cur, next);
                total += subTree;
            }
            dp[cur][0] = total;
        }

        if (earlyAdaptor[parent]) {
            if(dp[cur][1] == -1){
                int noAdaptor = 0;
                earlyAdaptor[cur] = false;
                for (Integer next : tree.get(cur)) {
                    if (next == parent) continue;
                    int subTree = findEarlyAdaptor(cur, next);
                    noAdaptor += subTree;
                }
                dp[cur][1] = noAdaptor;
                return Math.min(dp[cur][0], dp[cur][1]);
            }
        }

        return dp[cur][0];
    }
}
