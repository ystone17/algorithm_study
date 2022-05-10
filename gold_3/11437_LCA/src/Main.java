import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v, tc, maxAncestor;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] ancestor;
    static int[] depths;

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());

        maxAncestor = (int) (Math.log(v) / Math.log(2)) + 1;
        ancestor = new int[maxAncestor][v + 1];
        depths = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        setAncestor(0, 1);

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(LCA(u, v)).append("\n");
        }

        System.out.println(sb);

    }

    static void setAncestor(int parent, int child) {
        depths[child] = depths[parent] + 1;
        ancestor[0][child] = parent;

        for (int i = 1; i < maxAncestor; i++) {
            ancestor[i][child] = ancestor[i - 1][ancestor[i - 1][child]];
        }

        for (Integer c : graph.get(child)) {
            if (parent == c) continue;
            setAncestor(child, c);
        }
    }


    static int LCA(int u, int v) {
        if (depths[u] < depths[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int binary = depths[u] - depths[v];
        int pos = 0;
        while (binary != 0){
            if((binary & 1) == 1){
                u = ancestor[pos][u];
            }
            binary >>= 1;
            pos++;
        }

        if (u == v) return u;

        for (int i = maxAncestor - 1; i >= 0; i--) {
            if (ancestor[i][u] != ancestor[i][v]) {
                u = ancestor[i][u];
                v = ancestor[i][v];
            }
        }

        return ancestor[0][u];
    }

}
