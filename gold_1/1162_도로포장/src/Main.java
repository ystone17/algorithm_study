import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int v, e, k;
    static List<List<Edge>> graph = new ArrayList<>();
    static long[][] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new long[v + 1][k + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, weight, 0));
            graph.get(to).add(new Edge(from, weight, 0));
        }

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], Long.MAX_VALUE);
        }

        pq.add(new Edge(1, 0, 0));
        visited[1][0] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to][cur.k] < cur.weight) {
                continue;
            }

            if (cur.k < k) {
                for (Edge next : graph.get(cur.to)) {
                    if (visited[next.to][cur.k + 1] > visited[cur.to][cur.k]) {
                        visited[next.to][cur.k + 1] = visited[cur.to][cur.k];
                        pq.add(new Edge(next.to, visited[next.to][cur.k + 1], cur.k + 1));
                    }
                }
            }

            for (Edge next : graph.get(cur.to)) {
                if (visited[next.to][cur.k] > visited[cur.to][cur.k] + next.weight) {
                    visited[next.to][cur.k] = visited[cur.to][cur.k] + next.weight;
                    pq.add(new Edge(next.to, visited[next.to][cur.k], cur.k));
                }
            }
        }

        long min = Long.MAX_VALUE;
        for (long i : visited[v]) {
            min = Math.min(min, i);
        }

        System.out.println(min);
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long weight;
        int k;

        public Edge(int to, long weight, int k) {
            this.to = to;
            this.weight = weight;
            this.k = k;
        }


        @Override
        public int compareTo(Edge o) {
            return Long.compare(weight, o.weight);
        }
    }

}
