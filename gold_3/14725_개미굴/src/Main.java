import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        trie.print(0, trie.rootNode);
    }


    static class Trie {

        Node rootNode = new Node();

        void insert(String inputStr) {
            Node node = this.rootNode;

            String[] route = inputStr.split(" ");
            for (int i = 1; i < route.length; i++) {
                node = node.child.computeIfAbsent(route[i], key -> new Node());
            }

            node.isEnd = true;
        }

        void print(int cnt, Node node) {
            List<String> keyList = new ArrayList<>(node.child.keySet());
            Collections.sort(keyList);
            for (String key : keyList) {
                for (int i = 0; i < cnt; i++) {
                    System.out.print("--");
                }
                System.out.println(key);
                print(cnt + 1, node.child.get(key));
            }

        }

        static class Node {
            Map<String, Node> child = new HashMap<>();
            boolean isEnd;
        }
    }
}
