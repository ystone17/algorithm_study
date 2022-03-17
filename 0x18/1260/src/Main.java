import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e, startNum;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    //    static Stack<Integer> q = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        startNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 1; i <= v; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[v + 1];
        dfs(startNum);
//        dfs1();
        sb.append("\n");
        visited = new int[v + 1];
        bfs();

        System.out.println(sb);
    }

    static void bfs() {
        q.add(startNum);
        visited[startNum] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            List<Integer> vertex = graph.get(cur);

            for (int next : vertex) {
                if (visited[next] == 1) continue;

                q.add(next);
                visited[next] = 1;
            }

        }
    }

    static void dfs1(){
        Stack<Integer> stack = new Stack<>();

        stack.add(startNum);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur] == 1) continue;
            visited[cur] = 1;
            sb.append(cur).append(" ");

            List<Integer> vertex = graph.get(cur);

            for (int i = vertex.size() - 1; i >= 0; i--) {
                stack.add(vertex.get(i));
            }

        }
    }


    static void dfs(int num) {
        visited[num] = 1;
        sb.append(num).append(" ");

        List<Integer> vertex = graph.get(num);

        for (int next : vertex) {
            if(visited[next] == 1) continue;
            dfs(next);
        }
    }

}

