import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
//    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> q = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[v + 1];


        int start, end;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int res =0;

        for (int i = 1; i <= v; i++) {
            if(visited[i] == 1) continue;

            q.add(i);
            visited[i] = 1;
            res++;


            while (!q.isEmpty()) {
//                int cur = q.poll();
                int cur = q.pop();

                System.out.println(cur);

                for (int next : graph.get(cur)) {
                    if(visited[next] == 1) continue;

                    q.add(next);
                    visited[next] = 1;
                }

            }


        }

        System.out.println(res);


    }
}
