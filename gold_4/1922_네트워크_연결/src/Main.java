import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int vNum, eNum;
    static int[] parent;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vNum = Integer.parseInt(br.readLine());
        eNum = Integer.parseInt(br.readLine());
        edges = new Edge[eNum];

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, value);
        }

        Arrays.sort(edges);

        parent = new int[vNum + 1];
        Arrays.fill(parent, -1);

        int total = 0;
        int count = 0;
        for (Edge edge : edges) {
            if(find(edge.from) == find(edge.to)) continue;
            total += edge.value;
            union(edge.from, edge.to);
            if(++count == vNum - 1) break;
        }
        System.out.println(total);
    }

    static int find(int a) {
        if (parent[a] < 0) return a;
        return parent[a] = find(parent[a]);
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

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int value;

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(value, o.value);
        }
    }
}
