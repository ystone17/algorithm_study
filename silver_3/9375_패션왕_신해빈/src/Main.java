import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<String, Integer> cloth = new HashMap<>();
    static int tc, n;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            cloth = new HashMap<>();
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String c = st.nextToken();
                Integer cnt = cloth.getOrDefault(c, 0);
                cloth.put(c, cnt + 1);
            }

            Iterator<String> iterator = cloth.keySet().iterator();
            int res = 1;
            while (iterator.hasNext()){
                res *= cloth.get(iterator.next()) + 1;
            }
            sb.append(res - 1).append("\n");
        }

        System.out.println(sb);
    }
}
