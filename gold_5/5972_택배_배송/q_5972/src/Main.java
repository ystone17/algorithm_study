import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static List<List<Edge>> graph = new ArrayList<>();
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static int n, m;
    private static int[] dist, done;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        dist = new int[n + 1];
        done = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()) {
            var cur = pq.poll();

            if(done[cur.to] == 1) {
                continue;
            }
            done[cur.to] = 1;

            for (Edge next : graph.get(cur.to)) {
                if(dist[next.to] > cur.weight + next.weight) {
                    dist[next.to] = cur.weight + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }

        }

        System.out.println(dist[n]);
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
