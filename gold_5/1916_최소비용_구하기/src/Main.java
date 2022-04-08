import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e, start, end;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>();
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[] visited, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        visited = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Vertex(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int res = dijkstra(start, end);
        System.out.println(res);

    }

    static int dijkstra(int start, int end) {
        dist[start] = 0;
        pq.add(new Vertex(start, 0));

        while (!pq.isEmpty()) {

            Vertex cur = pq.poll();

            if (visited[cur.to] == 1) continue;
            visited[cur.to] = 1;

            for (Vertex next : graph.get(cur.to)) {
                if (visited[next.to] == 1) continue;
                if (dist[next.to] > next.cost + cur.cost) {
                    dist[next.to] = next.cost + cur.cost;
                    pq.add(new Vertex(next.to, dist[next.to]));
                }
            }
        }

        return dist[end];
    }

    static class Vertex implements Comparable<Vertex> {

        int to;
        int cost;

        public Vertex(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(cost, v.cost);
        }
    }
}
