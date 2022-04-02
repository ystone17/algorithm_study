import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc, n;
    static int[] visited;
    static Node[] nodes;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            visited = new int[n + 2];
            nodes = new Node[n + 2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(i, y, x);
            }


            visited[0] = 1;
            Queue<Node> q = new LinkedList<>();
            q.add(nodes[0]);

            boolean ok = false;
            while (!q.isEmpty()){
                Node cur = q.poll();

                for (int i = 1; i <= n + 1; i++) {
                    Node next = nodes[i];

                    if(visited[next.index] == 1) continue;
                    if(Math.abs(cur.y - next.y) + Math.abs(cur.x - next.x) > 1000) continue;
                    if(i == n+1) {
                        ok = true;
                        break;
                    }

                    q.add(next);
                    visited[next.index] = 1;
                }
                if(ok) break;
            }
            sb.append(ok ? "happy\n" : "sad\n");
        }
        System.out.println(sb);

    }

    static class Node {
        int index;
        int y;
        int x;

        public Node(int index, int y, int x) {
            this.index = index;
            this.y = y;
            this.x = x;
        }
    }

    static boolean dfs(int nodeNum) {
        for (int next = 1; next <= n + 1; next++) {
            if (visited[next] == 1) continue;
            if (Math.abs(nodes[nodeNum].y - nodes[next].y) + Math.abs(nodes[nodeNum].x - nodes[next].x) > 1000) continue;
            if (next == n + 1) return true;
            visited[next] = 1;
            if (dfs(next)) return true;
//            visited[next] = 0;
        }

        return false;
    }
}



