import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int k, l;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        Queue q = new Queue();

        for (int i = 0; i < l; i++) {
            q.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < q.list.size(); i++) {
            String s = q.list.get(i);
            int lastIdx = q.get(s);
            if (i != lastIdx) continue;
            sb.append(s).append("\n");
            cnt++;

            if (cnt == k) break;
        }

        System.out.println(sb);
    }

    static class Queue {
        private final List<String> list = new ArrayList<>();
        private final Map<String, Integer> map = new HashMap<>();
        private int cnt = 0;

        private void add(String s) {
            list.add(s);
            map.put(s, cnt++);
        }

        private int get(String s) {
            return map.get(s);
        }
    }
}
