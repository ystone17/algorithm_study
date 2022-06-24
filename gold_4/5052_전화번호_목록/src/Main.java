import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int tc;
    static int n;

    public static void main(String[] args) throws IOException {

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (!trie.insert(br.readLine()))
                    ok = false;
            }

            if (!ok) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    static class Node {
        Map<Character, Node> childNode = new HashMap<>();
        boolean endOfWord;
    }

    static class Trie {
        Node rootNode = new Node();

        boolean insert(String word) {
            Node node = this.rootNode;

            for (char c : word.toCharArray()) {
                node = node.childNode.computeIfAbsent(c, key -> new Node());
                if (node.endOfWord) return false;
            }

            node.endOfWord = true;

            return node.childNode.size() == 0;
        }

        boolean search(String word) {
            Node node = this.rootNode;

            for (char c : word.toCharArray()) {
                node = node.childNode.get(c);
                if (node == null) return false;
            }

            return node.endOfWord;
        }
    }
}
