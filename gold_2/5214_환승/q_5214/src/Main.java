import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, tubeSize, tubeMaxNum;
    static List<List<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dist, visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tubeSize = Integer.parseInt(st.nextToken());
        tubeMaxNum = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        List<Integer> temp = new ArrayList<>();
        for (int tubeNum = 0; tubeNum < tubeMaxNum; tubeNum++) {
            temp.clear();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < tubeSize; i++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }

            for (int left = 0; left < temp.size(); left++) {
                for (int right = left + 1; right < temp.size(); right++) {
                    int r = temp.get(right);
                    int l = temp.get(left);
                    graph.get(l).add(r);
                    graph.get(r).add(l);
                }
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        visited[1] = 1;
        for (Integer next : graph.get(1)) {
            dist[next] = 1;
            pq.add(new Node(next, 1));
        }

        for (int i = 0; i < n - 2; i++) {
            Node cur = pq.poll();
            if (cur == null) {
                break;
            }

            if (visited[cur.next] == 1) {
                continue;
            }
            visited[cur.next] = 1;

            for (Integer next : graph.get(cur.next)) {
                if (visited[next] == 0 && dist[next] >= cur.dist + 1) {
                    dist[next] = cur.dist + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        System.out.println(dist[n] == Integer.MAX_VALUE ? -1 : dist[n] + 1);
    }

    private static class Node implements Comparable<Node> {
        int next;
        int dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }
    }
}
