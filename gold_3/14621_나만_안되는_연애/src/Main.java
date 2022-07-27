import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static char[] gender;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gender = new char[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        char[] genderInput = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            gender[i + 1] = genderInput[i * 2];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (gender[u] != gender[v]) {
                pq.add(new Edge(u, v, w));
            }
        }

        int count = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (find(cur.u) != find(cur.v)) {
                union(cur.u, cur.v);
                answer += cur.w;
                count++;
            }
        }

        if (count == n - 1) {
            sb.append(answer);
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static int find(int k) {
        if (parent[k] < 0) {
            return k;
        } else {
            return parent[k] = find(parent[k]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (parent[a] <= parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }


    private static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }
}
