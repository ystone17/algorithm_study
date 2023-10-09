import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static List<Integer> bellmanNodes = new ArrayList<>();
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        sb.append(res.size()).append("\n");
        Collections.sort(res);
        for (Integer i : res) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == 1) {
                continue;
            }

            q.clear();
            bellmanNodes.clear();

            q.add(i);
            visited[i] = 1;
            bellmanNodes.add(i);

            while (!q.isEmpty()) {
                Integer cur = q.poll();

                for (Integer next : graph.get(cur)) {
                    if (visited[next] == 1) {
                        continue;
                    }

                    q.add(next);
                    visited[next] = 1;
                    bellmanNodes.add(next);
                }
            }

            if (bellmanNodes.size() == 1) {
                res.add(bellmanNodes.get(0));
            } else {
                res.add(bellmanFord());
            }
        }
    }

    private static int bellmanFord() {
        int size = bellmanNodes.size();
        int[][] dist = new int[size][size];

        for (int a = 0; a < size; a++) {
            for (int b = a; b < size; b++) {
                Integer aNode = bellmanNodes.get(a);
                Integer bNode = bellmanNodes.get(b);

                if (graph.get(aNode).contains(bNode)) {
                    dist[a][b] = 1;
                    dist[b][a] = 1;
                    continue;
                }

                dist[a][b] = 1_000_000;
                dist[b][a] = 1_000_000;
            }
        }


        for (int m = 0; m < size; m++) {
            for (int a = 0; a < size; a++) {
                for (int b = 0; b < size; b++) {
                    if (a == b) {
                        continue;
                    }

                    if (dist[a][b] > dist[a][m] + dist[m][b]) {
                        dist[a][b] = dist[a][m] + dist[m][b];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int a = 0; a < size; a++) {
            int temp = -1;

            for (int b = 0; b < size; b++) {
                if(dist[a][b] == 1_000_000) {
                    continue;
                }
                temp = Math.max(temp, dist[a][b]);
            }

            if (min == temp) {
                idx = bellmanNodes.get(idx) > bellmanNodes.get(a) ? a : idx;
                continue;
            }

            if (min > temp) {
                idx = a;
                min = temp;
            }
        }


        return bellmanNodes.get(idx);
    }
}
