import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, c;
    static Map<String, Integer> orderMap = new HashMap<>();
    static Map<String, Integer> countMap = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            String key = st.nextToken();
            orderMap.putIfAbsent(key, i);

            Integer value = countMap.getOrDefault(key, 0);
            countMap.put(key, value + 1);
        }

        for (String key : countMap.keySet()) {
            Integer order = orderMap.get(key);
            Integer count = countMap.get(key);

            pq.add(new Node(order, count, Integer.parseInt(key)));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int i = 0; i < cur.count; i++) {
                sb.append(cur.number).append(" ");
            }
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int order;
        int count;
        int number;

        public Node(int order, int count, int number) {
            this.order = order;
            this.count = count;
            this.number = number;
        }


        @Override
        public int compareTo(Node o) {
            if (count != o.count) {
                return Integer.compare(o.count, count);
            } else {
                return Integer.compare(order, o.order);
            }
        }
    }
}
