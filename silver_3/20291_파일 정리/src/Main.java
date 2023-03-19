import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Map<String, Integer> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine().split("\\.")[1];
            Integer value = map.getOrDefault(s, 0);
            map.put(s, value + 1);
        }

        map.keySet().stream().sorted().forEach(key -> {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        });

        System.out.println(sb);
    }
}
