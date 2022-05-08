import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v, e;
    static int[] finished;
    static int[] parent;
    static long[] dist;
    static List<List<Node>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        dist = new long[v + 1];
        parent = new int[v + 1];
        finished = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        dijkstra(start);

        long d = dist[end];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (end != 0) {
            count++;
            stack.push(end);
            end = parent[end];
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        String route = sb.toString();
        sb = new StringBuilder();
        sb.append(d).append("\n").append(count).append("\n").append(route);

        System.out.println(sb);

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (finished[curNode.to] == 1) continue;
            finished[curNode.to] = 1;

            for (Node next : graph.get(curNode.to)) {
                if (finished[next.to] == 0 && dist[next.to] > dist[curNode.to] + next.weight) {
                    dist[next.to] = dist[curNode.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                    parent[next.to] = curNode.to;
                }
            }


        }
    }


    static class Node implements Comparable<Node> {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(weight, o.weight);
        }
    }
}
