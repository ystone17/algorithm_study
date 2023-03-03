import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());


        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            int computerNum = Integer.parseInt(st.nextToken());
            int dependencyNum = Integer.parseInt(st.nextToken());
            int hackingComputer = Integer.parseInt(st.nextToken());

            int[] result = dijkstra(computerNum, dependencyNum, hackingComputer);

            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int computerNum, int dependencyNum, int hackingComputer) throws IOException {
        int[] dist = new int[computerNum + 1];
        Arrays.fill(dist, 123_456_789);
        dist[hackingComputer] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < computerNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < dependencyNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(b).add(new Node(a, time));
        }

        pq.add(new Node(hackingComputer, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph.get(cur.to)) {
                if (dist[next.to] > dist[cur.to] + next.time) {
                    dist[next.to] = dist[cur.to] + next.time;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        int[] result = new int[2];

        for (int i : dist) {
            if (i != 123_456_789) {
                result[0]++;
                result[1] = Math.max(result[1], i);
            }
        }

        return result;
    }

    private static class Node implements Comparable<Node> {
        int to;
        int time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

}
