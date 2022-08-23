import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            logic();
        }
        System.out.println(sb);

    }

    static int v, e, t;
    static int s, g, h;
    static List<List<Node>> graph;
    static int[] tArr;
    static int[][] dist;
    static int[] fin;

    static void logic() throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        int a, b, c;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, -1, c));
            graph.get(b).add(new Node(a, -1, c));
        }

        tArr = new int[t];
        for (int i = 0; i < t; i++) {
            tArr[i] = Integer.parseInt(br.readLine());
        }

        dist = new int[3][v + 1];
        dijkstra(s,0);
        dijkstra(g,1);
        dijkstra(h,2);
        Arrays.sort(tArr);

        for (int t : tArr) {
            if (dist[0][g] + dist[1][h] + dist[2][t] == dist[0][t]) {
                sb.append(t).append(" ");
            } else if (dist[0][h] + dist[2][g] + dist[1][t] == dist[0][t]) {
                sb.append(t).append(" ");
            }
        }
        sb.append("\n");
    }

    private static void dijkstra(int s, int distIdx) {
        Queue<Node> pq = new PriorityQueue<>();
        fin = new int[v + 1];
        Arrays.fill(dist[distIdx], Integer.MAX_VALUE);

        dist[distIdx][s] = 0;
        pq.add(new Node(s, -1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (fin[cur.to] == 1) continue;
            fin[cur.to] = 1;

            for (Node next : graph.get(cur.to)) {
                if (dist[distIdx][next.to] > dist[distIdx][cur.to] + next.weight) {
                    dist[distIdx][next.to] = dist[distIdx][cur.to] + next.weight;
                    pq.add(new Node(next.to, -1, dist[distIdx][next.to]));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int weight;

        public Node(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return to == node.to && from == node.from && weight == node.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(to, from, weight);
        }
    }
}



