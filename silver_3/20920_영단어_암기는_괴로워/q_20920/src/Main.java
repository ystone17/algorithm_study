import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int n, m;
    static Map<String, Integer> map = new HashMap<>();
    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() < m) continue;

            Integer cnt = map.getOrDefault(input, 0);
            map.put(input, cnt + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        Collections.sort(nodes);
        for (Node node : nodes) {
            sb.append(node.word).append("\n");
        }

        System.out.println(sb);
    }

    static private class Node implements Comparable<Node> {
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (cnt != o.cnt) {
                return Integer.compare(o.cnt, cnt);
            }

            if (word.length() != o.word.length()) {
                return Integer.compare(o.word.length(), word.length());
            }

            return word.compareTo(o.word);
        }
    }
}
