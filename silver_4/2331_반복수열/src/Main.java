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

    static int a, p, idx;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        map.put(a, idx++);

        int now = a;
        int next = 0;
        while (true) {
            while (now != 0) {
                next += Math.pow(now % 10, p);
                now /= 10;
            }
            now = next;
            next = 0;
            if (map.containsKey(now)) {
                System.out.println(map.get(now));
                return;
            }

            map.put(now, idx++);
        }


    }
}
