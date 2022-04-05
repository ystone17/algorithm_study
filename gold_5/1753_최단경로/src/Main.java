import java.io.*;
import java.util.*;

public class Main {

    static int v, e, root;
    static List<List<Vertex>> graph = new ArrayList<>();
    static int[] dist;
    static int[] visited;
    static PriorityQueue<Vertex> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[v + 1];
        visited = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        root = Integer.parseInt(br.readLine());
        dist[root] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Vertex(v, w));
        }

        dijkstra();

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dijkstra() {
        minHeap.add(new Vertex(root, 0));
        while (!minHeap.isEmpty()){
            Vertex cur = minHeap.poll();

//            if (dist[cur.v] < cur.weight) {
//                continue;
//            }
            if (visited[cur.v] == 1) continue;
            visited[cur.v] = 1;

            for (Vertex next : graph.get(cur.v)) {
                if(visited[next.v] == 0 && dist[next.v] > dist[cur.v] + next.weight){
                    dist[next.v] = dist[cur.v] + next.weight;
                    minHeap.add(new Vertex(next.v, dist[next.v]));
                }
            }

        }
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
