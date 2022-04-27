import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] degree, answer;
    static int n, m;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        degree = new int[n + 1];
        answer = new int[n];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            degree[v]++;
        }

        TopologicalSort();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    private static boolean TopologicalSort() {
        int idx = 0;
        for (int i = 1; i < degree.length; i++) {
            if(degree[i] == 0) q.add(i);
        }

        for (int i = 0; i < n; i++) {
            if(q.isEmpty()) return false;
            int cur = q.poll();
            answer[idx++] = cur;

            for (Integer next : graph.get(cur)) {
                degree[next]--;
                if(degree[next] == 0) q.add(next);
            }

        }
        return true;
    }
}
