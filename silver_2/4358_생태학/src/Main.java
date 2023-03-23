import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int total;
    static Map<String, Integer> cntByTree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String tree;

        while ((tree = br.readLine()) != null) {
            Integer cnt = cntByTree.getOrDefault(tree, 0);
            cntByTree.put(tree, cnt + 1);
            total++;
        }

        String[] keyArray = cntByTree.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        for (String key : keyArray) {
            sb.append(String.format("%s %.4f\n", key, (float) cntByTree.get(key) / total * 100));
        }

        System.out.println(sb);
    }
}
