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
    static int v, e, from, to, w;
    static int max = 987654321;
    static long[] dist;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new long[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, w));
        }

        if (bellmanFord()) {
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == max) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }


    }

    private static boolean bellmanFord() {
        Arrays.fill(dist, max);
        dist[1] = 0;

        for (int i = 0; i < v; i++) {
            for (int from = 1; from < graph.size(); from++) {

                if (dist[from] == max) continue;

                for (Node node : graph.get(from)) {
                    if (dist[node.to] > dist[from] + node.w) {
                        dist[node.to] = dist[from] + node.w;
                        if (i == v - 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    static class Node {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
