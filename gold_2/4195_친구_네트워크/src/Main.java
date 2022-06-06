import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int n;
    static List<Integer> parent;
    static Map<String, Integer> map;


    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int idx = 0;
            map = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            parent = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");

                Integer a = map.get(s[0]);
                if (a == null) {
                    a = idx++;
                    parent.add(-1);
                    map.put(s[0], a);
                }

                Integer b = map.get(s[1]);
                if (b == null) {
                    b = idx++;
                    parent.add(-1);
                    map.put(s[1], b);
                }

                union(a, b);
                sb.append(-parent.get(find(a))).append("\n");
            }

        }

        System.out.println(sb);

    }


    static int find(int k) {
        if (parent.get(k) < 0) {
            return k;
        } else {

            parent.set(k, find(parent.get(k)));
            return parent.get(k);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);


        if (a == b) return;

        if (parent.get(a) > parent.get(b)) {
            parent.set(a, parent.get(a) + parent.get(b));
            parent.set(b, a);
        } else {
            parent.set(b, parent.get(a) + parent.get(b));
            parent.set(a, b);
        }
    }
}
