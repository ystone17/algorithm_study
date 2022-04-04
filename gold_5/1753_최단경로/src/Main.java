import java.io.*;
import java.util.*;

public class Main {

    static int v, e, root;
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        visited = new int[v + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        root = Integer.parseInt(br.readLine());
        visited[root] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boolean ok = false;
            for (Vertex vertex : graph.get(u)) {
                if (vertex.v == v && vertex.weight > w) {
                    vertex.weight = w;
                    ok = true;
                    break;
                }
            }
            if (!ok) graph.get(u).add(new Vertex(v, w));
        }

        for (int i = 1; i <= v; i++) {
            Collections.sort(graph.get(i));
        }

        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Vertex next : graph.get(cur)) {
                if (visited[next.v] <= visited[cur] + next.weight) continue;
                visited[next.v] = visited[cur] + next.weight;
                q.add(next.v);
            }

        }

        for (int i = 1; i <= v; i++) {
            if (visited[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static class Vertex implements Comparable<Vertex> {
        int v;
        int weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return weight - o.weight;
        }
    }
}
