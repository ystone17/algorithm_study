import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e;
    static int[] visited;
    static int[][] answer;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        solve_dijkstra();
        solve_fluid();
    }

    static void solve_fluid() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        answer = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) continue;
                answer[i][j] = 10_000_000;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken()) - 1;
            int from = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            if (answer[to][from] != 0) {
                answer[to][from] = Math.min(answer[to][from], v);
            } else answer[to][from] = v;
        }

        for (int k = 0; k < v; k++) {
            for (int to = 0; to < v; to++) {
                for (int from = 0; from < v; from++) {
                    answer[to][from] = Math.min(answer[to][from], answer[to][k] + answer[k][from]);
                }
            }
        }

        for (int[] row : answer) {
            for (int i : row) {
                if (i == 10_000_000) System.out.printf("%d ", 0);
                else System.out.printf("%d ", i);
            }
            System.out.println();
        }

    }

    static void solve_dijkstra() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        answer = new int[v][v];
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()) - 1).
                    add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        for (int start = 0; start < v; start++) {
            dijkstra(start);
        }

        for (int[] row : answer) {
            for (int i : row) {
                if (i == Integer.MAX_VALUE) System.out.printf("%d ", 0);
                else System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }

    static void dijkstra(int start) {
        visited = new int[v];

        Queue<Node> pq = new PriorityQueue<>();
        Arrays.fill(answer[start], Integer.MAX_VALUE);

        pq.add(new Node(start, 0));

        answer[start][start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (visited[curNode.to] == 1) continue;
            visited[curNode.to] = 1;

            for (Node node : graph.get(curNode.to)) {
                if (answer[start][node.to] > answer[start][curNode.to] + node.value) {
                    answer[start][node.to] = answer[start][curNode.to] + node.value;
                    pq.add(new Node(node.to, answer[start][node.to]));
                }

            }

        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }
}
