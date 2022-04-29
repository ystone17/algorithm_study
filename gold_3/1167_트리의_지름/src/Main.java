import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int v, maxIdx, max;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist, select;

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());

            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                graph.get(u).add(new Node(v, Integer.parseInt(st.nextToken())));
            }
        }

//        int next = dijkstra(1);
//        int res = dijkstra(next);
//        System.out.println(dist[res]);

        select = new int[v + 1];
        select[1] = 1;
        dfs(1, 0);
        select = new int[v + 1];
        select[maxIdx] = 1;
        dfs(maxIdx, 0);
        System.out.println(max);
    }

    static int dijkstra(int k){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        int[] select = new int[v + 1];

        int res = k;
        int max = 0;
        pq.add(new Node(k, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(select[cur.v] == 1) continue;
            select[cur.v] = 1;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    if (max < dist[next.v]) {
                        max = dist[next.v];
                        res = next.v;
                    }
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return res;
    }

    static void dfs(int k, int total) {
        if(total > max){
            max = total;
            maxIdx = k;
        }

        for (Node next : graph.get(k)) {
            if (select[next.v] == 1) continue;
            select[next.v] = 1;
            dfs(next.v, total + next.cost);
            select[next.v] = 0;
        }

    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
