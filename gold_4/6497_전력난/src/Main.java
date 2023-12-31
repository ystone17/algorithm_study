import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent;
    static int n, m, total, u, v, w;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            total = 0;
            pq.clear();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                pq.add(new Edge(u, v, w));
                total += w;
            }

            parent = new int[n + 1];
            Arrays.fill(parent, -1);


            for (int i = 0; i < n - 1; i++) {
                while (!pq.isEmpty()) {
                    Edge cur = pq.poll();

                    if (find(cur.from) == find(cur.to)) {
                        continue;
                    }

                    union(cur.from, cur.to);
                    total -= cur.weight;
                }
            }

            System.out.println(total);
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            parent[b] += parent[a];
            parent[a] = b;
        } else {
            parent[a] += parent[b];
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (parent[a] < 0) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
