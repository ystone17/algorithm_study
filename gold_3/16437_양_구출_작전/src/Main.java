import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Node[] nodeArr;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nodeArr = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        nodeArr[1] = new Node(0, 0);
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String animal = st.nextToken();
            long count = Long.parseLong(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            Node node = animal.equals("S") ? new Node(count, 0) : new Node(0, count);
            nodeArr[i] = node;
            graph.get(parent).add(i);
        }

        System.out.println(getCount(1));

    }

    static long getCount(int idx) {
        long sum = nodeArr[idx].sheep - nodeArr[idx].wolf;

        for (Integer child : graph.get(idx)) {
            sum += getCount(child);
        }

        return sum < 0 ? 0 : sum;
    }

    static class Node {
        long sheep;
        long wolf;

        public Node(long sheep, long wolf) {
            this.sheep = sheep;
            this.wolf = wolf;
        }
    }
}
