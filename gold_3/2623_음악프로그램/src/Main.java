import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] inDegree;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int singerNum = Integer.parseInt(st.nextToken());
            if(singerNum == 0) continue;
            int parent = Integer.parseInt(st.nextToken());
            for (int j = 1; j < singerNum; j++) {
                int child = Integer.parseInt(st.nextToken());
                graph.get(parent).add(child);
                inDegree[child]++;
                parent = child;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            sb.append(cur).append("\n");
            n--;

            for (Integer child : graph.get(cur)) {
                if(--inDegree[child] == 0) q.add(child);
            }
        }

        if(n != 0) {
            System.out.println(0);
        } else{
            System.out.println(sb);
        }

    }
}

