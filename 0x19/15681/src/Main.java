import java.io.*;
import java.util.*;

public class Main {

    static int v, r, query;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] subtree;
    static int[] p;
    static int[] isP;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        query = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            tree.add(new ArrayList<>());
        }

        subtree = new int[v + 1];
        p = new int[v + 1];
        isP = new int[v + 1];

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : tree.get(cur)) {
                if (p[cur] == next) continue;
                p[next] = cur;
                isP[cur] = 1;
                q.add(next);
            }
        }


        for (int i = 1; i < isP.length; i++) {
            if (isP[i] == 0) {
                subtree[i] = 1;
            }
        }

        dp(r);

        for (int i = 0; i < query; i++) {
            bw.write(subtree[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int vertex) {
        if (isP[vertex] == 0) {
            return subtree[vertex];
        }

        for (Integer child : tree.get(vertex)) {
            if(p[vertex] == child) continue;
            subtree[vertex] += dp(child);
        }
        subtree[vertex] += 1;

        return subtree[vertex];
    }


}
