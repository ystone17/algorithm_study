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

    static int a, b, answer;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int key = Integer.parseInt(st.nextToken());
            Integer value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int key = Integer.parseInt(st.nextToken());
            Integer value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) == 1) answer++;
        }

        System.out.println(answer);
    }
}
