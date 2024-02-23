import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
    static int n, total;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        var len = 0;
        for (int i = 0; i < n; i++) {
            var row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '0') {
                    continue;
                }

                if (row[j] >= 'a') {
                    len = row[j] - 'a' + 1;
                } else {
                    len = row[j] - 'A' + 27;
                }

                pq.add(new Edge(i, j, len));
                total += len;
            }
        }

        parent = new int[n];
        Arrays.fill(parent, -1);

        var count = 0;
        while (!pq.isEmpty()) {
            if (count >= n - 1) {
                break;
            }

            var edge = pq.poll();

            if (find(edge.from) == find(edge.to)) {
                continue;
            }

            union(edge.from, edge.to);
            total -= edge.weight;
            count++;
        }

        if (count < n - 1) {
            System.out.println(-1);
        } else {
            System.out.println(total);
        }
    }

    static int find(int x) {
        if (parent[x] < 0) {
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

        if (parent[a] < parent[b]) {
            parent[b] += parent[a];
            parent[a] = b;
        } else {
            parent[a] += parent[b];
            parent[b] = a;
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
