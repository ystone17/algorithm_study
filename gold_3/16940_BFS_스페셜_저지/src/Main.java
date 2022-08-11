import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Set<Integer>> graph = new ArrayList<>();

    static Queue<Integer> bfsQ = new LinkedList<>();
    static Queue<Integer> answerQ = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) graph.add(new HashSet<>());
        visited = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) answerQ.add(Integer.parseInt(st.nextToken()));
        if(answerQ.peek() != 1) {
            System.out.println(0);
            return;
        }

        bfsQ.add(1);
        answerQ.poll();

        while (!bfsQ.isEmpty()) {
            Integer cur = bfsQ.poll();

            int size = graph.get(cur).size();


            for (int i = 0; i < size; i++) {
                if (!graph.get(cur).contains(answerQ.peek())) {
                    System.out.println(0);
                    return;
                }
                Integer poll = answerQ.poll();
                bfsQ.add(poll);
                graph.get(poll).remove(cur);
            }
        }
        System.out.println(1);

    }
}
