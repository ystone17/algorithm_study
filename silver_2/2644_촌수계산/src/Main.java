import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, e, m;
    static int[] dist, fin;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        fin = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int d = dijkstra();
        if (d == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(d);
        }
    }

    private static int dijkstra() {
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (fin[cur.to] == 1) continue;
            fin[cur.to] = 1;

            for (Integer next : graph.get(cur.to)) {
                if (dist[next] > dist[cur.to] + 1) {
                    dist[next] = dist[cur.to] + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        return dist[e];
    }

    private static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }


}
