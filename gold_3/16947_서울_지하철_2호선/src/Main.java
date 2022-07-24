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
    static List<List<Integer>> graph = new ArrayList<>();

    static int[] visited;
    static int[] parent;
    static int[] isCycle;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];
        parent = new int[n + 1];
        isCycle = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, 0);
        for (int i = 1; i < n + 1; i++) {
            if (isCycle[i] == 1) {
                sb.append(0).append(" ");
            } else {
                sb.append(getDist(i, i, 0)).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int now, int p) {
        if (visited[now] == 1) {
            isCycle[now] = 1;
            for (int i = p; isCycle[i] == 0; i = parent[i]) {
                isCycle[i] = 1;
            }
            return;
        }

        visited[now] = 1;
        parent[now] = p;

        for (Integer child : graph.get(now)) {
            if (child == p) continue;
            dfs(child, now);
        }
    }

    static int getDist(int now, int p, int dist) {
        if (isCycle[now] == 1) {
            return dist;
        }

        int res = Integer.MAX_VALUE;

        for (Integer child : graph.get(now)) {
            if (child == p) continue;
            res = Math.min(res, getDist(child, now, dist + 1));
        }

        return res;
    }
}
