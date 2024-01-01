import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int n;
    static int[] heights, ancestors;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            read();

            var root = findRoot();
            initHeights(root, 0);

            st = new StringTokenizer(br.readLine());
            var u = Integer.parseInt(st.nextToken());
            var v = Integer.parseInt(st.nextToken());

            sb.append(lca(u, v)).append("\n");
        }

        System.out.println(sb);
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());

        heights = new int[n + 1];
        ancestors = new int[n + 1];
        graph.clear();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            var parent = Integer.parseInt(st.nextToken());
            var child = Integer.parseInt(st.nextToken());

            graph.get(parent).add(child);
            ancestors[child] = parent;
        }
    }

    private static int findRoot() {
        for (int i = 1; i < ancestors.length; i++) {
            if (ancestors[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    private static void initHeights(int root, int h) {
        heights[root] = h;

        for (Integer child : graph.get(root)) {
            initHeights(child, h + 1);
        }
    }

    private static int lca(int u, int v) {
        if (heights[u] > heights[v]) {
            var temp = u;
            u = v;
            v = temp;
        }

        while (heights[u] != heights[v]) {
            v = ancestors[v];
        }

        while (u != v) {
            u = ancestors[u];
            v = ancestors[v];
        }

        return u;
    }

}
