import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int V, E, start, end;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[V + 1];

        int right = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
            right = Math.max(right, w);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int res = binarySearch(1, right);
        System.out.println(res);
    }

    static int binarySearch(int left, int right){
        int res = 0;

        while (left <= right){
            int mid = (left + right) / 2;

            if(bfs(mid)){
                left = mid + 1;
                res = Math.max(res, mid);
            } else{
                right = mid -1;
            }
        }

        return res;
    }


    private static boolean bfs(int mid) {
        visited = new int[V + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start] = 1;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Node next : graph.get(cur)) {
                if(next.value >= mid){
                    if(next.to == end) return true;
                    if (visited[next.to] == 1 ) continue;
                    visited[next.to] = 1;
                    q.add(next.to);
                }
            }
        }

        return false;
    }

    private static class Node {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
