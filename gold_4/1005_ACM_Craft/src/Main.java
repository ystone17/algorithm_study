import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int tc, v, e;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] time, res;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            time = new int[v + 1];
            res =new int[v + 1];
            Arrays.fill(res, Integer.MAX_VALUE);

            graph.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < v + 1; i++) {
                graph.add(new ArrayList<>());
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(v).add(u);
            }

            for (int i = 1; i < v+1; i++) {
               dfs(i);
            }
            int target = Integer.parseInt(br.readLine());
            sb.append(res[target]).append("\n");
        }
        System.out.println(sb);

    }

    static int dfs(int k) {
        if(res[k] == Integer.MAX_VALUE){
            res[k] = time[k];
            for (Integer next : graph.get(k)) {
                res[k] = Math.max(res[k], dfs(next) + time[k]);
            }
        }

        return res[k];
    }
}
