import java.io.*;
import java.util.*;

public class Main {

    static int v, m;
    static int[][] tree;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[v + 1][v + 1];
        visited = new int[v + 1];
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            tree[u][v] = length;
            tree[v][u] = length;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        for (int i = 1; i < v + 1; i++) {
                    visited[i] = 1;
                    dfs(i, i, tree[i][i]);
                    visited[i] = 0;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (tree[u][v] == 0) {
                bw.write(tree[v][u] + "\n");
            } else {
                bw.write(tree[u][v] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int root, int parent, int total) {

        for (int child : graph.get(parent)) {
            if (visited[child] == 1) continue;
            visited[child] = 1;
            tree[root][child] = total + tree[parent][child];
            dfs(root, child, total + +tree[parent][child]);
            visited[child] = 0;
        }
    }
}
