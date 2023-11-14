import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Edge>> edges = new ArrayList<>();
    static int n, m;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = (Integer.parseInt(st.nextToken()) + 1) % 2;

            edges.get(a).add(new Edge(a, b, c));
        }

        int res = 0;
        res += kruskal(-1);
        res -= kruskal(1);
        System.out.println(res);
    }

    static int kruskal(int order) {
        int k = 0;
        int done = 0;

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> order * Integer.compare(o1.weight, o2.weight));


        for (List<Edge> edgeList : edges) {
            pq.addAll(edgeList);
        }

        while (done < n) {
            Edge cur = pq.poll();

            if (find(cur.from) == find(cur.to)) {
                continue;
            }

            union(cur.from, cur.to);
            k += cur.weight;
            done++;
        }

        return (int) Math.pow(k, 2);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
