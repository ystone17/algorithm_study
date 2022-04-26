import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, maxExpo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[] depth, dist;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());

        maxExpo = (int) (Math.log(v) / Math.log(2));
        parent = new int[v + 1][maxExpo + 1];
        depth = new int[v + 1];
        dist = new int[v + 1];

        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.get(p).add(new Vertex(child, d));
            graph.get(child).add(new Vertex(p, d));
        }

        dp(1, 0, 0, 0);
        connection();

        int max = 0;
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                max = Math.max(max, dist[i] + dist[j] - 2 * dist[LCA(i, j)]);
            }
        }

        System.out.println(max);

    }

    static void dp(int vertex, int parent, int depth, int totalCost) {
        Main.depth[vertex] = depth;
        Main.parent[vertex][0] = parent;

        for (Vertex child : graph.get(vertex)) {
            if (child.to == parent) continue;
            dist[child.to] = totalCost + child.value;
            dp(child.to, vertex, depth + 1, totalCost + child.value);
        }
    }

    static void connection() {
        for (int expo = 1; expo <= maxExpo; expo++) {
            for (int vertex = 1; vertex <= v; vertex++) {
                parent[vertex][expo] = parent[parent[vertex][expo - 1]][expo - 1];
            }
        }
    }

    static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int expo = maxExpo; expo >= 0; expo--) {
            if (depth[parent[u][expo]] >= depth[v]) {
                u = parent[u][expo];
            }
        }

        int lca = u;

        if (u != v) {
            for (int expo = maxExpo; expo >= 0 ; expo--) {
                if(parent[u][expo] != parent[v][expo]){
                    u = parent[u][expo];
                    v = parent[v][expo];
                }
                lca = parent[u][expo];
            }

        }

        return lca;
    }

    static class Vertex implements Comparable<Vertex> {
        int to;
        int value;

        public Vertex(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(value, o.value);
        }
    }
}
