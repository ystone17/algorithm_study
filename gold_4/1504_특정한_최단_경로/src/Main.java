import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[] dist, visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Vertex(v, d));
            graph.get(v).add(new Vertex(u, d));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int middle = dijkstra(a, b);
        if (middle == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int toA = dijkstra(1, a);
        int bToN = dijkstra(b, v);

        int toB = dijkstra(1, b);
        int AToN = dijkstra(a, v);

        if ((toA == Integer.MAX_VALUE || bToN == Integer.MAX_VALUE) && (toB == Integer.MAX_VALUE || AToN == Integer.MAX_VALUE)) {
            System.out.println(-1);
            return;
        }

        System.out.println(middle + Math.min(toA + bToN, toB + AToN));

    }

    static int dijkstra(int start, int end) {
        visited = new int[v + 1];
        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        pq.add(new Vertex(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (visited[cur.to] == 1) continue;
            visited[cur.to] = 1;

            if (cur.to == end) break;

            for (Vertex next : graph.get(cur.to)) {
                if (visited[next.to] == 0 && dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    pq.add(new Vertex(next.to, dist[next.to]));
                }
            }

        }

        return dist[end];
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
