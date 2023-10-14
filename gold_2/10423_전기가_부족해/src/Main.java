import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent;
    static int n, e, k, res, count;
    static List<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(u, v, w));
        }

        edgeList.sort(Comparator.comparingInt(o -> o.w));


        for (Edge edge : edgeList) {
            if (union(edge.u, edge.v)) {
                count++;
                res += edge.w;
            }

            if (count == n - 1) {
                break;
            }
        }

        System.out.println(res);


    }

    private static int find(int a) {
        if (a == -1 || parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }


    private static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
