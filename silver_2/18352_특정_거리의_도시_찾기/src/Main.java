import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k, x;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Integer next : graph.get(cur.to)) {
                if (dist[next] > dist[cur.to] + 1) {
                    dist[next] = dist[cur.to] + 1;
                    pq.add(new Node(next, dist[cur.to] + 1));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }
    }
}
