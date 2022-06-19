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

    static int n;
    static Star[] stars;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static int[] parent;

    static double answer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        stars = new Star[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double y = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            stars[i] = new Star(y, x);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Edge(i, j, getWeight(i, j)));
            }
        }

        int cnt = n - 1;
        while (cnt > 0) {
            Edge cur = pq.poll();

            if (find(cur.from) == find(cur.to)) continue;
            union(cur.from, cur.to);
            answer += cur.weight;
            cnt--;
        }

        System.out.println(Math.round(answer * 100) / 100.0);

    }

    static int find(int a) {
        if (parent[a] < 0) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    static double getWeight(int i, int j) {
        return Math.sqrt(Math.pow(stars[i].y - stars[j].y, 2) + Math.pow(stars[i].x - stars[j].x, 2));
    }

    static class Star {
        double y;
        double x;

        public Star(double y, double x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(weight, o.weight);
        }
    }
}
