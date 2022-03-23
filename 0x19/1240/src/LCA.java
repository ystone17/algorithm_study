import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LCA {

    static int v, m, maxExpo;
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[][] parents;
    static int[] depths, costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        maxExpo = (int) (Math.log(v) / Math.log(2));
        parents = new int[v + 1][maxExpo + 1];
        depths = new int[v + 1];
        costs = new int[v + 1];

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Vertex(v, cost));
            graph.get(v).add(new Vertex(u, cost));
        }
        depths[0] = -1;
        dp(1, 0, 0, 0);
        connection();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bw.write(costs[u] + costs[v] - costs[LCA(u, v)] * 2 + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void dp(int vertex, int parent, int depth, int totalCost) {
        depths[vertex] = depth;
        parents[vertex][0] = parent;

        for (Vertex child : graph.get(vertex)) {
            if (child.num == parent) continue;
            costs[child.num] = totalCost + child.cost;
            dp(child.num, vertex, depth + 1, totalCost + child.cost);
        }
    }

    static void connection() {
        for (int expo = 1; expo <= maxExpo; expo++) {
            for (int vertex = 1; vertex <= v; vertex++) {
                parents[vertex][expo] = parents[parents[vertex][expo - 1]][expo - 1];
            }
        }
    }

    static int LCA(int u, int v) {
        if (depths[u] < depths[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int expo = maxExpo; expo >= 0; expo--) {
            if (depths[parents[u][expo]] >= depths[v]) {
                u = parents[u][expo];
            }
        }

        int lca = u;

        if (u != v) {
            for (int expo = maxExpo; expo >= 0 ; expo--) {
                if(parents[u][expo] != parents[v][expo]){
                    u = parents[u][expo];
                    v = parents[v][expo];
                }
                lca = parents[u][expo];
            }

        }

        return lca;
    }


    static class Vertex {
        int num;
        int cost;

        public Vertex(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

}
