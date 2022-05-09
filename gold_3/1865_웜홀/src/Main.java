import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int tc, v, e, w, from, to, weight;
    static List<Edge> edges;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[v + 1];
            edges = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, weight));
                edges.add(new Edge(to, from, weight));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, weight * -1));
            }

            sb.append(bellmanFord(1)).append("\n");
            System.out.println(Arrays.toString(dist));
        }
        System.out.println(sb);
    }

    static String bellmanFord(int start){
        Arrays.fill(dist, 100_000_000);
//        dist[start] = 0;

        for (int i = 0; i < v; i++) {

            for (Edge edge : edges) {
//                if(dist[edge.from] == Integer.MAX_VALUE) continue;

                if(dist[edge.to] > dist[edge.from] + edge.weight){
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    if(i == v-1) return "YES";
                }
            }


        }

        return "NO";
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
