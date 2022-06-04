import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v, e;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] inEdge;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        inEdge = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            inEdge[v]++;
        }

        for (int i = 1; i < inEdge.length; i++) {
            if(inEdge[i] != 0) continue;
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            Integer curU = pq.poll();
            sb.append(curU).append(" ");

            for (Integer v : graph.get(curU)) {
                if(--inEdge[v] == 0){
                    pq.add(v);
                }
            }
        }

        System.out.println(sb);

    }
}
